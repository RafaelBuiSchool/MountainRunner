import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class Player {
    private BufferedImage characterLeft;
    private BufferedImage getCharacterRight;
    private final String faceLeft = "sprites/test.png";
    private final String faceRight = "sprites/test1.png";
    private int x;
    private int y;
    public Player(){
        characterLeft = loadImage(faceLeft);
        getCharacterRight = loadImage(faceRight);
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

    public BufferedImage getCharacterLeft() {
        return characterLeft;
    }

    public BufferedImage getCharacterRight() {
        return getCharacterRight;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
}
