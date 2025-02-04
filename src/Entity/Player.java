package src.Entity;

import src.main.GamePanel;
import src.main.InputHandler;

import java.awt.*;

public class Player extends Entity {

    private GamePanel gp;
    private InputHandler input;

    public Player(GamePanel gp, InputHandler input) {
        this.gp = gp;
        this.input = input;
        setDefaultValues();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
    }

    public void update() {
        if (input.upPressed) {
            y -= speed;
        }
        if (input.downPressed) {
            y += speed;
        }
        if (input.leftPressed) {
            x -= speed;
        }
        if (input.rightPressed) {
            x += speed;
        }
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.GREEN);
        graphics2D.fillRect(x, y, gp.getTILE_SIZE(), gp.getTILE_SIZE());
    }
}
