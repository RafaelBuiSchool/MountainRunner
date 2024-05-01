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

    private Rectangle continueGame;
    private Rectangle newGame;
    private Rectangle exit;
    private NewGame game;
    private ContinuedGame currentGame;
    public HomeScreenPainter(){
        continueGame = new Rectangle(800, 400, 320, 100);
        newGame = new Rectangle(800, 560, 320, 100);
        exit = new Rectangle(800, 720, 320, 100);
        this.addMouseListener(this);
        this.game = game;
        this.currentGame = currentGame;
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
        g.drawString("MOUNTAIN RUNNER", 705, 305);
        g.setFont(new Font("Broadway", Font.BOLD, 50));
        g.drawString("CONTINUE", 820, 465);
        g.drawRect((int)continueGame.getX(), (int)continueGame.getY(), (int)continueGame.getWidth(), (int)continueGame.getHeight());
        g.setFont(new Font("Broadway", Font.BOLD, 50));
        g.drawString("NEW GAME", 815, 625);
        g.drawRect((int)newGame.getX(), (int)newGame.getY(), (int)newGame.getWidth(), (int)newGame.getHeight());
        g.setFont(new Font("Broadway", Font.BOLD, 50));
        g.drawString("EXIT", 890, 785);
        g.drawRect((int)exit.getX(), (int)exit.getY(), (int)exit.getWidth(), (int)exit.getHeight());
    }
    public void mousePressed(MouseEvent e){
        Point clicked = e.getPoint();
        if(e.getButton()==1){
            if(continueGame.contains(clicked)){
                currentGame = new ContinuedGame("Levels (CONTINUED GAME)");
            }
            else if(newGame.contains(clicked)){
                game = new NewGame("Levels (NEW GAME)");
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