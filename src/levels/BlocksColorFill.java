package levels;

import java.awt.Color;

import sprites.Block;
import biuoop.DrawSurface;

/**
 * BlocksColorFill class. This class implements BlockFiller.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public class BlocksColorFill implements BlockFiller {

    private Color color;

    /**
     * constructor.
     *
     * @param color
     *            - the block's color.
     */
    public BlocksColorFill(Color color) {
        this.color = color;
    }

    @Override
    public void fillBlock(DrawSurface d, Block b) {
        d.setColor(this.color);
        d.fillRectangle((int) b.getCollisionRectangle().getUpperLeft().getX(),
                (int) b.getCollisionRectangle().getUpperLeft().getY(), (int) b
                        .getCollisionRectangle().getWidth(), (int) b
                        .getCollisionRectangle().getHeight());
    }

}
