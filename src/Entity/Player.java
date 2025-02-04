package Entity;

import main.GamePanel;
import main.InputHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity {

    private final GamePanel gp;
    private final InputHandler input;

    public Player(GamePanel gp, InputHandler input) {
        this.gp = gp;
        this.input = input;
        setDefaultValues();
        getPlayerImg();
    }

    private void getPlayerImg() {
        try {
            setUp1(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/Ghost.png"))));
            setDown1(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/Ghost.png"))));
            setLeft1(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/Ghost.png"))));
            setRight1(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/Ghost.png"))));
        } catch (IOException e) {
            System.out.println("getPlayerImage error");
            e.printStackTrace();
        }
    }

    private void setDefaultValues() {
        setX(100);
        setY(100);
        setSpeed(4);
        setDirection("D");
    }

    public void update() {
        if (input.isUpPressed()) {
            setDirection("up");
            setY(getY() - getSpeed());
        }
        if (input.isDownPressed()) {
            setDirection("down");
            setY(getY() + getSpeed());
        }
        if (input.isLeftPressed()) {
            setDirection("left");
            setX(getX() - getSpeed());
        }
        if (input.isRightPressed()) {
            setDirection("right");
            setX(getX() + getSpeed());
        }
    }

    public void draw(Graphics2D graphics2D) {
        BufferedImage img = switch (getDirection()) {
            case "up" -> getUp1();
            case "down" -> getDown1();
            case "left" -> getLeft1();
            case "right" -> getRight1();
            default -> null;
        };

        graphics2D.drawImage(img, getX(), getY(), gp.getTILE_SIZE(), gp.getTILE_SIZE(), null);

    }
}
