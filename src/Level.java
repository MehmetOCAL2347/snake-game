import java.awt.Color;
import java.awt.Graphics;

public class Level {
    
    private final static int alanGenisligi = (AnaEkran.getEkranGenisligi()-44);
    private final static int alanYuksekligi = (AnaEkran.getEkranYuksekligi()-68);
    private final int kutuX = 25;
    private final int kutuY = 25;
    
    private static int Genislik = (alanGenisligi / 25) *25;
    private static int Yukseklik = (alanYuksekligi / 25) *25;
            
    public void sinirHatti(Graphics g){
        
        g.setColor(Color.red);
        g.drawRect(kutuX, kutuY, Genislik, Yukseklik);
    }

    public int getAlanGenisligi() {
        return alanGenisligi;
    }
    
    public int getAlanYuksekligi() {
        return alanYuksekligi;
    }

    public int getKutuX() {
        return kutuX;
    }

    public int getKutuY() {
        return kutuY;
    }

    public static int getGenislik() {
        return Genislik;
    }

    public static void setGenislik(int Genislik) {
        Level.Genislik = Genislik;
    }

    public static int getYukseklik() {
        return Yukseklik;
    }

    public static void setYukseklik(int Yukseklik) {
        Level.Yukseklik = Yukseklik;
    }
}
