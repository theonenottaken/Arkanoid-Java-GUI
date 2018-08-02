package levels;

import java.util.List;

import collisions.Velocity;
import sprites.Block;
import sprites.Sprite;
/**
 * LevelInformation interface.
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public interface LevelInformation {
    /**
     *
     * @return the numbers of balls.
     */
    int numberOfBalls();

    /**
     *
     * @return a list of initialized balls velocity.
     */
    List<Velocity> initialBallVelocities();
    /**
     *
     * @return the paddle's speed.
     */
    double paddleSpeed();
    /**
     *
     * @return the paddle's width.
     */
    int paddleWidth();
    /**
     *
     * @return the level's name.
     */
    String levelName();
    /**
     *
     * @return a sprite with the background of the level.
     */
    Sprite getBackground();
    /**
     *
     * @return The Blocks that make up this level.
     */
    List<Block> blocks();
    /**
     *
     * @return Number of blocks that should be removed before the level is considered to be "cleared".
     */
    int numberOfBlocksToRemove();

}
