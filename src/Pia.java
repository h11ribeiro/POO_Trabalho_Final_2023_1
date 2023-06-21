import javax.swing.JOptionPane;

public class Pia extends ElementoBasico {

    public Pia(String id, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, "pia.jpg", linInicial, colInicial, tabuleiro);
    }

    @Override
    public void acao(ElementoBasico outro) {
        JOptionPane.showMessageDialog(getRootPane(), "Parece que o vidro da pia está quebrado");

        int choice = JOptionPane.showConfirmDialog(null, "Sera que devo pegar este Vidro:", "Escolhas",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        // Processamento da escolha do usuário
        if (choice == JOptionPane.YES_OPTION) {
            if (papel == true) {
                JOptionPane.showMessageDialog(getRootPane(), "Pegeui o vidro");
            } else {
                JOptionPane.showMessageDialog(getRootPane(), "Preciso do papel para pegar o vidro");
            }
        } else if (choice == JOptionPane.NO_OPTION) {
            // Ação para a opção falsa (Não)
          vidro = false;
        } else {
            // Nenhuma opção selecionada ou a janela foi fechada
        }
    }
}
