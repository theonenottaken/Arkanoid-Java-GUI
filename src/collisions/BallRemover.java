package collisions;

import counting.Counter;
import sprites.Ball;
import sprites.Block;
import animations.GameLevel;

/**
 * BallRemover Class.
 * this class implements HitListener.
 * @author Mor Barak and Caleb shere
 * ID numbers: 2493276919 and 302620638
 *
 */

public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter removedBalls;
    /**
     * Constructor.
     * @param game - current game level.
     * @param removedBalls - the number of balls that were remvoed.
     */
    public BallRemover(GameLevel game, Counter removedBalls) {
        this.game = game;
        this.removedBalls = removedBalls;
    }

    /**
     * hit event.
     * @param beingHit - the block that as being hit by the ball.
     * @param hitter - the hitting ball
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        if (hitter.getCenter().getY() <= (600 - hitter.getSize())) {
            removedBalls.increase(1);
            game.removeSprite(hitter);
            hitter.removeFromGame(game);
        }
    }
}
