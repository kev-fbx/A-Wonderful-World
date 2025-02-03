package src.main;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

// Defines Panel for GUI
public class GamePanel extends JPanel implements Runnable {

    final int ORG_TILE_SIZE = 16;
    final int SCALE = 3;

    final int TILE_SIZE = ORG_TILE_SIZE * SCALE;
    final int MAX_COL = 16;
    final int MAX_ROW = 12;

    final int SCREEN_WIDTH = TILE_SIZE * MAX_COL;
    final int SCREEN_HEIGHT = TILE_SIZE * MAX_ROW;

    Thread gameThread;

    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.LIGHT_GRAY);
        this.setDoubleBuffered(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while (gameThread != null) {
            System.out.println("Test");
        }
    }
}
