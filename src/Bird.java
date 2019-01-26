import java.awt.*;
import java.awt.event.KeyEvent;

public class Bird implements IGameObject{

    private int x;
    private int y;
    private int width;
    private int height;

    private double gravity;

    private int jump;
    private double ySpeed;

    private Image image;
    private Keyboard keyboard;

    public Bird(){

        this.x = 100;
        this.y = 150;
        this.width = 45;
        this.height = 32;
        this.gravity = 0.5;
        this.jump = 0;
        this.keyboard = Keyboard.getInstance();
        this.ySpeed = 0.0;
        this.image= GameObject.loadImage("images/bird.png");
    }

    public void update(){

        ySpeed += gravity;

        if(jump > 0) jump --;

        if(keyboard.isDown(KeyEvent.VK_SPACE) && jump <= 0){

            ySpeed -= 10;
            jump = 15;
        }

        y += ySpeed;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Image getImage() {
        return image;
    }

    public void setY(int y) {
        this.y = y;
    }

    public IGameObject getObject(){
        return this;
    }

}
