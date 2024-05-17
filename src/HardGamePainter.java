import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class HardGamePainter extends JPanel{
    private Rectangle platform;
    private Rectangle spike;
    private Rectangle door;

    public HardGamePainter(HardGame closeWhenCompleted){

    }
    public void paintComponent(Graphics g){
        BufferedImage levelBackground = null;
        try {
            levelBackground = ImageIO.read(new File("sprites/HardWorldBackground.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        g.drawImage(levelBackground,0,0,getWidth(),getHeight(),null);


    }
}