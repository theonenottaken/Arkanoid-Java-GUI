package animations;

import biuoop.KeyboardSensor;
import biuoop.DrawSurface;

/**
 * KeyPressStoppableAnimation class. This class implements Animation.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */

public class KeyPressStoppableAnimation implements Animation {

    private KeyboardSensor keyboard;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed = true;

    /**
     *
     * @param sensor
     *            - Keyboard Sensor.
     * @param key
     *            - the key pressed(string).
     * @param animation
     *            - the animation to run.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key,
            Animation animation) {
        this.keyboard = sensor;
        this.key = key;
        this.animation = animation;
        stop = false;
    }

    /**
     * @param d
     *            - the surface to draw on.
     * @param dt
     *            - to normalize the rate frame.
     */
    public void doOneFrame(DrawSurface d, double dt) {
        this.animation.doOneFrame(d, dt);
        if (this.keyboard.isPressed(this.key)) {
            if (!this.isAlreadyPressed) {
                this.stop = true;
            }
        } else {
            this.isAlreadyPressed = false;
        }
    }

    /**
     * @return - determine whether it should stop or not.
     */
    public boolean shouldStop() {
        return this.stop;
    }

    /**
     * to determine whether it should be shown again.
     */
    public void showAgain() {
        this.stop = false;
    }
}
