/**
 * Classe conexao é utilizada para fazer toda a comunicação com o Banco de
 * Dados. Tabela SIP codigo = Numeração Automatica descricao = Texto peso =
 * Numero cor = Texto qtd_estoque = Numero preco = Numero
 */
import java.sql.*;
import java.util.Vector;

public class conexao {
  Connection conn = null;
  Statement s = null;
  ResultSet rs = null;

  /**
   * Construtor que quando instanciado cria uma conexão com o BD.
   */
  public conexao() {
    try {
      // Faz a conexao com o Banco de dados Access chamado SIP.mdb
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      conn = DriverManager.getConnection("jdbc:odbc:" + "DRIVER={Microsoft Access Driver (*.mdb)};"
          + "DBQ=" + "C:/SIP/SIP.mdb", "", "");
      s = conn.createStatement();
    } catch (Exception e) {
      // Caso ocorra algum erro apenas ignora e não conecta.
    }
  }

  /**
   * Função para cadastrar os valores na tabela SIP.
   * 
   * @param descricao
   * @param peso
   * @param cor
   * @param qtd_estoque
   * @param preco
   */
  public boolean inserir(String descricao, String peso, String cor, String qtd_estoque, String preco) {
    try {
      //Cadastra os valores na tabela sip
      s.executeQuery("insert into SIP (DESCRICAO, PESO, COR, QTD_ESTOQUE, PRECO) values (\'"
          + descricao + "\' , " + peso + ", \'" + cor + "\', " + qtd_estoque + " , " + preco + ")");
      // caso seja cadastrado com sucesso returna true
      return true;
    } catch (Exception e) {
      // Caso ocorra algum erro para cadastrar retorna false
      return false;
    }
  }

  /**
   * Função para remover valores da tabela SIP.
   * 
   * @param num
   */
  public boolean deletar(int num) {
    try {
      // Deleta um registro de acordo com o parametro passado
      s.executeQuery("delete from SIP where CODIGO = " + num);
      // Caso seja deletado com sucesso returna true
      return true;
    } catch (Exception e) {
      // Caso ocorra algum erro para deletar retorna false
      return false;
    }
  }

  /**
   * Função para alterar valores a tabela SIP.
   * 
   * @param num
   * @param descricao
   * @param peso
   * @param cor
   * @param qtd_estoque
   * @param preco
   */
  public boolean alterar(String num, String descricao, String peso, String cor, String qtd_estoque,
      String preco) {
    try {
      //Altera um registro de acordo com o parametro passado
      s.executeUpdate("update SIP set DESCRICAO = \'" + descricao + "\', PESO = " + peso
          + ", COR = \'" + cor + "\', QTD_ESTOQUE = " + qtd_estoque + ", PRECO = " + preco
          + " where CODIGO = " + num);
      return true;
    } catch (Exception e) {
      // Caso ocorra algum erro para alterar retorna false
      return false;
    }
  }

  /**
   * Função para achar o codigo automatico da peça.
   * 
   * @return
   */
  public String novoCodigo() {
    try {
      // Busca pelo ultimo valor de código e incrementa em 1.
      rs = s.executeQuery("select max(CODIGO)+1 from SIP");
      /*
       * Avança o resultset para pegar o codigo e coloca em uma variavel string
       * para retorno.
       */
      rs.next();
      String codigo = rs.getString("Expr1000");
      return codigo;
    } catch (Exception e) {
      /*
       * Caso ocorra algum erro é retornado a String "1" apenas para
       * preenchimento do campo que o utilizar.
       */
      return "1";
    }
  }

  /**
   * Função para selecionar valores da tabela SIP. É retornado um Vector com
   * todos os campos da tabela exceto o campo codigo.
   * 
   * @param num
   */
  public Vector selecionar(String num) {
    Vector v = new Vector();
    try {
      // Altera um registro de acordo com o parametro passado
      // Cria um objeto ResultSet para a tabela resultante da consulta
      rs = s
          .executeQuery("select DESCRICAO, PESO, COR, QTD_ESTOQUE, PRECO from SIP where CODIGO = "
              + num);
      // Caso tenha resultado a consulta é adicionado os dados no Vector
      if (rs.next()) {
        // Pega o campo descricao
        v.addElement(rs.getString("DESCRICAO"));
        // Pega o campo peso
        v.addElement(rs.getString("PESO"));
        // Pega o campo cor
        v.addElement(rs.getString("COR"));
        // Pega o campo qtd_estoque
        v.addElement(rs.getString("QTD_ESTOQUE"));
        // Pega o campo preco
        v.addElement(rs.getString("PRECO"));
      }
      // Retorna o Vector.
      return v;
    } catch (Exception e) {
      // Caso de algum erro retorna o Vector com null
      return v;
    }
  }

  /**
   * Função para alterar valores de QUANTIDADE na tabela SIP.
   * 
   * @param num
   * @param qtd_estoque
   */
  public boolean alterarQuant(String num, String qtd_estoque) {
    try {
      //Altera um registro de acordo com os parametros passado.
      s.executeUpdate("update SIP set QTD_ESTOQUE = " + qtd_estoque + " where CODIGO = " + num);
      // Caso tenha atualizado com sucesso retorna true.
      return true;
    } catch (Exception e) {
      // Caso ocorra algum erro retorna false.
      return false;
    }
  }

  /**
   * Função para fechar a conexão com o banco de dados.
   */
  public void fecharConexao() {
    //Verifica se existe conexão com o BD.
    if (conn != null) {
      try {
        // Fecha a conexao com o Banco de dados
        if (rs != null)
          rs.close();
        s.close();
        conn.close();
      } catch (Exception e) {
        // Caso ocorra algum erro apenas ignora e não desconecta.
      }
    }
  }
}