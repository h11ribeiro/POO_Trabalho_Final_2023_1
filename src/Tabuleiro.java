import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Tabuleiro extends JPanel {
    private static final int MAXLIN = 8;
    private static final int MAXCOL = 9;
    private ElementoBasico[][] celulas;

    private Personagem principal;

    public Tabuleiro() {
        super();
        // Cria o conjunto de células vazia e as insere no layout
        celulas = new ElementoBasico[MAXLIN][MAXCOL];
        this.setLayout(new GridLayout(MAXLIN, MAXCOL));
        for (int i = 0; i < MAXLIN; i++) {
            for (int j = 0; j < MAXCOL; j++) {

                celulas[i][j] = new Fundo("Fundo[" + i + "][" + j + "]", i, j, this);
                this.add(celulas[i][j]);
            }
        }
    }

    private static final int Altura = 48;
    private static final int Largura = 44;
    private static Map<String, ImageIcon> proxi = new HashMap<>();

    public static ImageIcon createImageIcon(String path) {
        if (proxi.containsKey(path)) {
            return proxi.get(path);
        }

        java.net.URL imgURL = App.class.getResource("imagens/" + path);
        if (imgURL != null) {
            ImageIcon aux = new ImageIcon(imgURL);
            aux = Tabuleiro.resize(aux, Altura, Largura);
            proxi.put(path, aux);
            return aux;
        } else {
            System.err.println("Couldn't find file: " + path);
            System.exit(0);
            return null;
        }
    }

    public static ImageIcon resize(ImageIcon src, int destWidth,
            int destHeight) {
        return new ImageIcon(src.getImage().getScaledInstance(destWidth,
                destHeight, Image.SCALE_SMOOTH));
    }

    public static int getMaxlin() {
        return MAXLIN;
    }

    public static int getMaxcol() {
        return MAXCOL;
    }

    public boolean posicaoValida(int lin, int col) {
        if ((lin < 0) || (col < 0) ||
                (lin >= MAXLIN) || (col >= MAXCOL)) {
            return false;
        } else {
            return true;
        }
    }

    // Retorna referencia em determinada posição
    public ElementoBasico getElementoNaPosicao(int lin, int col) {
        if (!posicaoValida(lin, col)) {
            return null;
        }
        return celulas[lin][col];
    }

    public ElementoBasico insereElemento(ElementoBasico elemento) {
        int lin = elemento.getLin();
        int col = elemento.getCol();
        if (!posicaoValida(lin, col)) {
            throw new IllegalArgumentException("Posicao invalida:" + lin + " ," + col);
        }
        ElementoBasico elementoAnterior = celulas[lin][col];
        celulas[lin][col] = elemento;
        return elementoAnterior;
    }

    public void atualizaVisualizacao() {
        // Atualiza o conteúdo do JPanel (ver algo melhor)
        this.removeAll(); 
        this.revalidate();
        this.repaint();
        for (int i = 0; i < MAXLIN; i++) {
            for (int j = 0; j < MAXCOL; j++) {
                this.add(celulas[i][j]);
            }
        }
    }

    public void loadLevel(int nivel) {
        Path path1 = Paths.get(String.format("nivel%d.txt", nivel));
        try (BufferedReader reader = Files.newBufferedReader(path1)) {
            String line = null;
            int lin = 0;
            while ((line = reader.readLine()) != null) {

                for (int col = 0; col < MAXCOL; col++) {
                    if (line.charAt(col) != ' ') {
                        ElementoBasico elem = this.getElem(line.charAt(col), lin, col);
                        this.insereElemento(elem);
                    }
                }
                lin++;

            }
        } catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
    }

    public ElementoBasico getElem(char elem, int lin, int col) {
        Random r = new Random();
        switch (elem) {
            case '/':
                return new Porta(TOOL_TIP_TEXT_KEY, elem, lin, col, null);
            case ' ':
                return new Fundo("Fundo", lin, col, this);
            case'C':
                return new Cadeira(TOOL_TIP_TEXT_KEY, lin, col, null);
            case'E':
                return new Mesaesquerda(TOOL_TIP_TEXT_KEY, lin, col, null);
            case'D':
                return new MesaDireita(TOOL_TIP_TEXT_KEY, lin, col, null);
            case'1':
                return new Cama1(TOOL_TIP_TEXT_KEY, lin, col, null);
            case'2':
                return new Cama2(TOOL_TIP_TEXT_KEY, lin, col, null);
            case'V':
                return new Vaso(TOOL_TIP_TEXT_KEY, lin, col, null);
            case'P':
                return new Pia(TOOL_TIP_TEXT_KEY, lin, col, null);    
            case'L':
                return new Lixeira(TOOL_TIP_TEXT_KEY, lin, col, null);
            case '-':
                return new Parede("Dica", lin, col, this);
            case '*': {
                ElementoBasico anterior = new Fundo("Fundo", lin, col, this);
                principal = new Personagem("Player", "player.png", lin, col, this);
                principal.setAnterior(anterior);
                return principal;
            }
            default:
                throw new IllegalArgumentException("Personagem invalido: " + elem);
        }

    }

    public Personagem getPrincipal() {
        return principal;
    }
}
