package collisions;

import counting.Counter;
import sprites.Ball;
import sprites.Block;
import animations.GameLevel;

/**
 * BlockRemover Class.
 * this class implements HitListener.
 * @author Mor Barak and Caleb shere
 * ID numbers: 2493276919 and 302620638
 *
 */
public class BlockRemover implements HitListener {

    private GameLevel game;
    private Counter removedBlocks;

    /**
     * BlockRemover.
     * @param game - current game level.
     * @param removedBlocks - the number of the rmvoed blocks.
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.removedBlocks = removedBlocks;
    }

    //.
    /**
     *  Blocks that are hit and reach 0 hit-points should be removed.
     *  from the game
     *  @param beingHit - the block that was being hit.
     *  @param hitter - the hitting ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        if (beingHit.getHitPoints() == 0) {
            game.removeCollidable(beingHit);
            game.removeSprite(beingHit);
            removedBlocks.increase(1);
            beingHit.removeHitListener(this);
        }
    }
}
