import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.Font;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Toolkit;



public class PanelPainter extends JPanel{

    private Rectangle continueGame;
    private Rectangle newGame;
    private Rectangle exit;
    public PanelPainter(){
        continueGame = new Rectangle(350, 240, 320, 100);
        newGame = new Rectangle(350, 400, 320, 100);
        exit = new Rectangle(350, 560, 320, 100);
    }
    protected void paintComponent(Graphics g) {
        Image startScreen = Toolkit.getDefaultToolkit().createImage("sprites/StartScreen.png");
        g.setFont(new Font("Broadway", Font.BOLD, 50));
        g.drawString("CONTINUE", 365, 305);
        g.drawRect((int)continueGame.getX(), (int)continueGame.getY(), (int)continueGame.getWidth(), (int)continueGame.getHeight());
        g.setFont(new Font("Broadway", Font.BOLD, 50));
        g.drawString("NEW GAME", 360, 465);
        g.drawRect((int)newGame.getX(), (int)newGame.getY(), (int)newGame.getWidth(), (int)newGame.getHeight());
        g.setFont(new Font("Broadway", Font.BOLD, 50));
        g.drawString("EXIT", 440, 625);
        g.drawRect((int)exit.getX(), (int)exit.getY(), (int)exit.getWidth(), (int)exit.getHeight());
        g.drawImage(startScreen,0,0,null);
    }
}