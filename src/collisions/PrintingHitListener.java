package collisions;

import sprites.Ball;
import sprites.Block;

/**
 * PrintingHitListener Class.
 *  This class implements HitListener.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public class PrintingHitListener implements HitListener {
    /**
     * @param beingHit - the block that was being hit.
     * @param hitter - the hitting ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
       System.out.println("A Block with " + beingHit.getHitPoints() + " points was hit.");
    }
 }
