package levels;

import java.util.List;
import java.awt.Color;

import collisions.Velocity;
import shapes.Point;
import sprites.ColoredBackground;
import sprites.Block;
/**
 * Green3Level Class.
 *This class extends AllLevels.
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public class Green3Level extends AllLevels {
    /**
     * constructor.
     */
    public Green3Level() {
        super();
        super.setNumBalls(2);
        super.setPaddle(700, 85);
        super.setName("Green 3");
        super.setBackground(new ColoredBackground(3));
        super.setToRemove(40);
        this.makeVelocityList();
        this.makeBlockList();
    }
    /**
     * creating a list of velocities for the balls.
     */
    protected void makeVelocityList() {
        List<Velocity> list = super.initialBallVelocities();
        for (int i = 1; i <= 2; i++) {
            Velocity v = new Velocity(5, 5);
            list.add(v);
        }
    }
    /**
     * creating a list of blocks.
     */
    protected void makeBlockList() {
        List<Block> list = super.blocks();
        Color[] colors = new Color[5];
        colors[0] = Color.GRAY;
        colors[1] = Color.RED;
        colors[2] = Color.YELLOW;
        colors[3] = Color.BLUE;
        colors[4] = Color.WHITE;
        int numBlocks = 10;
        int numHits = 2;
        int x = 738;
        int y = 100;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < numBlocks; j++) {
                Point loc = new Point(x, y);
                Block block = new Block(loc, 52, 20, numHits);
                block.setBlockColor(colors[i]);
                list.add(block);
                x -= 52;
            }
            numBlocks--;
            y += 20;
            x = 738;
            if (i == 0) {
                numHits--;
            }
        }
    }

}
