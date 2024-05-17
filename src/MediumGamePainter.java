import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class MediumGamePainter extends JPanel{
    private Rectangle platform;
    private Rectangle spike;
    private Rectangle door;

    public MediumGamePainter(MediumGame closeWhenCompleted){

    }
    public void paintComponent(Graphics g){
        BufferedImage levelBackground = null;
        try {
            levelBackground = ImageIO.read(new File("sprites/MediumWorldBackground.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        g.drawImage(levelBackground,0,0,getWidth(),getHeight(),null);


    }
}