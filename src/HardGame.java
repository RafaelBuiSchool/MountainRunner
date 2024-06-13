import javax.swing.*;

public class HardGame {
    private JFrame frame;
    private HardGamePainter hardGamePainter;

    public HardGame(String title) {
        frame = new JFrame(title);
        hardGamePainter = new HardGamePainter(this);

        frame.add(hardGamePainter);
        frame.setSize(1344, 896);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        hardGamePainter.requestFocusInWindow();

        Timer timer = new Timer(16, e -> hardGamePainter.updateYPos());
        timer.start();
    }

    public void dispose() {
        frame.dispose();
    }
}