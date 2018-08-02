package animations;

import biuoop.DrawSurface;
/**
 * Animation interface.
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public interface Animation {
    /**
     * in charge of the game logic.
     * @param d - draw surface
     * @param dt - the normalized value for the frame rate.
     */
    void doOneFrame(DrawSurface d, double dt);
    /**
     *
     * @return either it should stop.
     */
    boolean shouldStop();

}
