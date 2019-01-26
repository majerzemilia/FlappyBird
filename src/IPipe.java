public interface IPipe {

    IPipe getPipe();

    IGameObject getObject();

    void update();

    int getX();

    int getY();

    int getWidth();

    boolean collision(int bird_x, int bird_y, int bird_height, int bird_width);
}
