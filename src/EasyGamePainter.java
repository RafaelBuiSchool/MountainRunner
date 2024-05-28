import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//1344 x 896 = dimensions

public class EasyGamePainter extends JPanel {
    private Rectangle platform;
    private Rectangle spike;
    private Rectangle door;
    private MapReader m = new MapReader("Easy");

    public EasyGamePainter(EasyGame closeWhenCompleted) {
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage levelBackground = null;
        try {
            levelBackground = ImageIO.read(new File("sprites/EasyWorldBackground.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        g.drawImage(levelBackground, 0, 0, getWidth(), getHeight(), null);
        int x = 50;
        int y = 40;

        for (int row = 0; row < m.getMap().length; row++) {
            for (int col = 0; col < m.getMap()[0].length; col++) {
                TileLoader t = m.getMap()[row][col];
                if(t.getTileType() == 3){
                    g.drawImage(t.getImage(),x,y-30,null);
                }
                else if(t.getTileType() == 2){
                    g.drawImage(t.getImage(),x,y-60,null);
                }
                else{
                    g.drawImage(t.getImage(),x,y,null);
                }
                x += 45;
            }
            x =40;
            y+= 75;
        }
    }
}