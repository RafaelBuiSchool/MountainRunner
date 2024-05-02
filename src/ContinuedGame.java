import javax.swing.JFrame;

public class ContinuedGame extends JFrame implements Runnable {
    private Thread windowThread;
    private ContinuedGamePainter i;

    public ContinuedGame(String display) {
        super(display);
        int frameWidth = 3000;
        int frameHeight = 2000;
        i = new ContinuedGamePainter();
        this.add(i);
        //this.addKeyListener(i);
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
            i.repaint();
        }
    }
}
