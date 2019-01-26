import java.awt.*;

public class DownPipe implements IPipe, IGameObject{

    private int x;
    private int y;
    private int height;
    private int width;
    private int speed = 4;
    private Image image;

    public DownPipe() {

        this.width = 66;
        this.height = 400;
        this.x = App.WIDTH -2;
        this.image= GameObject.loadImage("images/pipe-north.png");
    }

    public void update() {
        x -= speed;
    }


    public boolean collision(int bird_x, int bird_y, int bird_height, int bird_width){

        int margin = 5;
        if(bird_x + bird_width - margin > x && bird_x + margin < x + width){
            if (bird_y + bird_height - margin > y) return true;
        }
        return false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getSpeed() {
        return speed;
    }

    public Image getImage() {
        return image;
    }

    public void setY(int y) {
        this.y = y;
    }

    public IPipe getPipe(){
        return this;
    }

    public IGameObject getObject(){
        return this;
    }
}
