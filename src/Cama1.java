import javax.swing.JOptionPane;

public class Cama1 extends ElementoBasico {
  
    public Cama1(String id, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, "camaEsquerda.jpg", linInicial, colInicial, tabuleiro);
    }

    @Override
    public void acao(ElementoBasico outro) {
        JOptionPane.showMessageDialog(getRootPane(), "Ei! pare de fazer barulho. Caso contrário,Irei transferi-lo para outra cela");
        barulho++;
        if (barulho >= 2) {
            Fim();
        }
    }
    
    private void Fim() {
        JOptionPane.showMessageDialog(getRootPane(), "Você fez barulho demais! O jogo acabou.");
        System.exit(0);
    }
}

