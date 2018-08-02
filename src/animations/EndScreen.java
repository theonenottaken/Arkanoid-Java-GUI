package animations;

import biuoop.KeyboardSensor;
import biuoop.DrawSurface;

/**
 * EndScreen class. This class implements Animation.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public class EndScreen implements Animation {
    private KeyboardSensor keyboard;
    // private boolean stop;
    private boolean gameOver;
    private int score;

    /**
     * constructor.
     *
     * @param keyboard
     *            - keyboard's key.
     * @param over
     *            - either the game is over or not.
     * @param score
     *            - current score.
     */
    public EndScreen(KeyboardSensor keyboard, boolean over, int score) {
        this.keyboard = keyboard;

        this.gameOver = over;
        this.score = score;
    }

    /**
     * @param d
     *            - current draw surface.
     * @param dt
     *            - the normalized value.
     */
    public void doOneFrame(DrawSurface d, double dt) {
        String message;
        if (this.gameOver) {
            message = "Game Over. Your score is " + this.score;
        } else {
            message = "You Win! Your score is " + this.score;
        }
        d.drawText(30, d.getHeight() / 2, message, 32);
        // if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
        // this.stop = true;
        // }
    }

    /**
     * @return if this animation should stop or not.
     */
    public boolean shouldStop() {
        // return this.stop;
        return false;
    }
}
