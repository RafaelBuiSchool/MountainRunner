import javax.swing.JFrame;

public class NewGame extends JFrame implements Runnable {
    private Thread windowThread;
    private NewGamePainter x;

    public NewGame(String display) {
        super(display);
        int frameWidth = 3000;
        int frameHeight = 2000;
        x = new NewGamePainter();
        this.add(x);
        //this.addKeyListener(x);
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
            x.repaint();
        }
    }
}