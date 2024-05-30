import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class TileLoader {
    private int tileType;
    private BufferedImage image;
    private int row;
    private int col;
    private boolean hasPlayer;
    private final String s = "sprites/Spike.png";
    private final String c = "sprites/CampFire.png";
    private final String p = "sprites/Platform.png";
    public TileLoader(int tileType, int row, int col) {
        this.setTileType(tileType);
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
            image = loadImage(p);
        }
        if (tileType == 2) {
            image = loadImage(s);
        }
        if (tileType == 3) {
            image = loadImage(c);
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
    public BufferedImage getImage(){
        return image;
    }
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getTileType() {
        return tileType;
    }
}
