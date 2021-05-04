import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class AnaEkran extends JFrame{
    
    static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];

    private static Toolkit tk = Toolkit.getDefaultToolkit();
    private static int ekranGenisligi = (int) tk.getScreenSize().getWidth();
    private static int ekranYuksekligi = (int) (tk.getScreenSize().getHeight() - 50);

    public AnaEkran(String title) throws HeadlessException {
        super(title);
    }
    
    public static int getEkranGenisligi() {
        return ekranGenisligi;
    }

    public static int getEkranYuksekligi() {
        return ekranYuksekligi;
    }
    /*
    public static void main(String[] args){
        
        AnaEkran ekran = new AnaEkran("Snake Game");
        ekran.setResizable(false);
        ekran.setFocusable(false);
        ekran.setBounds(0, 0, ekranGenisligi, ekranYuksekligi);
        ekran.setBackground(java.awt.Color.RED);
        ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        Oyun oyun = new Oyun();
        oyun.requestFocus();
        oyun.addKeyListener(oyun);
        oyun.setFocusable(true);
        oyun.setFocusTraversalKeysEnabled(false);
        oyun.setVisible(true);
        
        ekran.add(oyun);
        ekran.setVisible(true);
    }*/
}
