import javax.swing.JOptionPane;

public class Mesaesquerda extends ElementoBasico {
    public Mesaesquerda(String id, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, "mesaEsquerda.jpg", linInicial, colInicial, tabuleiro);
    }

    @Override
    public void acao(ElementoBasico outro) {
        JOptionPane.showMessageDialog(getRootPane(), "Aqui e um bom lugar pra fazer uma faca");
       
        int choice = JOptionPane.showConfirmDialog(null, "Vou fazer a faca:", "Escolhas",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        // Processamento da escolha do usuário
        if (choice == JOptionPane.YES_OPTION) {
               // Ação para a opção verdadeira (Sim)
               if (pano == true || vidro == true ) {
                JOptionPane.showMessageDialog(getRootPane(), "Agora tenho uma faca");
                facaImp = true;
            } else {
                JOptionPane.showMessageDialog(getRootPane(), "Preciso de mais itens pra fazer a faca");
            }
          } else if (choice == JOptionPane.NO_OPTION) {
             // Ação para a opção falsa (Não)
         
         } else {
              // Nenhuma opção selecionada ou a janela foi fechada
          }
       }
}
