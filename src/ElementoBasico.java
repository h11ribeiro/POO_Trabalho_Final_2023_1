import java.awt.Color;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public abstract class ElementoBasico extends JButton {
    private Tabuleiro tabuleiro;
    private String id;
    private ImageIcon imagem;
    private int lin;
    private int col;
    protected static boolean facaImp = false;
    protected static boolean chave = false;
    protected static boolean papel = false;
    protected static boolean vidro = false;
    protected static boolean lixo = false;
    protected static boolean pano = false;
    protected static int     barulho = 0;
    //O modificador protected permite que os membros sejam acessados por classes relacionadas  e outras classes do mesmo pacote.
    public void setbarulho(int barulho){
        this.barulho = barulho;
    }
    public int getBarulho(){
        return barulho;
    }
    public void serPano(boolean pano){
        this.pano = pano;
    }
    public static boolean getPano(){
        return pano;
    }
    public void setFacaImp(boolean facaImp) {
        this.facaImp = facaImp;
    }

    public static boolean getFacaImp() {
        return facaImp;
    }

    public void setChave(boolean chave) {
        this.chave = chave;
    }

    public static boolean getChave() {
        return chave;
    }

    public void setPapel(boolean papel) {
        this.papel = papel;
    }

    public boolean getPapel() {
        return papel;
    }

    public void setVidro(boolean vidro) {
        this.vidro = vidro;
    }

    public static boolean getVidro() {
        return vidro;
    }

    public void setLixo(boolean lixo) {
        this.lixo = lixo;
    }

    public boolean getRoupa() {
        return lixo;
    }
 
    
    
    public ElementoBasico(String id, String iconPath, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        this.id = id;
        this.lin = linInicial;
        this.col = colInicial;
        this.tabuleiro = tabuleiro;

        this.imagem = Tabuleiro.createImageIcon(iconPath);
        this.setIcon(this.imagem);
        this.setBorder(BorderFactory.createBevelBorder(0, Color.RED, Color.BLACK));
        this.setMargin(new Insets(0, 0, 0, 0));
        this.addActionListener(e -> System.out.println(this.toString()));

    }

    public ElementoBasico(String id, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        this.id = id;
        this.lin = linInicial;
        this.col = colInicial;
        this.tabuleiro = tabuleiro;
    }

    public ImageIcon getImagem() {
        return this.imagem;
    }

    public void setImage(ImageIcon imagem) {
        this.imagem = imagem;
        this.setIcon(imagem);
    }

    public String getId() {
        return id;
    }

    public int getLin() {
        return lin;
    }

    public void incLin() {
        if (lin < Tabuleiro.getMaxlin() - 1) {
            lin++;
        }
    }

    public void decLin() {
        if (lin > 0) {
            lin--;
        }
    }

    public void incCol() {
        if (col < Tabuleiro.getMaxcol() - 1) {
            col++;
        }
    }

    public void decCol() {
        if (col > 0) {
            col--;
        }
    }

    public int getCol() {
        return col;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public abstract void acao(ElementoBasico outro);

    @Override
    public String toString() {
        return this.getClass() + " [id=" + id + ", lin=" + lin + ", col=" + col + "]";
    }

}
