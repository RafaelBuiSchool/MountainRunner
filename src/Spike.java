
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
public class Spike{
    private BufferedImage spike;
    private int row;
    private int col;
    private final String image = "sprites/SmallSpike.png";
    public Spike(int row, int col){
        this.row = row;
        this.col = col;
        spike = loadImage(image);
    }
    public BufferedImage loadImage(String fileName) {
        try {
            BufferedImage image;
            image = ImageIO.read(new File(fileName));
            return image;
        }
        catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }
    public BufferedImage getSpike() {
        return spike;
    }
}
