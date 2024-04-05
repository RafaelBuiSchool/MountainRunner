import javax.swing.JFrame;
import java.awt.*;

public class MainFrame extends JFrame implements Runnable {
    private Thread windowThread;
    private PanelPainter p;

    public MainFrame(String display) {
        super(display);
        int frameWidth = 1000;
        int frameHeight = 2000;
        p = new PanelPainter();
        this.add(p);
       // this.addKeyListener(p);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(frameWidth, frameHeight);
        this.setLocation(0, 0);
        this.setVisible(true);
        startThread();

    }

    public void startThread() {
        windowThread = new Thread(this);
        windowThread.start();
    }

    public void run() {
        while (true) {
            p.repaint();
        }
    }
}