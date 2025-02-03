package src.main;

import javax.swing.JPanel;
import java.awt.*;

/**
 * Defines Panel for GUI
 */
public class GamePanel extends JPanel implements Runnable {

    /**
     * Initial dimension and scale factor of sprites
     */
    final int ORG_TILE_SIZE = 16;
    final int SCALE = 3;

    /**
     * Scale up tiles for modern screens
     */
    final int TILE_SIZE = ORG_TILE_SIZE * SCALE;
    final int MAX_COL = 16;
    final int MAX_ROW = 12;

    /**
     * Calculate window size
     */
    final int SCREEN_WIDTH = TILE_SIZE * MAX_COL;
    final int SCREEN_HEIGHT = TILE_SIZE * MAX_ROW;

    Thread gameThread;

    /**
     * Constructor for GamePanel class
     */
    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.LIGHT_GRAY);
        this.setDoubleBuffered(true);
    }

    /**
     * Initialises the game thread
     */
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * Game loop function
     */
    @Override
    public void run() {
        while (gameThread != null) {
            System.out.println("Test");

            update();
            repaint();
        }
    }

    public void update() {

    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics2D.setColor(Color.GREEN);
        graphics2D.fillRect(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2, TILE_SIZE, TILE_SIZE);
        graphics2D.dispose();
    }
}
