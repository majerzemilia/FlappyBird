import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GameObject {

    private int x;
    private int y;
    private Image image;

    public GameObject(int x, int y, String path)
    {
        this.x = x;
        this.y = y;
        this.image = loadImage(path);
    }

    public static Image loadImage(String path) {
        Image image = null;

        try {
            image = ImageIO.read(new File(path));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }
}
