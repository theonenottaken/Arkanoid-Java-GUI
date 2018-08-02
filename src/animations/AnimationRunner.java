package animations;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import biuoop.KeyboardSensor;

/**
 * AnimationRunner class.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public class AnimationRunner {

    private GUI gui;
    private int frameRate;
    private Sleeper sleeper;
    private KeyboardSensor keyboard;

    /**
     * second constructor.
     *
     * @param framesPerSec
     *            - the numbers of frames per second.
     */
    public AnimationRunner(int framesPerSec) {
        this.frameRate = framesPerSec;
        this.gui = new GUI("Arkanoid", 800, 600);
        this.sleeper = new Sleeper();
        this.keyboard = gui.getKeyboardSensor();
    }

    /**
     *
     * @param animation
     *            - runs this current animation.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / frameRate;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d, (1 / frameRate));

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

    /**
     *
     * @return the current gui.
     */
    public GUI getGUI() {
        return this.gui;
    }

    /**
     * @return - the keyboard.
     */
    public KeyboardSensor getKeyboard() {
        return this.keyboard;
    }

    /**
     *
     * @return the dt valoe.
     */
    public double getDt() {
        return ((double) 1 / frameRate);
    }
}
