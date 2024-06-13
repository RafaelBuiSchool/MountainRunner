import javax.swing.*;

public class EasyGame {
    private JFrame frame;
    private EasyGamePainter easyGamePainter;

    public EasyGame(String title) {
        frame = new JFrame(title);
        easyGamePainter = new EasyGamePainter(this);

        frame.add(easyGamePainter);
        frame.setSize(1344, 896);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        easyGamePainter.requestFocusInWindow();

        Timer timer = new Timer(16, e -> easyGamePainter.updateYPos());
        timer.start();
    }

    public void dispose() {
        frame.dispose();
    }
}