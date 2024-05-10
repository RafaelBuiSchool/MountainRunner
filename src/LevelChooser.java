import javax.swing.JFrame;

public class LevelChooser extends JFrame implements Runnable {
    private Thread windowThread;
    private LevelChooserPainter x;

    public LevelChooser(String display) {
        super(display);
        int frameWidth = 626;
        int frameHeight = 416;
        x = new LevelChooserPainter();
        this.add(x);
        //this.addKeyListener(x);
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