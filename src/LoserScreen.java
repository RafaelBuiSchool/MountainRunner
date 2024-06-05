import javax.swing.JFrame;

public class LoserScreen extends JFrame implements Runnable {
    private Thread windowThread;
    private LoserScreenPainter x;

    public LoserScreen(String display) {
        super(display);
        int frameWidth = 480;
        int frameHeight = 270;
        x = new LoserScreenPainter(this);
        this.add(x);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(frameWidth, frameHeight);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        startThread();

    }

    public void startThread() {
        windowThread = new Thread(this);
        windowThread.start();
    }

    public void run() {
        while (true) {
            x.repaint();
        }
    }
}