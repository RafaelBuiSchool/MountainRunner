import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.Font;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LevelChooserPainter extends JPanel implements MouseListener{
    private Rectangle easy;
    private Rectangle medium;
    private Rectangle hard;
    private NewGame game;
    private LevelChooser sc;

    public LevelChooserPainter(LevelChooser sc){
        this.sc = sc;
        easy = new Rectangle(160, 65, 300, 70);
        medium = new Rectangle(160, 155, 300, 70);
        hard = new Rectangle(160,245,300,70);
        this.addMouseListener(this);
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
        Color easyColor = new Color(216,240,239);
        g.setColor(easyColor);
        g.fillRect(160,65,300,70);
        g.setFont(new Font("Elephant", Font.PLAIN, 50));
        g.setColor(Color.BLACK);
        g.drawString("EASY", 230, 120);
        g.drawRect((int)easy.getX(), (int)easy.getY(), (int)easy.getWidth(), (int)easy.getHeight());
        Color mediumColor = new Color(186,204,209);
        g.setColor(mediumColor);
        g.fillRect(160,155,300,70);
        g.setFont(new Font("Elephant", Font.PLAIN, 50));
        g.setColor(Color.BLACK);
        g.drawString("MEDIUM", 175, 210);
        g.drawRect((int)medium.getX(), (int)medium.getY(), (int)medium.getWidth(), (int)medium.getHeight());
        Color hardColor = new Color(32,222,232);
        g.setColor(hardColor);
        g.fillRect(160,245,300,70);
        g.setFont(new Font("Elephant", Font.PLAIN, 50));
        g.setColor(Color.BLACK);
        g.drawString("HARD", 225, 300);
        g.drawRect((int)hard.getX(), (int)hard.getY(), (int)hard.getWidth(), (int)hard.getHeight());

    }
    public void mousePressed(MouseEvent e){
        Point clicked = e.getPoint();
        if(e.getButton()==1){
            if(easy.contains(clicked)){
                game = new NewGame("EASY LEVEL");
                sc.dispose();
            }
            else if(medium.contains(clicked)){
                game = new NewGame("HARD LEVEL");
                sc.dispose();
            }
            else if(hard.contains(clicked)){
                game = new NewGame("HARD LEVEL");
                sc.dispose();
            }
        }
    }
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) { }
}