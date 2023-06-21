import javax.swing.JOptionPane;

public class Vaso extends ElementoBasico {
  
    public Vaso(String id, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, "vaso.png", linInicial, colInicial, tabuleiro);
    }

    @Override
    public void acao(ElementoBasico outro) {
        JOptionPane.showMessageDialog(getRootPane(), "Olha um papel isso pode me ser util em algo ");

        int choice = JOptionPane.showConfirmDialog(null, "Sera que devo pegar este papel:", "Escolhas",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        // Processamento da escolha do usuário
        if (choice == JOptionPane.YES_OPTION) {
            // Ação para a opção verdadeira (Sim)
            papel = true;
        } else if (choice == JOptionPane.NO_OPTION) {
            // Ação para a opção falsa (Não)
          papel = false;
        } else {
            // Nenhuma opção selecionada ou a janela foi fechada
        }
    }
}

