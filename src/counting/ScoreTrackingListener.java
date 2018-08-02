package counting;

import collisions.HitListener;
import sprites.Ball;
import sprites.Block;

/**
 * ScoreTrackingListener class.
 * This class implements HitListener.
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * constructor.
     * @param scoreCounter - counts the score points.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
       this.currentScore = scoreCounter;
    }

    /**
     * @param beingHit - the block that was being hit.
     * @param hitter - the hitting ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
       if (beingHit.getHitPoints() == 1) {
           this.currentScore.increase(5);
       } else if (beingHit.getHitPoints() == 0) {
           this.currentScore.increase(10);
       }
    }
    /**
     *
     * @return - get the value of the current score.
     */
    public Integer getValue() {
        return this.currentScore.getValue();
    }
 }
