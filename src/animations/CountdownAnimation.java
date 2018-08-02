package animations;

import java.awt.Color;
import biuoop.KeyboardSensor;
import sprites.SpriteCollection;
import biuoop.DrawSurface;
import biuoop.Sleeper;

/**
 * CountdownAnimation class. This class implements Animation.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public class CountdownAnimation implements Animation {

    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean stop;
    private Sleeper sleeper;
    private int current;
    private KeyboardSensor keyboard;
    private GameLevel level;

    /**
     * constructor.
     *
     * @param numOfSeconds
     *            - number of seconds to count.
     * @param countFrom
     *            - starting counting from it.
     * @param gameScreen
     *            - the current game screen.
     * @param k
     *            - keyboard sensor.
     * @param g
     *            - game level.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom,
            SpriteCollection gameScreen, KeyboardSensor k, GameLevel g) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.current = countFrom;
        this.gameScreen = gameScreen;
        this.stop = false;
        this.sleeper = new Sleeper();
        this.keyboard = k;
        this.level = g;
    }

    /**
     * @param d
     *            - current draw surface.
     * @param dt
     *            - the normalized value.
     */
    public void doOneFrame(DrawSurface d, double dt) {
        long timeToSleep = (long) (1000 / (numOfSeconds / countFrom));
        gameScreen.drawAllOn(d);
        d.setColor(Color.RED);
        d.drawText((d.getWidth() / 2) - 27, (d.getHeight() / 2) - 27,
                Integer.toString(this.current), 54);
        sleeper.sleepFor(timeToSleep);
        current--;
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)
                || keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            level.getPaddle().setLocation(level.getPadStart()); // Fixes early
                                                                // key pressing.
                                                                // Doesn't seem
                                                                // to help!
        }
        if (current < 0) {
            this.stop = true;
        }
    }

    /**
     * @return if it should stop.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
