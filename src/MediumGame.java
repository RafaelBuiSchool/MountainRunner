import javax.swing.JFrame;

public class MediumGame extends JFrame implements Runnable {
    private Thread windowThread;
    private MediumGamePainter x;

    public MediumGame(String display) {
        super(display);
        int frameWidth = 1344;
        int frameHeight = 896;
        x = new MediumGamePainter(this);
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