package collisions;

import sprites.Ball;
import sprites.Block;

/**
 * HitListener interface.
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public interface HitListener {

    //
    /**
     * This method is called whenever the beingHit object is hit.
     *  The hitter parameter is the Ball that's doing the hitting.
     * @param beingHit - the block that was being hit.
     * @param hitter - the hitting ball.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
