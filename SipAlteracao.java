/**
 * Tela de alteração, onde o usuario pode estar consultando o cadastro de uma
 * peça e alterando qualquer parte do cadastro.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class SipAlteracao extends JFrame {
  JTextField txtNum = new JTextField();
  JTextField txtDesc = new JTextField();
  JTextField txtPeso = new JTextField();
  JTextField txtCor = new JTextField();
  JTextField txtQuant = new JTextField();
  JTextField txtPreco = new JTextField();
  JButton btnPesquisar = new JButton();
  JButton btnAlterar = new JButton();
  JButton btnLimpar = new JButton();
  JButton btnFechar = new JButton();
  JLabel lblTitulo = new JLabel();
  JLabel lblNumero = new JLabel();
  JLabel lblDescricao = new JLabel();
  JLabel lblPeso = new JLabel();
  JLabel lblCor = new JLabel();
  JLabel lblQuantidade = new JLabel();
  JLabel lblPreco = new JLabel();
  conexao conx = new conexao();

  /**
   * Contrutor que chama o metodo para preencher a tela e define o tamanho da tela.
   */
  public SipAlteracao() {
    try {
      // Chama o metodo para preencher minha tela.
      iniciar();
      // Dimensão da minha tela
      setSize(400, 300);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Metodo que preenche a tela com os botões, labels, etc...
   * @throws Exception
   */
  private void iniciar() throws Exception {
    this.getContentPane().setLayout(null);
    txtNum.setFont(new Font("Verdana", 1, 10));
    txtNum.setBounds(new Rectangle(100, 65, 100, 22));
    txtDesc.setFont(new Font("Verdana", 1, 10));
    txtDesc.setBounds(new Rectangle(100, 95, 250, 22));
    txtPeso.setFont(new Font("Verdana", 1, 10));
    txtPeso.setBounds(new Rectangle(100, 125, 100, 22));
    txtCor.setFont(new Font("Verdana", 1, 10));
    txtCor.setBounds(new Rectangle(100, 155, 100, 22));
    txtQuant.setFont(new Font("Verdana", 1, 10));
    txtQuant.setBounds(new Rectangle(100, 185, 100, 22));
    txtPreco.setFont(new Font("Verdana", 1, 10));
    txtPreco.setBounds(new Rectangle(100, 215, 100, 22));
    btnPesquisar.setLabel("Pesquisar");
    btnPesquisar.setFont(new Font("Verdana", 1, 10));
    btnPesquisar.setBounds(new Rectangle(230, 60, 100, 22));
    btnPesquisar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPesquisar_actionPerformed(e);
      }
    });
    btnAlterar.setLabel("Alterar");
    btnAlterar.setFont(new Font("Verdana", 1, 10));
    btnAlterar.setBounds(new Rectangle(90, 260, 100, 22));
    btnAlterar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAlterar_actionPerformed(e);
      }
    });
    btnAlterar.setEnabled(false);
    btnLimpar.setLabel("Limpar");
    btnLimpar.setFont(new Font("Verdana", 1, 10));
    btnLimpar.setBounds(new Rectangle(210, 260, 100, 22));
    btnLimpar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnLimpar_actionPerformed(e);
      }
    });
    btnFechar.setText("x");
    btnFechar.setFont(new Font("Verdana", 1, 10));
    btnFechar.setBounds(new Rectangle(340, 10, 45, 15));
    btnFechar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnFechar_fecharTela(e);
      }
    });
    Dimension frameSize = this.getSize();
    lblTitulo.setText("ALTERAÇÃO");
    lblTitulo.setFont(new Font("Verdana", 1, 10));
    lblTitulo.setBounds(new Rectangle(160, 15, 80, 20));
    lblNumero.setText("Numero: ");
    lblNumero.setFont(new Font("Verdana", 1, 10));
    lblNumero.setBounds(new Rectangle(15, 65, 85, 20));
    lblDescricao.setText("Descrição: ");
    lblDescricao.setFont(new Font("Verdana", 1, 10));
    lblDescricao.setBounds(new Rectangle(15, 95, 85, 20));
    lblPeso.setText("Peso: ");
    lblPeso.setFont(new Font("Verdana", 1, 10));
    lblPeso.setBounds(new Rectangle(15, 125, 85, 20));
    lblCor.setText("Cor: ");
    lblCor.setFont(new Font("Verdana", 1, 10));
    lblCor.setBounds(new Rectangle(15, 155, 85, 20));
    lblQuantidade.setText("Quantidade: ");
    lblQuantidade.setFont(new Font("Verdana", 1, 10));
    lblQuantidade.setBounds(new Rectangle(15, 185, 85, 20));
    lblPreco.setText("Preço: ");
    lblPreco.setFont(new Font("Verdana", 1, 10));
    lblPreco.setBounds(new Rectangle(15, 215, 85, 20));
    // Adiciona os botões, labels, etc... a tela.
    this.getContentPane().add(txtNum, null);
    this.getContentPane().add(txtDesc, null);
    this.getContentPane().add(txtPeso, null);
    this.getContentPane().add(txtCor, null);
    this.getContentPane().add(txtQuant, null);
    this.getContentPane().add(txtPreco, null);
    this.getContentPane().add(btnPesquisar, null);
    this.getContentPane().add(btnAlterar, null);
    this.getContentPane().add(btnLimpar, null);
    this.getContentPane().add(btnFechar, null);
    this.getContentPane().add(lblTitulo, null);
    this.getContentPane().add(lblNumero, null);
    this.getContentPane().add(lblDescricao, null);
    this.getContentPane().add(lblPeso, null);
    this.getContentPane().add(lblCor, null);
    this.getContentPane().add(lblQuantidade, null);
    this.getContentPane().add(lblPreco, null);
    // Não deixe mexer no tamanho da tela.
    this.setResizable(false);
    // Tira os botões de minimizar, maximizar e fechar.
    this.setUndecorated(true);
  }

  /**
   * Função do botão pesquisar, o usuario preenche o campo numero e
   * pesquisa, caso encontre algum cadastro retorna e preenche os 
   * campos, caso não encontre nada, manda uma mensagem de aviso
   * ao usuario.
   * @param e
   */
  void btnPesquisar_actionPerformed(ActionEvent e) {
    if (txtNum.getText().equals("")) {
      JOptionPane.showMessageDialog(null, "Favor preencher os campos:\nNumero");
    } else {
      Vector v = conx.selecionar(txtNum.getText());
      if (!v.isEmpty()) {
        txtDesc.setText((String) v.elementAt(0));
        txtPeso.setText((String) v.elementAt(1));
        txtCor.setText((String) v.elementAt(2));
        txtQuant.setText((String) v.elementAt(3));
        txtPreco.setText((String) v.elementAt(4));
        btnAlterar.setEnabled(true);
      } else {
        JOptionPane.showMessageDialog(null, "Esse numero não existe");
        txtNum.setText("");
      }
    }
  }

  /**
   * Função do botão alterar, depois que o usuario faz as modificações
   * no cadastro todos os dados são usados para atualizar o BD.
   * @param e
   */
  void btnAlterar_actionPerformed(ActionEvent e) {
    boolean resp = conx.alterar(txtNum.getText(), txtDesc.getText(), txtPeso.getText(), txtCor
        .getText(), txtQuant.getText(), txtPreco.getText());
    if (resp) {
      JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso.");
      btnLimpar_actionPerformed(e);
    } else JOptionPane.showMessageDialog(null, "Falha ao alterar o cadastrar.");
  }

  /**
   * Função do botão limpar, limpa todos os campos da tela.
   * @param e
   */
  void btnLimpar_actionPerformed(ActionEvent e) {
    txtNum.setText("");
    txtDesc.setText("");
    txtPeso.setText("");
    txtCor.setText("");
    txtQuant.setText("");
    txtPreco.setText("");
    btnAlterar.setEnabled(false);
  }

  /**
   * Função do botão fechar, fecha conexão com o BD e fecha a tela.
   * @param e
   */
  void btnFechar_fecharTela(ActionEvent e) {
    // Fecha conexão com o BD.
    conx.fecharConexao();
    this.dispose();
  }
}