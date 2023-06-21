import javax.swing.JOptionPane;

public class MesaDireita extends ElementoBasico {
  
    public MesaDireita(String id, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, "mesaDireita.jpg", linInicial, colInicial, tabuleiro);
    }
    @Override
    public void acao(ElementoBasico outro) {
        JOptionPane.showMessageDialog(getRootPane(), " BILHETE: Vou deixar uma chave escondida em algum lugar");
        JOptionPane.showMessageDialog(getRootPane(), " BOA SORTE");
        
    }
}
