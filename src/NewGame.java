import javax.swing.JFrame;

public class NewGame extends JFrame implements Runnable {
    private Thread windowThread;
    private NewGamePainter x;

    public NewGame(String display) {
        super(display);
        int frameWidth = 1344;
        int frameHeight = 896;
        x = new NewGamePainter(this);
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