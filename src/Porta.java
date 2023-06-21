import javax.swing.JOptionPane;

public class Porta extends ElementoBasico {
   
    public Porta(String id, int nroPista, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, "irondoor.png", linInicial, colInicial, tabuleiro);
    }

    @Override
    public void acao(ElementoBasico outro) {
        if (chave == false) {
            JOptionPane.showMessageDialog(getRootPane(), "A porta esta Fechada, preciso da chave!");
        } else {
            JOptionPane.showMessageDialog(getRootPane(),
                    "Parabens voce conseguiu sair da cela");
                    System.exit(0);
        }
    }
}
