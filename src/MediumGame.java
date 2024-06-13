import javax.swing.*;

public class MediumGame {
    private JFrame frame;
    private MediumGamePainter mediumGamePainter;

    public MediumGame(String title) {
        frame = new JFrame(title);
        mediumGamePainter = new MediumGamePainter(this);

        frame.add(mediumGamePainter);
        frame.setSize(1344, 896);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        mediumGamePainter.requestFocusInWindow();

        Timer timer = new Timer(16, e -> mediumGamePainter.updateYPos());
        timer.start();
    }

    public void dispose() {
        frame.dispose();
    }
}