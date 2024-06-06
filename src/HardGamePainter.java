import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

//1344 x 896 = dimensions

public class HardGamePainter extends JPanel implements KeyListener{
    private ArrayList<Rectangle> platformChecker = new ArrayList<>();
    private ArrayList<Rectangle> spikeChecker = new ArrayList<>();
    private Rectangle player;
    private Rectangle platform;
    private Rectangle spike;
    private Rectangle campfire;
    private HardGame closeWhenCompleted;
    private LoserScreen loseScreen;
    private WinScreen winScreen;
    private boolean lose = false;
    private boolean win = false;
    private MapReader m = new MapReader("Hard");
    public HardGamePainter(HardGame closeWhenCompleted) {
        this.addKeyListener(this);
        this.setFocusable(true);
        this.closeWhenCompleted = closeWhenCompleted;
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
                    player = new Rectangle(m.getPlayer().getX(),m.getPlayer().getY(),25,35);
                    g.drawRect(m.getPlayer().getX(),m.getPlayer().getY(),25,35);
                }
                else{
                    player = new Rectangle(m.getPlayer().getX(),m.getPlayer().getY(),25,35);
                    g.drawRect(m.getPlayer().getX(),m.getPlayer().getY(),25,35);
                    for(Rectangle i:spikeChecker){
                        if(player.intersects(i)){
                            lose = true;
                        }
                    }
                    if(player.intersects(campfire)){
                        win = true;
                    }
                    g.drawImage(m.getPlayer().getTemp(),m.getPlayer().getX(),m.getPlayer().getY(),null);
                    player = new Rectangle(m.getPlayer().getX(),m.getPlayer().getY(),m.getPlayer().getX()+28,m.getPlayer().getY()+39);
                }
                TileLoader t = m.getMap()[row][col];
                if(t.getTileType() == 3){
                    g.drawImage(t.getImage(),x+13,y-30,null);
                    campfire = new Rectangle(x+20,y-30,40,60);
                    g.drawRect(x+20,y-30,40,60);
                }
                else if(t.getTileType() == 2){
                    g.drawImage(t.getImage(),x+15,y-12,null);
                    spike = new Rectangle(x+25,y-10,32,30);
                    g.drawRect(x+25,y-10,32,30);
                    spikeChecker.add(spike);

                }
                else if(t.getTileType() == 1){
                    g.drawImage(t.getImage(),x+10,y,null);
                    platform = new Rectangle(x+17,y+5,47,20);
                    g.drawRect(x+17,y+5,47,20);
                    platformChecker.add(platform);
                }
                x += 45;
            }
            x =40;
            y+= 85;
        }
        if(lose == true){
            loseScreen = new LoserScreen("YOU LOST");
            closeWhenCompleted.dispose();
        }
        if(win == true){
            winScreen = new WinScreen("YOU WIN");
            closeWhenCompleted.dispose();
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