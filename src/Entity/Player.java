package Entity;

import main.GamePanel;
import main.InputHandler;

import java.awt.*;

public class Player extends Entity {

    private final GamePanel gp;
    private final InputHandler input;

    public Player(GamePanel gp, InputHandler input) {
        this.gp = gp;
        this.input = input;
        setDefaultValues();
    }

    private void setDefaultValues() {
        setX(100);
        setY(100);
        setSpeed(4);
    }

    public void update() {
        if (input.isUpPressed()) {
            setY(getY() - getSpeed());
        }
        if (input.isDownPressed()) {
            setY(getY() + getSpeed());
        }
        if (input.isLeftPressed()) {
            setX(getX() - getSpeed());
        }
        if (input.isRightPressed()) {
            setX(getX() + getSpeed());
        }
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.GREEN);
        graphics2D.fillRect(getX(), getY(), gp.getTILE_SIZE(), gp.getTILE_SIZE());
    }
}
