package levels;

import biuoop.DrawSurface;
import sprites.Block;

/**
 * BlockFiller interface.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public interface BlockFiller {

    /**
     *
     * @param d
     *            - the surface to draw on.
     * @param b
     *            - the block that need to be filled.
     */
    void fillBlock(DrawSurface d, Block b);

}
