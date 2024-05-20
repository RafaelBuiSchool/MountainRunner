import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class Player {
    private BufferedImage characterLeft;
    private BufferedImage getCharacterRight;
    private final String faceLeft = "sprites/PlayerLeft.png";
    private final String faceRight = "sprites/PlayerRight.png";
    private int row;
    private int col;
    public Player(int row, int col){
        this.row = row;
        this.col = col;
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

    public BufferedImage getGetCharacterRight() {
        return getCharacterRight;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
