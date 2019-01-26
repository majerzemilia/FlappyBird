import javax.swing.*;
import java.awt.*;

public class GameVisualiser extends JPanel implements Runnable {

    private Game game;
    private GameObject background;
    private GameObject foreground;

    public GameVisualiser() {
        game = new Game();
        background = new GameObject(0, 0, "images/background.png");
        foreground = new GameObject(0, 0, "images/foreground.png");
        new Thread(this).start();
    }

    public void update() {
        game.update();
        repaint();
    }

    public void run() {
        try {
            while (true) {
                update();
                Thread.sleep(25);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(background.getImage(),background.getX(),background.getY(),null);
        for (IGameObject obj : game.getGameObjects()) {
            g2D.drawImage(obj.getImage(), obj.getX(), obj.getY(), null);
        }
        g2D.drawImage(foreground.getImage(),foreground.getX(),foreground.getY(),null);


        g2D.setColor(Color.BLACK);

        if (!game.started) {
            g2D.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
            g2D.drawString("Press SPACE to start", 150, 240);
        } else {
            g2D.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
            g2D.drawString(Integer.toString(game.score), 10, 460);
        }

        if (game.gameover) {
            g2D.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
            g2D.drawString("Press R to restart", 150, 240);
        }
    }
}
