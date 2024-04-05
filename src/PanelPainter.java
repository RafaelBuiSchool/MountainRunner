import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.Point;
import java.util.ArrayList;
import java.awt.Font;



public class PanelPainter extends JPanel{

    private Rectangle continueGame;
    private Rectangle newGame;
    private Rectangle exit;
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Courier New", Font.BOLD, 20));
        g.drawString("NEW GAME", 130, 260);
        g.drawRect((int)newGame.getX(), (int) newGame.getY(), (int) newGame.getWidth(), (int) newGame.getHeight());
    }
}