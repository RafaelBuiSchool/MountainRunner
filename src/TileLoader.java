import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class TileLoader {
    private int tileType;
    private BufferedImage spike;
    private BufferedImage platform;
    private BufferedImage door;
    private int row;
    private int col;
    private boolean hasPlayer;
    private final String s = "sprites/SmallSpike.png";
    private final String d = "sprites/LevelDoor.png";
    private final String p = "sprites/LevelPlatform.png";
    public TileLoader(int tileType, int row, int col) {
        this.hasPlayer = false;
        this.row = row;
        this.col = col;

    }
    public void setPlayer(boolean hasPlayer) {
        this.hasPlayer = hasPlayer;
    }

    public boolean hasPlayer() {
        return hasPlayer;
    }
    public void setTileType(int tileType) {
        this.tileType = tileType;
        if (tileType == 1) {
            spike = loadImage(s);
        }
        if (tileType == 2) {
            platform = loadImage(p);
        }
        if (tileType == 3) {
            door = loadImage(d);
        }
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
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
