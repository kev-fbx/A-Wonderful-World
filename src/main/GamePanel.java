package src.main;

import javax.swing.JPanel;
import java.awt.*;

/**
 * Defines Panel for GUI and game loop logic
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

    InputHandler inputHandler = new InputHandler();
    Thread gameThread;

    /**
     * Game FPS
     */
    final int FPS = 60;

    /**
     * Initialise player position
     */
    int playerX = SCREEN_WIDTH/2;
    int playerY = SCREEN_HEIGHT/2;
    int playerSpeed = 4;

    /**
     * Constructor for GamePanel class
     */
    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.LIGHT_GRAY);
        this.setDoubleBuffered(true);
        this.addKeyListener(inputHandler);
        this.setFocusable(true);
    }

    /**
     * Initialises the game thread
     */
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * Main game loop method. Updates the game state and renders at a constant FPS
     */
    @Override
    public void run() {

        /*
          Time that passes for each frame, calculated as 1s/ frame
         */
        double drawInterval = (double) 1000000000 / FPS;
        /*
          Normalised time that has passed since last frame
         */
        double delta = 0;
        long lastTime = System.nanoTime();
        long currTime;

        while (gameThread != null) {

            currTime = System.nanoTime();
            delta += (currTime - lastTime) / drawInterval;
            lastTime = currTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    /**
     * Update logic of game
     */
    public void update() {
        if (inputHandler.upPressed) {
            playerY -= playerSpeed;
        }
        if (inputHandler.downPressed) {
            playerY += playerSpeed;
        }
        if (inputHandler.leftPressed) {
            playerX -= playerSpeed;
        }
        if (inputHandler.rightPressed) {
            playerX += playerSpeed;
        }
    }

    /**
     * Draw method to display graphics
     * @param graphics the <code>Graphics</code> object to protect
     */
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics2D.setColor(Color.GREEN);
        graphics2D.fillRect(playerX, playerY, TILE_SIZE, TILE_SIZE);
        graphics2D.dispose();
    }
}
