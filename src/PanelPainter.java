import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class PanelPainter extends JPanel{

    private Rectangle continueGame;
    private Rectangle newGame;
    private Rectangle exit;
    public PanelPainter(){
        continueGame = new Rectangle(350, 240, 300, 100);
        newGame = new Rectangle(350, 400, 300, 100);
        exit = new Rectangle(350, 560, 300, 100);
    }
    protected void paintComponent(Graphics g) {
        g.setFont(new Font("Courier New", Font.BOLD, 50));
        g.drawString("CONTINUE", 380, 305);
        g.drawRect((int)continueGame.getX(), (int)continueGame.getY(), (int)continueGame.getWidth(), (int)continueGame.getHeight());
        g.setFont(new Font("Courier New", Font.BOLD, 50));
        g.drawString("NEW GAME", 380, 465);
        g.drawRect((int)newGame.getX(), (int)newGame.getY(), (int)newGame.getWidth(), (int)newGame.getHeight());
        g.setFont(new Font("Courier New", Font.BOLD, 50));
        g.drawString("EXIT", 440, 625);
        g.drawRect((int)exit.getX(), (int)exit.getY(), (int)exit.getWidth(), (int)exit.getHeight());
    }
}