import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.Font;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.KeyListener;


public class ContinuedGamePainter extends JPanel{
    private Rectangle platform;
    private Rectangle spike;
    private Rectangle door;
    private Rectangle bird;
    public ContinuedGamePainter(){

    }
    public void paintComponent(Graphics g){
        BufferedImage levelBackground = null;
        try {
            levelBackground = ImageIO.read(new File("sprites/LevelBackground.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        g.drawImage(levelBackground,0,0,getWidth(),getHeight(),null);

    }
}