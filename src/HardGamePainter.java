import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//1344 x 896 = dimensions

public class HardGamePainter extends JPanel implements KeyListener{
    private Rectangle platform;
    private Rectangle spike;
    private Rectangle campfire;
    private MapReader m = new MapReader("Hard");
    public HardGamePainter(HardGame closeWhenCompleted) {
        this.addKeyListener(this);
        this.setFocusable(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage levelBackground = null;
        try {
            levelBackground = ImageIO.read(new File("sprites/HardWorldBackground.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        g.drawImage(levelBackground, 0, 0, getWidth(), getHeight(), null);

        int x = 40;
        int y = 55;
        for (int row = 0; row < m.getMap().length; row++) {
            for (int col = 0; col < m.getMap()[0].length; col++) {
                if(m.getPlayer().getX() == 55 && m.getPlayer().getY() == 27){
                    g.drawImage(m.getPlayer().getCharacterRight(),55,27,null);
                }
                else{
                    g.drawImage(m.getPlayer().getTemp(),m.getPlayer().getX(),m.getPlayer().getY(),null);
                }
                TileLoader t = m.getMap()[row][col];
                if(t.getTileType() == 3){
                    g.drawImage(t.getImage(),x+13,y-30,null);
                    campfire = new Rectangle(x+13,y-30,x+45,y-10);
                }
                else if(t.getTileType() == 2){
                    g.drawImage(t.getImage(),x+15,y-12,null);
                    spike = new Rectangle(x+16,y-12,x+44,y-5);

                }
                else if(t.getTileType() == 1){
                    g.drawImage(t.getImage(),x+10,y,null);
                    platform = new Rectangle(x+10,y,x+45,y-10);
                }
                x += 45;
            }
            x =40;
            y+= 85;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char key = e.getKeyChar();
        if (key == 'a') {
            m.move("W");
        }
        if (key == 'd') {
            m.move("E");
        }
    }



    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {

    }
}