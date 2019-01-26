import java.awt.*;

public class UpperPipe implements IPipe, IGameObject{

    private int x;
    private int y;
    private int width;
    private int height;
    private int speed = 4;
    private Image image;
    private GameObject object = new GameObject(x,y,"images/pipe-south.png");

    public UpperPipe(){

        this.width = 66;
        this.height = 400;
        this.x = App.WIDTH -2;
        this.y = -(int)(Math.random() * 120) - height / 2;
        this.image = object.getImage();
    }

    public void update(){
        x -= speed;
    }

    public boolean collision(int bird_x, int bird_y, int bird_height, int bird_width){

        int margin = 5;
        if(bird_x + bird_width - margin > x && bird_x + margin < x + width){
            if (bird_y + margin < y + height) return true;
        }
        return false;
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

    public int getSpeed() {
        return speed;
    }

    public Image getImage() {
        return image;
    }

    public IPipe getPipe(){
        return this;
    }

    public IGameObject getObject(){
        return this;
    }
}
