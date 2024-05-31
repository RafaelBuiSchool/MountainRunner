import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class Player {
    private BufferedImage characterLeft;
    private BufferedImage characterRight;
    private final String faceLeft = "sprites/test.png";
    private final String faceRight = "sprites/test1.png";
    private int x = 55;
    private int y = 27;
    private int tempX;
    private int tempY;

    public Player() {
        characterLeft = loadImage(faceLeft);
        characterRight = loadImage(faceRight);
    }

    public BufferedImage loadImage(String fileName) {
        try {
            BufferedImage image;
            image = ImageIO.read(new File(fileName));
            return image;
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }

    public BufferedImage getCharacterLeft() {
        return characterLeft;
    }

    public BufferedImage getCharacterRight() {
        return characterRight;
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

    public int getTempX() {
        return tempX;
    }

    public void setTempX(int tempX) {
        this.tempX = tempX;
    }

    public int getTempY() {
        return tempY;
    }

    public void setTempY(int tempY) {
        this.tempY = tempY;
    }
}

