import javax.swing.JOptionPane;

public class Cama2 extends ElementoBasico {
  
    public Cama2(String id, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, "camaDireita.jpg", linInicial, colInicial, tabuleiro);
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
        JOptionPane.showMessageDialog(getRootPane(), "Você fez barulho demais! e foi tranferido de cela.");
        System.exit(0);
    }
}
    

