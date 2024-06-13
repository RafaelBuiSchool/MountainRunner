import javax.swing.JFrame;

public class HomeScreen extends JFrame implements Runnable {
    private Thread windowThread;
    private HomeScreenPainter homeScreen;

    public HomeScreen(String display) {
        super(display);
        int frameWidth = 1024;
        int frameHeight = 683;
        homeScreen = new HomeScreenPainter(this);
        this.add(homeScreen);
        //this.addKeyListener(p);
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
            homeScreen.repaint();
        }
    }
}