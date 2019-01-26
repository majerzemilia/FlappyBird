import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Game {

    private final int DELAY = 80;

    private int pipeDelay;

    private Bird bird;
    private ArrayList<IPipe> pipes;
    private Keyboard keyboard;

    public int score;
    public Boolean gameover;
    public Boolean started;

    public Game() {
        keyboard = Keyboard.getInstance();
        restart();
    }


    public void restart() {

        started = false;
        gameover = false;

        score = 0;
        pipeDelay = 0;

        bird = new Bird();
        pipes = new ArrayList<IPipe>();
    }

    private void ifStart() {
        if (!started && keyboard.isDown(KeyEvent.VK_SPACE)) {
            started = true;
        }
    }

    private void ifRestart() {

        if (keyboard.isDown(KeyEvent.VK_R)) {
            restart();
            return;
        }
    }

    public void update() {
        ifStart();

        if (!started) return;

        ifRestart();

        bird.update();

        if (gameover) return;

        movePipes();
        checkForCollisions();
    }

    private void movePipes() {
        pipeDelay--;

        if (pipeDelay < 0) {
            pipeDelay = DELAY;
            UpperPipe upperPipe = new UpperPipe();
            DownPipe downPipe = new DownPipe();

            this.pipes.removeIf(pipe -> pipe.getX() < 0);

            downPipe.setY(upperPipe.getY() + upperPipe.getHeight() + 100);
            pipes.add(upperPipe);
            pipes.add(downPipe);
        }

        for (IPipe pipe : pipes) {
            pipe.update();
        }
    }

    private void checkForCollisions() {

        for (IPipe pipe : pipes) {
            if (pipe.collision(bird.getX(), bird.getY(), bird.getWidth(), bird.getHeight()))
                gameover = true;
            else if (pipe.getX() + pipe.getWidth() > bird.getX() && pipe.getX() + pipe.getWidth() -5 < bird.getX()
            && pipe instanceof DownPipe)
                score++;
        }

        if (bird.getY() + bird.getHeight() > App.HEIGHT - 80) {
            gameover = true;
            bird.setY(App.HEIGHT - 80 - bird.getHeight());
        }
    }

    public ArrayList<IGameObject> getGameObjects() {
        ArrayList<IGameObject> result =new ArrayList<>();
        for (IPipe pipe : pipes) {
            result.add(pipe.getObject());
        }
        result.add(bird.getObject());
        return result;
    }

}
