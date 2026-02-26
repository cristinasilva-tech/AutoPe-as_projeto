/**
 * Sistema Integrado de Peças Tela principal do SIP de onde irá chamar todas as
 * outras telas.
 */
import java.awt.*;
import javax.swing.*;

public class Sip extends JFrame {
  /**
   * Construtor que recebe como parametro o titulo da tela.
   * @param titulo
   */
  public Sip() {
    try {
      iniciar();
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      setSize(screenSize.width, screenSize.height);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Preenche minha tela com o menu
   * 
   * @throws Exception
   */
  private void iniciar() throws Exception {
    this.getContentPane().setLayout(null);
    this.getContentPane().setBackground(Color.gray);
    this.setTitle("Sistema Integrado de Peças");
    //Adiciona o icone que fica ao lado do nome da janela.
    ImageIcon icone = new ImageIcon("peca.gif");
    setIconImage(icone.getImage());
    MenuBar menuBar = new MenuBar();
    Menu menuCadMan = new Menu("Cadastro", true);
    Menu menuConsulta = new Menu("Consulta", true);
    Menu menuLancamento = new Menu("Lançamento", true);
    setMenuBar(menuBar);
    menuBar.setFont(new java.awt.Font("Verdana", 1, 10));
    menuBar.add(menuCadMan);
    menuBar.add(menuConsulta);
    menuBar.add(menuLancamento);
    menuCadMan.add("Inclusão");
    menuCadMan.add("Alteração");
    menuCadMan.add("Exclusão");
    menuCadMan.addSeparator();
    menuCadMan.add("Sair");
    menuConsulta.add("Peça");
    menuLancamento.add("Lançamento");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  /**
   * Metodo principal de onde tudo começa...
   * @param args
   */
  public static void main(String args[]) {
    Sip sistema = new Sip();
    mostrarTela(sistema);
  }

  /**
   * Metodo para controlar os botões do menu.
   */
  public boolean action(Event evt, Object arg) {
    if (evt.target instanceof MenuItem) {
      if (arg.equals("Inclusão")) {
        mostrarTela(new SipCadastro());
      } else if (arg.equals("Alteração")) {
        mostrarTela(new SipAlteracao());
      } else if (arg.equals("Exclusão")) {
        mostrarTela(new SipExclusao());
      } else if (arg.equals("Peça")) {
        mostrarTela(new SipConsulta());
      } else if (arg.equals("Lançamento")) {
        mostrarTela(new SipLanc());
      } else if (arg.equals("Sair")) {
        int resp = JOptionPane.showConfirmDialog(null, "Deseja fechar o SIP?",
            "Sistema Integrado de Peças", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION)
          System.exit(0);
      }
      return (true);
    }
    return (false);
  }

  /**
   * Metodo para centralizar as telas do SIP.
   * 
   * @param tela
   */
  public static void mostrarTela(Frame tela) {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = tela.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    tela.setLocation((screenSize.width - frameSize.width) / 2,
        (screenSize.height - frameSize.height) / 2);
    tela.show();
  }
}