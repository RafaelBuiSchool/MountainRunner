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

public class EasyGamePainter extends JPanel implements KeyListener{
    private ArrayList<Rectangle> platformChecker = new ArrayList<>();
    private ArrayList<Rectangle> spikeChecker = new ArrayList<>();
    private Rectangle player;
    private Rectangle platform;
    private Rectangle spike;
    private Rectangle campfire;
    private EasyGame closeWhenCompleted;
    private LoserScreen loseScreen;
    private WinScreen winScreen;
    private boolean lose = false;
    private boolean win = false;
    private MapReader m = new MapReader("Easy");
    private boolean isJumping = false;
    private boolean isFalling  = false;
    private int jumpHeight = 45;
    private int jumpSpeed = 15;
    private int fallSpeed = 3;
    private int initialYValue;
    private boolean movingLeft = false;
    private boolean movingRight = false;
    public EasyGamePainter(EasyGame closeWhenCompleted) {
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.closeWhenCompleted = closeWhenCompleted;
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

        int x = 40;
        int y = 55;
        for (int row = 0; row < m.getMap().length; row++) {
            for (int col = 0; col < m.getMap()[0].length; col++) {
                if(m.getPlayer().getX() == 55 && m.getPlayer().getY() == 27){
                    g.drawImage(m.getPlayer().getCharacterRight(),55,27,null);
                    player = new Rectangle(m.getPlayer().getX(),m.getPlayer().getY(),25,35);
                }
                else{
                    player = new Rectangle(m.getPlayer().getX(),m.getPlayer().getY()+25,25,10);
                    for(Rectangle i:spikeChecker){
                        if(player.intersects(i)){
                            lose = true;
                        }
                    }
                    if(player.intersects(campfire)){
                        win = true;
                    }
                    g.drawImage(m.getPlayer().getTemp(),m.getPlayer().getX(),m.getPlayer().getY(),null);
                    player = new Rectangle(m.getPlayer().getX(),m.getPlayer().getY(),25,35);
                }
                TileLoader t = m.getMap()[row][col];
                if(t.getTileType() == 3){
                    g.drawImage(t.getImage(),x+13,y-30,null);
                    campfire = new Rectangle(x+20,y-30,40,60);
                }
                else if(t.getTileType() == 2){
                    g.drawImage(t.getImage(),x+15,y-12,null);
                    spike = new Rectangle(x+25,y-5,32,28);
                    spikeChecker.add(spike);

                }
                else if(t.getTileType() == 1){
                    g.drawImage(t.getImage(),x+10,y,null);
                    platform = new Rectangle(x+17,y+5,47,5);
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
    public void jump(){
        if(!isJumping && !isFalling){
            isJumping = true;
            initialYValue = m.getPlayer().getY();
        }
    }
    public void updateYPos(){
        if(isJumping == true){
            if(m.getPlayer().getY() > initialYValue - jumpHeight){
                m.getPlayer().setY(m.getPlayer().getY()-jumpSpeed);
            }
            else{
                isJumping = false;
                isFalling = true;
            }
        }
        else if(isFalling) {
            boolean onPlat = false;
            for (Rectangle i : platformChecker) {
                if (player.intersects(i)) {
                    onPlat = true;
                    break;
                }
            }
            if (!(onPlat == true) && m.getPlayer().getY() + fallSpeed <= 896) {
                m.getPlayer().setY(m.getPlayer().getY() + fallSpeed);
            } else {
                isFalling = false;
            }
        }
        else {
            boolean onPlat = false;
            for (Rectangle i : platformChecker) {
                if (player.intersects(i)) {
                    onPlat = true;
                    break;
                }
            }
            if (!(onPlat == true)) {
                isFalling = true;
            }
        }
        if(movingLeft == true){
            m.move("W");
        }
        if(movingRight == true){
            m.move("E");
        }
        repaint();
    }
    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_A) {
            movingLeft = true;
        }
        if (key == KeyEvent.VK_D) {
            movingRight = true;
        }
        if (key == KeyEvent.VK_W) {
            jump();
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_A) {
            movingLeft = false;
        }
        if (key == KeyEvent.VK_D) {
            movingRight = false;
        }

    }
}