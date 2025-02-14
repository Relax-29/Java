import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BreakoutGame extends JPanel implements KeyListener {
    private int paddleX = 250; // Paddle initial X position
    private final int PADDLE_WIDTH = 100;
    private final int PADDLE_HEIGHT = 10;
    private final int WINDOW_WIDTH = 600;
    private final int WINDOW_HEIGHT = 400;

    public BreakoutGame() {
        this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        this.setBackground(Color.BLACK);
        addKeyListener(this);
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(paddleX, WINDOW_HEIGHT - 50, PADDLE_WIDTH, PADDLE_HEIGHT); // Draw paddle
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT && paddleX > 0) {
            paddleX -= 20; // Move left
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && paddleX < WINDOW_WIDTH - PADDLE_WIDTH) {
            paddleX += 20; // Move right
        }
        repaint(); // Redraw screen
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Breakout Game");
        BreakoutGame game = new BreakoutGame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
