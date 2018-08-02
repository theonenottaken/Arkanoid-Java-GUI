package animations;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * PauseScreen class. This class implements Animation.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;

    // private boolean stop;
    /**
     * constructor.
     *
     * @param k
     *            - keyboard.
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        // this.stop = false;
    }

    /**
     * @param d
     *            current draw surface.
     * @param dt
     *            - the normalized value.
     */
    public void doOneFrame(DrawSurface d, double dt) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue",
                32);
        // if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
        // this.stop = true;
        // }
    }

    /**
     * @return - if it should stop.
     */
    public boolean shouldStop() {
        // return this.stop;
        return false;
    }
}
