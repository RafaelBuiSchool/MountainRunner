import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.Font;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class WinScreenPainter extends JPanel implements MouseListener{
    private Rectangle playAgain;
    private Rectangle exit;
    private WinScreen ws;
    private LevelChooser levelChoice;
    public WinScreenPainter(WinScreen ws){this.addMouseListener(this);
        this.ws = ws;
        playAgain = new Rectangle(170,150,120,30);
        exit = new Rectangle(205,190,50,30);
    }
    protected void paintComponent(Graphics g) {
        BufferedImage homeScreen = null;
        try {
            homeScreen = ImageIO.read(new File("sprites/WinScreen.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        g.drawImage(homeScreen,0,0,getWidth(),getHeight(),null);
        g.setColor(Color.GREEN);
        g.setFont(new Font("Broadway", Font.BOLD, 20));
        g.drawString("PLAY AGAIN", 170, 170);
        g.setColor(Color.black);
        g.drawRect((int)playAgain.getX(), (int)playAgain.getY(), (int)playAgain.getWidth(), (int)playAgain.getHeight());
        g.setColor(Color.RED);
        g.setFont(new Font("Broadway", Font.BOLD, 20));
        g.drawString( "EXIT", 210, 210);
        g.setColor(Color.black);
        g.drawRect((int)exit.getX(), (int)exit.getY(), (int)exit.getWidth(), (int)exit.getHeight());
    }
    public void mousePressed(MouseEvent e){
        Point clicked = e.getPoint();
        if(e.getButton()==1){
            if(playAgain.contains(clicked)){
                levelChoice = new LevelChooser("Levels (CHOOSE YOUR LEVEL)");
                ws.dispose();
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