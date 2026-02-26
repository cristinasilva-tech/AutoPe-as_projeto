/**
 * Tela de Lancamento de saida, o usuario faz uma busca da peça,
 * e tem a opção de alterar a quantidade de peça em estoque.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class SipLanc extends JFrame {
  JTextField txtNum    = new JTextField();
  JTextField txtDesc   = new JTextField();
  JTextField txtPeso   = new JTextField();
  JTextField txtCor    = new JTextField();
  JTextField txtQuant  = new JTextField();
  JTextField txtPreco  = new JTextField();
  JTextField txtNovo   = new JTextField();
  JButton btnPesquisar = new JButton();
  JButton btnEntrada   = new JButton();
  JButton btnSaida     = new JButton();
  JButton btnLimpar    = new JButton();
  JButton btnFechar    = new JButton();
  JLabel lblTitulo     = new JLabel();
  JLabel lblNumero     = new JLabel();
  JLabel lblDescricao  = new JLabel();
  JLabel lblPeso       = new JLabel();
  JLabel lblCor        = new JLabel();
  JLabel lblQuantidade = new JLabel();
  JLabel lblPreco      = new JLabel();
  JLabel lblNovo       = new JLabel();
  conexao conx         = new conexao();

  /**
   * Contrutor que chama o metodo para preencher a tela e define o tamanho da tela.
   */
  public SipLanc() {
    try {
      // Chama o metodo para preencher minha tela.
      iniciar();
      // Dimensão da minha tela
      setSize(400, 320);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Metodo que preenche a tela com os botões, labels, etc...
   * 
   * @throws Exception
   */
  private void iniciar() throws Exception {
    this.getContentPane().setLayout(null);
    txtNum.setText("");
    txtNum.setFont(new Font("Verdana", 1, 10));
    txtNum.setBounds(new Rectangle(115, 65, 100, 22));
    txtNum.setEnabled(true);
    txtDesc.setText("");
    txtDesc.setFont(new Font("Verdana", 1, 10));
    txtDesc.setBounds(new Rectangle(115, 95, 250, 22));
    txtDesc.setEnabled(false);
    txtPeso.setText("");
    txtPeso.setFont(new Font("Verdana", 1, 10));
    txtPeso.setBounds(new Rectangle(115, 125, 100, 22));
    txtPeso.setEnabled(false);
    txtCor.setText("");
    txtCor.setFont(new Font("Verdana", 1, 10));
    txtCor.setBounds(new Rectangle(115, 155, 100, 22));
    txtCor.setEnabled(false);
    txtQuant.setText("");
    txtQuant.setFont(new Font("Verdana", 1, 10));
    txtQuant.setBounds(new Rectangle(115, 185, 100, 22));
    txtQuant.setEnabled(false);
    txtPreco.setText("");
    txtPreco.setFont(new Font("Verdana", 1, 10));
    txtPreco.setBounds(new Rectangle(115, 215, 100, 22));
    txtPreco.setEnabled(false);
    txtNovo.setFont(new Font("Verdana", 1, 10));
    txtNovo.setBounds(new Rectangle(115, 245, 100, 22));
    txtNovo.setEnabled(false);
    btnPesquisar.setLabel("Pesquisar");
    btnPesquisar.setFont(new Font("Verdana", 1, 10));
    btnPesquisar.setBounds(new Rectangle(245, 65, 100, 22));
    // Adiciona o evento no botão pesquisar
    btnPesquisar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnPesquisar_actionPerformed(e);
      }
    });
    btnEntrada.setLabel("Entrada");
    btnEntrada.setFont(new Font("Verdana", 1, 10));
    btnEntrada.setBounds(new Rectangle(42, 280, 100, 22));
    // Adiciona o evento no botão Entrada
    btnEntrada.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnEntrada_actionPerformed(e);
      }
    });
    btnEntrada.setEnabled(false);
    btnSaida.setLabel("Saida");
    btnSaida.setFont(new Font("Verdana", 1, 10));
    btnSaida.setBounds(new Rectangle(152, 280, 100, 22));
    // Adiciona o evento no botão Saida
    btnSaida.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnSaida_actionPerformed(e);
      }
    });
    btnSaida.setEnabled(false);
    btnLimpar.setLabel("Limpar");
    btnLimpar.setFont(new Font("Verdana", 1, 10));
    btnLimpar.setBounds(new Rectangle(262, 280, 100, 22));
    // Adiciona o evento no botão limpar
    btnLimpar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnLimpar_actionPerformed(e);
      }
    });
    btnFechar.setText("x");
    btnFechar.setFont(new Font("Verdana", 1, 10));
    btnFechar.setBounds(new Rectangle(340, 10, 45, 15));
    // Adiciona o evento no botão fechar
    btnFechar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnFechar_fecharTela(e);
      }
    });
    lblTitulo.setText("LANÇAMENTO DE ENTRADA E SAÍDA");
    lblTitulo.setFont(new Font("Verdana", 1, 10));
    lblTitulo.setBounds(new Rectangle(70, 15, 220, 20));
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
    lblNovo.setText("Entrada/Saída: ");
    lblNovo.setFont(new Font("Verdana", 1, 10));
    lblNovo.setBounds(new Rectangle(15, 245, 110, 20));
    // Adiciona os botões, labels, etc... a tela.
    this.getContentPane().add(txtNum, null);
    this.getContentPane().add(txtDesc, null);
    this.getContentPane().add(txtPeso, null);
    this.getContentPane().add(txtCor, null);
    this.getContentPane().add(txtQuant, null);
    this.getContentPane().add(txtPreco, null);
    this.getContentPane().add(txtNovo, null);
    this.getContentPane().add(btnPesquisar, null);
    this.getContentPane().add(btnEntrada, null);
    this.getContentPane().add(btnSaida, null);
    this.getContentPane().add(btnLimpar, null);
    this.getContentPane().add(btnFechar, null);
    this.getContentPane().add(lblTitulo, null);
    this.getContentPane().add(lblNumero, null);
    this.getContentPane().add(lblDescricao, null);
    this.getContentPane().add(lblPeso, null);
    this.getContentPane().add(lblCor, null);
    this.getContentPane().add(lblQuantidade, null);
    this.getContentPane().add(lblPreco, null);
    this.getContentPane().add(lblNovo, null);
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
   * 
   * @param e
   */
  void btnPesquisar_actionPerformed(ActionEvent e) {
    if (txtNum.getText().equals("")) {
      JOptionPane.showMessageDialog(null, "Favor preencher o campo:\nNumero");
    } else {
      Vector v = conx.selecionar(txtNum.getText());
      if (!v.isEmpty()) {
        txtDesc.setText((String) v.elementAt(0));
        txtPeso.setText((String) v.elementAt(1));
        txtCor.setText((String) v.elementAt(2));
        txtQuant.setText((String) v.elementAt(3));
        txtPreco.setText((String) v.elementAt(4));
        txtNovo.setEnabled(true);
        txtNovo.getFocusListeners();
        btnEntrada.setEnabled(true);
        btnSaida.setEnabled(true);
      } else {
        JOptionPane.showMessageDialog(null, "Esse numero não existe");
        txtNum.setText("");
      }
    }
  }

  /**
   * Função do botão entrada, verifica se o usuario digitou algum novo
   * valor no campo Entrada/Saida, esse valor é adicionado ao valor
   * original.
   * 
   * @param e
   */
  void btnEntrada_actionPerformed(ActionEvent e) {
    if (!txtNovo.getText().equals("")){
      String novo = String.valueOf(Integer.parseInt(txtQuant.getText())+Integer.parseInt(txtNovo.getText()));
      boolean resp = conx.alterarQuant(txtNum.getText(), novo);
      if (resp) {
        JOptionPane.showMessageDialog(null, "Lançamento de entrada atualizado com sucesso.");
        btnLimpar_actionPerformed(e);
      } else JOptionPane.showMessageDialog(null, "Falha ao atualizar o Lançamento de Entrada.");
    }
    else JOptionPane.showMessageDialog(null, "Digite um numero no campo Entrada/Saída.");
  }
  
  /**
   * Função do botão saida, verifica se o usuario digitou algum novo
   * valor no campo Entrada/Saida, esse valor é removido do valor
   * original.
   * 
   * @param e
   */
  void btnSaida_actionPerformed(ActionEvent e) {
    if (!txtNovo.getText().equals("")){
      String novo = String.valueOf(Integer.parseInt(txtQuant.getText())-Integer.parseInt(txtNovo.getText()));
      boolean resp = conx.alterarQuant(txtNum.getText(), novo);
      if (resp) {
        JOptionPane.showMessageDialog(null, "Lançamento de saída atualizado com sucesso.");
        btnLimpar_actionPerformed(e);
      } else JOptionPane.showMessageDialog(null, "Falha ao atualizar o Lançamento de Entrada.");
    }
    else JOptionPane.showMessageDialog(null, "Digite um numero no campo Entrada/Saída.");
  }

  /**
   * Função do botão limpar, limpa todos os campos da tela.
   * 
   * @param e
   */
  void btnLimpar_actionPerformed(ActionEvent e) {
    txtNum.setText("");
    txtDesc.setText("");
    txtPeso.setText("");
    txtCor.setText("");
    txtQuant.setText("");
    txtPreco.setText("");
    txtNovo.setText("");
    btnEntrada.setEnabled(false);
    btnSaida.setEnabled(false);
    txtNovo.setEnabled(false);
  }

  /**
   * Função do botão fechar, fecha conexão com o BD e fecha a tela.
   * 
   * @param e
   */
  void btnFechar_fecharTela(ActionEvent e) {
    // Fecha conexão com o BD.
    conx.fecharConexao();
    this.dispose();
  }
}