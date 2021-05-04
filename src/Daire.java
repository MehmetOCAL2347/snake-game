import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class Daire {
    
    private boolean right = false;
    private boolean left = false;
    private boolean up = false;
    private boolean down = false; 
    
    private int moves = 0;
    private int daireAdeti = 3;
    private final int daireDir = 25;
    private int hiz = 100;
    
    private boolean pause = false;
    
    private int[] daireXKoordinatlar = new int[750];
    private int[] daireYKoordinatlar = new int[750];
    
    public void donusler(KeyEvent e){
        
        if(moves == 0){
            if(e.getKeyCode() == KeyEvent.VK_LEFT){
                this.setLeft(false);
            }
        }
        
        if(moves != 0){
            if(pause == false){            
                if(e.getKeyCode() == KeyEvent.VK_P){
                        Oyun.timer.stop();
                        pause = true;
                }
            }else if(pause){
                if(e.getKeyCode() == KeyEvent.VK_P){
                    Oyun.timer.start();
                    pause = false;
                }
            }
        }
    
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            
            this.moves++;      
            this.setRight(true);
            
            if(!this.isLeft()){
                this.setRight(true);
            }else{
                this.setRight(false);
                this.setLeft(true);
            }
            this.setDown(false);
            this.setUp(false);  
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            
            if(moves == 0){
                this.setLeft(false);
            }else{          
                this.setLeft(true);
                
                if(!this.isRight()){
                    this.setLeft(true);
                }else{
                    this.setRight(true);
                    this.setLeft(false);
                }
                this.setDown(false);
                this.setUp(false); 
            }
        }        
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            
            this.moves++;            
            this.setDown(true);
            
            if(!this.isUp()){
                this.setDown(true);
            }else{
                this.setUp(true);
                this.setDown(false);
            }
            this.setRight(false);
            this.setLeft(false);
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            
            this.moves++;    
            this.setUp(true);
            
            if(!this.isDown()){
                this.setUp(true);
            }else{                
                this.setDown(true);
                this.setUp(false);
            }
            this.setRight(false);
            this.setLeft(false); 
        }
    }
    
    public void hareketEt(ActionEvent e){
    
        if(this.isRight()){
            
            for(int r = this.getDaireAdeti()-1; r >= 0; r--){
                
                daireYKoordinatlar[r+1] = daireYKoordinatlar[r];            
            
            }
            for(int r = this.getDaireAdeti(); r >= 0; r--){
                
                if(r==0){                    
                    daireXKoordinatlar[r] = daireXKoordinatlar[r] + this.getDaireDir();                
                }else{
                    daireXKoordinatlar[r] = daireXKoordinatlar[r-1];
                }            
            }
        }
        
        if(this.isLeft()){
            
            for(int r = this.getDaireAdeti()-1; r >= 0; r--){
                
                daireYKoordinatlar[r+1] = daireYKoordinatlar[r];         
            
            }
            for(int r = this.getDaireAdeti(); r >= 0; r--){
                
                if(r==0){                    
                    daireXKoordinatlar[r] = daireXKoordinatlar[r] - this.getDaireDir();                
                }else{
                    daireXKoordinatlar[r] = daireXKoordinatlar[r-1];
                }            
            }
        }

        if(this.isUp()){
            
            for(int r = this.getDaireAdeti()-1; r >= 0; r--){
                
                daireXKoordinatlar[r+1] = daireXKoordinatlar[r];            
            
            }
            for(int r = this.getDaireAdeti(); r >= 0; r--){
                
                if(r==0){                    
                    daireYKoordinatlar[r] = daireYKoordinatlar[r] - this.getDaireDir();                
                }else{
                    daireYKoordinatlar[r] = daireYKoordinatlar[r-1];
                }            
            }
        }
        
        if(this.isDown()){
            
            for(int r = this.getDaireAdeti()-1; r >= 0; r--){
                
                daireXKoordinatlar[r+1] = daireXKoordinatlar[r];            
            
            }
            for(int r = this.getDaireAdeti(); r >= 0; r--){
                
                if(r==0){                    
                    daireYKoordinatlar[r] = daireYKoordinatlar[r] + this.getDaireDir();                
                }else{
                    daireYKoordinatlar[r] = daireYKoordinatlar[r-1];
                }            
            }
        }
    }

    public void baslangıc(Graphics g){
    
        if(moves == 0){
            daireXKoordinatlar[0] = 250;
            daireXKoordinatlar[1] = 225;
            daireXKoordinatlar[2] = 200;
            
            daireYKoordinatlar[0] = 275;
            daireYKoordinatlar[1] = 275;
            daireYKoordinatlar[2] = 275;
        }
        for(int a = 0; a < this.getDaireAdeti(); a++){
            g.setColor(Color.YELLOW);
            g.fillOval(daireXKoordinatlar[0], daireYKoordinatlar[0], 25, 25);  
                
            if(a != 0){                    
                g.setColor(Color.YELLOW);
                g.drawOval(daireXKoordinatlar[a], daireYKoordinatlar[a], 25, 25);                
            }
        }        
    }

    public void koordinatSifirla(){
    
        // Çarpma Kontrolü ve kendine carptığında çalışacak
        
        daireXKoordinatlar[0] = 250;
        daireXKoordinatlar[1] = 225;
        daireXKoordinatlar[2] = 200;

        daireYKoordinatlar[0] = 275;
        daireYKoordinatlar[1] = 275;
        daireYKoordinatlar[2] = 275;
        
        this.setDaireAdeti(3);
        
        this.setRight(false);
        this.setDown(false);
        this.setLeft(false);
        this.setUp(false);
    }
    
    public boolean kendineCarpma(){ // çarpmaKontrolü metotunda kullanılacak
        boolean eatItselfSonuc =false;
        for(int i =1 ;i<this.getDaireAdeti(); i++){
            if(new Rectangle(daireXKoordinatlar[0], daireYKoordinatlar[0], 20, 20).intersects
              (new Rectangle(daireXKoordinatlar[i], daireYKoordinatlar[i],20,20))){
                eatItselfSonuc = true;
                break;
            }else{
                eatItselfSonuc = false;
            }
        }
        if(eatItselfSonuc){
            return true;
        }else{
            return false;
        }        
    }
    
    public int[] getDaireXKoordinatlar() {
        return daireXKoordinatlar;
    }

    public void setDaireXKoordinatlar(int[] daireXKoordinatlar) {
        this.daireXKoordinatlar = daireXKoordinatlar;
    }

    public int[] getDaireYKoordinatlar() {
        return daireYKoordinatlar;
    }

    public void setDaireYKoordinatlar(int[] daireYKoordinatlar) {
        this.daireYKoordinatlar = daireYKoordinatlar;
    }
    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public int getDaireAdeti() {
        return daireAdeti;
    }

    public void setDaireAdeti(int daireAdeti) {
        this.daireAdeti = daireAdeti;
    }

    public int getDaireDir() {
        return daireDir;
    }

    public int getHiz() {
        return hiz;
    }

    public void setHiz(int hiz) {
        this.hiz = hiz;
    }

    public int getMoves() {
        return moves;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }    
}
