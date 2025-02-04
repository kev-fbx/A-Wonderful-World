package Entity;

import java.awt.image.BufferedImage;

public class Entity {

    private int x, y;
    private int speed;

    private BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    private String direction;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
