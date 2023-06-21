import javax.swing.JOptionPane;

public class Lixeira extends ElementoBasico {
    
    public Lixeira(String id, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, "lixo.jpg", linInicial, colInicial, tabuleiro);
    }
    @Override
    public void acao(ElementoBasico outro) {
       
        JOptionPane.showMessageDialog(getRootPane(), "Que lixo nojento");
        JOptionPane.showMessageDialog(getRootPane(), "Tem um pedaço de pano pode ser util pra faca");

        int choice = JOptionPane.showConfirmDialog(null, "Sera que devo pegar este pedaço de pano:", "Escolhas",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        // Processamento da escolha do usuário
        if (choice == JOptionPane.YES_OPTION) {
            // Ação para a opção verdadeira (Sim)
            pano = true;
        } else if (choice == JOptionPane.NO_OPTION) {
            // Ação para a opção falsa (Não)
        pano = false;
        } else {
            // Nenhuma opção selecionada ou a janela foi fechada
        }
    }
}
