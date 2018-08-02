package levels;

import java.awt.Color;
import java.util.List;

import collisions.Velocity;
import shapes.Point;
import sprites.ColoredBackground;
import sprites.Block;
/**
 * DirectHitLevel Class.
 *This class extends AllLevels.
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public class DirectHitLevel extends AllLevels {
    /**
     * constructor.
     */
    public DirectHitLevel() {
        super();
        super.setNumBalls(1);
        super.setPaddle(500, 100);
        super.setName("Direct Hit");
        super.setBackground(new ColoredBackground(1));
        super.setToRemove(1);
        this.makeVelocityList();
        this.makeBlockList();
    }
    /**
     * creating a list of velocities for the balls.
     */
    protected void makeVelocityList() {
        List<Velocity> list = super.initialBallVelocities();
        Velocity v = new Velocity(4, 4);
        list.add(v);
    }
    /**
     * creating a list of blocks.
     */
    protected void makeBlockList() {
        List<Block> list = super.blocks();
        Point upperLeft = new Point(390, 150);
        Block block = new Block(upperLeft, 20, 20, 1);
        block.setBlockColor(Color.RED);
        list.add(block);
    }
}
