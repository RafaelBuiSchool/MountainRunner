import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.Font;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class LoserScreenPainter extends JPanel implements MouseListener{
    private Rectangle playAgain;
    private Rectangle exit;
    private LoserScreen ls;
    private LevelChooser levelChoice;
    private final String ANSI_RED = "\u001B[31m";
    private final String ANSI_GREEN = "\u001B[32m";
    public LoserScreenPainter(LoserScreen ls){
       this.ls = ls;
       playAgain = new Rectangle(10,230,50,30);
       exit = new Rectangle(300,230,50,30);
    }
    protected void paintComponent(Graphics g) {
        BufferedImage homeScreen = null;
        try {
            homeScreen = ImageIO.read(new File("sprites/LoseScreen.gif"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        g.drawImage(homeScreen,0,0,getWidth(),getHeight(),null);
        g.setFont(new Font("Broadway", Font.BOLD, 20));
        g.drawString(ANSI_GREEN+ "PLAY AGAIN", 170, 170);
        g.drawRect((int)playAgain.getX(), (int)playAgain.getY(), (int)playAgain.getWidth(), (int)playAgain.getHeight());
        g.setFont(new Font("Broadway", Font.BOLD, 20));
        g.drawString( ANSI_RED + "EXIT", 210, 210);
        g.drawRect((int)exit.getX(), (int)exit.getY(), (int)exit.getWidth(), (int)exit.getHeight());
    }
    public void mousePressed(MouseEvent e){
        Point clicked = e.getPoint();
        if(e.getButton()==1){
            if(playAgain.contains(clicked)){
                levelChoice = new LevelChooser("Levels (CHOOSE YOUR LEVEL)");
                ls.dispose();
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