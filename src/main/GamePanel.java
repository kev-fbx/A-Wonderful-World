package main;

import Entity.Player;

import javax.swing.JPanel;
import java.awt.*;

/**
 * Defines Panel for GUI and game loop logic
 */
public class GamePanel extends JPanel implements Runnable {

    /**
     * Initial dimension and scale factor of sprites
     */
    private final int ORG_TILE_SIZE = 16;
    private final int SCALE = 3;

    /**
     * Scale up tiles for modern screens
     */
    private final int TILE_SIZE = ORG_TILE_SIZE * SCALE;
    private final int MAX_COL = 16;
    private final int MAX_ROW = 12;

    /**
     * Calculate window size
     */
    private final int SCREEN_WIDTH = TILE_SIZE * MAX_COL;
    private final int SCREEN_HEIGHT = TILE_SIZE * MAX_ROW;

    private final InputHandler input = new InputHandler();
    private Thread gameThread;

    /**
     * Game FPS
     */
    private final int FPS = 60;

    /**
     * Initialise player
     */
    Player player = new Player(this, input);
    
    /**
     * Constructor for GamePanel class
     */
    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.LIGHT_GRAY);
        this.setDoubleBuffered(true);
        this.addKeyListener(input);
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
        player.update();
    }

    /**
     * Draw method to display graphics
     * @param graphics the <code>Graphics</code> object to protect
     */
    public void paintComponent(Graphics graphics) {

        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;
        player.draw(graphics2D);

        graphics2D.dispose();
    }

    public int getTILE_SIZE() {
        return TILE_SIZE;
    }
}
