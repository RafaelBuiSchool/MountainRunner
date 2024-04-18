import javax.swing.JFrame;

public class gameplayScreen extends JFrame implements Runnable {
    private Thread windowThread;
    private HomeScreenPainter p;

    public gameplayScreen(String display) {
        super(display);
        int frameWidth = 3000;
        int frameHeight = 2000;
        p = new HomeScreenPainter();
        this.add(p);
        //this.addKeyListener(p);
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