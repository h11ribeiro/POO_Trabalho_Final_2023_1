import javax.swing.JOptionPane;

public class Cadeira extends ElementoBasico {
    public Cadeira(String id, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, "cadeira.jpg", linInicial, colInicial, tabuleiro);
    }

    @Override
    public void acao(ElementoBasico outro) {
        JOptionPane.showMessageDialog(getRootPane(), "parece que tem um fundo falso na cadeira");

        int choice = JOptionPane.showConfirmDialog(null, "Sera que tento abrir a cadeira:", "Escolhas",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        // Processamento da escolha do usuário
        if (choice == JOptionPane.YES_OPTION) {
            if (facaImp == true) {
                JOptionPane.showMessageDialog(getRootPane(), "A CHAVE");
                JOptionPane.showMessageDialog(getRootPane(), "AGORA CONSIGO SAIR DA CELA");
                chave = true;
            } else {
                JOptionPane.showMessageDialog(getRootPane(), "Preciso de uma faca para isso");
            }
        } else if (choice == JOptionPane.NO_OPTION) {
            // Ação para a opção falsa (Não)
          vidro = false;
        } else {
            // Nenhuma opção selecionada ou a janela foi fechada
        }
        
        }
    }

