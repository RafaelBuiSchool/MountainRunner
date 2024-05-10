import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.Font;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class HomeScreenPainter extends JPanel implements MouseListener{
    private Rectangle newGame;
    private Rectangle exit;
    private LevelChooser levelChoice;
    private HomeScreen hs;
    public HomeScreenPainter(HomeScreen hs){
        this.hs = hs;
        newGame = new Rectangle(350, 310, 320, 100);
        exit = new Rectangle(350, 470, 320, 100);
        this.addMouseListener(this);
        this.levelChoice = levelChoice;
    }
    protected void paintComponent(Graphics g) {
        BufferedImage homeScreen = null;
        try {
            homeScreen = ImageIO.read(new File("sprites/HomeScreenBackground.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        g.drawImage(homeScreen,0,0,getWidth(),getHeight(),null);
        g.setFont(new Font("Broadway", Font.BOLD, 50));
        g.drawString("MOUNTAIN RUNNER", 255, 205);
        g.setFont(new Font("Broadway", Font.BOLD, 50));
        g.drawString("NEW GAME", 365, 375);
        g.drawRect((int)newGame.getX(), (int)newGame.getY(), (int)newGame.getWidth(), (int)newGame.getHeight());
        g.setFont(new Font("Broadway", Font.BOLD, 50));
        g.drawString("EXIT", 440, 535);
        g.drawRect((int)exit.getX(), (int)exit.getY(), (int)exit.getWidth(), (int)exit.getHeight());
    }
    public void mousePressed(MouseEvent e){
        Point clicked = e.getPoint();
        if(e.getButton()==1){
            if(newGame.contains(clicked)){
                levelChoice = new LevelChooser("Levels (CHOOSE YOUR LEVEL)");
                hs.dispose();
            }
            else if(exit.contains(clicked)){
                System.exit(0);
            }
        }

    }
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) { }
}