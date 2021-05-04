import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Yemek {
    
    Random random = new Random();
        
    private int yemekX;
    private int yemekY;
    private final int yemekBoyu = 15;
    
    public Yemek() {
        koordinatUret();
   }
    
    // Yeme efekt ekle Büyüsün Küçülsün
    // Score 100'den sonra devam etsin Rekor kırmaya çalışşın hatta rekorları kaydet bi listede en yüksek puan sıralaması yaptır.
    // Yemek Yerken yılana efekt ver
    
    public void yemekCiz(Graphics g){
    
        g.setColor(Color.ORANGE);
        g.fillOval(this.getYemekX(), this.getYemekY(), this.getYemekBoyu(), this.getYemekBoyu());
    }
    
    public void koordinatUret(){
    
        this.yemekX = random.nextInt(Level.getGenislik());
        this.yemekY = random.nextInt(Level.getYukseklik());
        
        if(this.getYemekX() < 30){
            this.setYemekX(this.getYemekX() + 30);
        }
        if(this.getYemekX() > Level.getGenislik()){
            this.setYemekX(this.getYemekX() - 30);
        }
        if(this.getYemekY() < 30){
            this.setYemekY(this.getYemekY() + 30);
        }
        if(this.getYemekY() > Level.getYukseklik()){
            this.setYemekY(this.getYemekY() - 30);
        }
    }
    public int getYemekX() {
        return yemekX;
    }

    public void setYemekX(int yemekX) {
        this.yemekX = yemekX;
    }

    public int getYemekY() {
        return yemekY;
    }

    public void setYemekY(int yemekY) {
        this.yemekY = yemekY;
    }
    
    public int getYemekBoyu() {
        return yemekBoyu;
    }
}
