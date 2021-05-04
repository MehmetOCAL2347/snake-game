import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Oyun extends JPanel implements KeyListener, ActionListener{

    private int scores = 0;
    private int oyunHakki = 3;
    public static Timer timer;
    private int scoreEkran = 1;
    
    Level level = new Level();
    Daire daire = new Daire();
    Yemek yemek = new Yemek();

    public Oyun() {
        
        setBackground(Color.DARK_GRAY);       
        timer = new Timer(daire.getHiz(),this);
        timer.start();
    }
    
    public void carpmaKontrol(){
        
        if(!(new Rectangle(((int)Array.getInt(daire.getDaireXKoordinatlar(), 0)), ((int)Array.getInt(daire.getDaireYKoordinatlar(), 0)), daire.getDaireDir(), daire.getDaireDir()).intersects
            (new Rectangle(level.getKutuX(),level.getKutuY(),level.getGenislik(),level.getYukseklik())))){
                      
            this.setScores(0);
            daire.koordinatSifirla();
            timer.setDelay(100);
            this.setOyunHakki(this.oyunHakki - 1); 
            daire.setMoves(0);
            this.scoreEkran = 1;
        }
        if(daire.kendineCarpma()){
            if(daire.getMoves() == 0){
            }else{
                this.setScores(0);
                daire.koordinatSifirla();
                timer.setDelay(100);
                this.setOyunHakki(this.oyunHakki - 1);
                daire.setMoves(0);
                this.scoreEkran = 1;
            }
        }
        if(this.getOyunHakki() == 0){
            timer.stop();
            int a = JOptionPane.showConfirmDialog(this, "Yeniden Başlamak İster misin ?"); // ??? Dene
            
            if(a == JOptionPane.YES_OPTION){
                timer.start();
                this.setOyunHakki(3);
                this.setScores(0);
                daire.koordinatSifirla();
                timer.setDelay(100);
            }else if(a == JOptionPane.NO_OPTION){
                timer.stop();
                System.exit(0);
            }else if(a == JOptionPane.CANCEL_OPTION){
                timer.stop();
                JOptionPane.showMessageDialog(this, "Yine Bekleriz...");
                System.exit(0);
            }
        }
    }
    
    public void scoreArtir(){
        
        scores +=2;
        if(scores <= 20){
            timer.setDelay(daire.getHiz());
            this.scoreEkran = 1;
        }else if(scores > 20 && scores <= 40){
            timer.setDelay(daire.getHiz() - 30);
            this.scoreEkran = 2;
        }else if(scores > 40 && scores <= 60){
            timer.setDelay(daire.getHiz() - 50);
            this.scoreEkran = 3;
        }else if(scores > 60 && scores < 100){
            timer.setDelay(daire.getHiz() - 60);
            this.scoreEkran = 4;
        }else if(scores >= 100){
            timer.setDelay(daire.getHiz() - 80);
            this.scoreEkran = 5;
        }        
    }
    
    public void eat(){      
        if(new Rectangle(((int)Array.getInt(daire.getDaireXKoordinatlar(), 0)), ((int)Array.getInt(daire.getDaireYKoordinatlar(), 0)), daire.getDaireDir(), daire.getDaireDir()).intersects
          (new Rectangle(yemek.getYemekX(), yemek.getYemekY(), yemek.getYemekBoyu(), yemek.getYemekBoyu()))){
            daire.setDaireAdeti(daire.getDaireAdeti()+1);
            scoreArtir();
            yemek.koordinatUret();
       }
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    public int getOyunHakki() {
        return oyunHakki;
    }

    public void setOyunHakki(int oyunHakki) {
        this.oyunHakki = oyunHakki;
    }
       
    @Override
    public void repaint() {
        super.repaint();
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.red);
        g.setFont(new Font("arial", Font.BOLD,18));
        g.drawString("Score >> " + this.scores, 25, 20);
        g.drawString("Oyun Hakkı >> " + this.oyunHakki, 200, 20);
        g.drawString("Hız >> " + this.scoreEkran, 420, 20);
        g.drawString("Durmak İçin >> P", 600, 20);
        level.sinirHatti(g);
        yemek.yemekCiz(g);
        daire.baslangıc(g);
    }
     
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        daire.donusler(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        daire.hareketEt(e);
        carpmaKontrol();
        eat();
        repaint();
    }
}
