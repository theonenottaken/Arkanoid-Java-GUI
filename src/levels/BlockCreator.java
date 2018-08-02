package levels;

import sprites.Block;

/**
 * BlockCreator interface.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public interface BlockCreator {

    /**
     * creates the block.
     *
     * @param xpos
     *            - the starting X coordinate.
     * @param ypos
     *            - the starting Y coordinate.
     * @return - a new block.
     */
    Block create(int xpos, int ypos);
}
