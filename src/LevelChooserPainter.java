import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.Font;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LevelChooserPainter extends JPanel{
    private Rectangle easy;
    private Rectangle medium;
    private Rectangle hard;
    private NewGame game;
    private LevelChooser sc;

    public LevelChooserPainter(LevelChooser sc){
        this.sc = sc;
        easy = new Rectangle(245, 200, 100, 100);
        medium = new Rectangle(245, 300, 100, 100);
        hard = new Rectangle(245,400,100,100);
        //this.addMouseListener(this);
        this.game = game;
    }
    public void paintComponent(Graphics g){
        BufferedImage levelBackground = null;
        try {
            levelBackground = ImageIO.read(new File("sprites/LevelBackground.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        g.drawImage(levelBackground,0,0,getWidth(),getHeight(),null);
        g.setFont(new Font("Broadway", Font.BOLD, 25));
        g.drawString("EASY", 260, 210);
        g.drawRect((int)easy.getX(), (int)easy.getY(), (int)easy.getWidth(), (int)easy.getHeight());
        g.setFont(new Font("Broadway", Font.BOLD, 25));
        g.drawString("MEDIUM", 260, 310);
        g.drawRect((int)medium.getX(), (int)medium.getY(), (int)medium.getWidth(), (int)medium.getHeight());
        g.setFont(new Font("Broadway", Font.BOLD, 25));
        g.drawString("HARD", 260, 410);
        g.drawRect((int)hard.getX(), (int)hard.getY(), (int)hard.getWidth(), (int)hard.getHeight());

    }
    //public void mousePressed(MouseEvent e){
       // Point clicked = e.getPoint();
        //}
   // }
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) { }
}