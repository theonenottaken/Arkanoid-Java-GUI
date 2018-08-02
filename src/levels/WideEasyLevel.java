package levels;

import java.util.List;
import java.awt.Color;

import collisions.Velocity;
import shapes.Point;
import sprites.ColoredBackground;
import sprites.Block;
/**
 * WideEasyLevel Class.
 *This class extends AllLevels.
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public class WideEasyLevel extends AllLevels {
    /**
     * constructor.
     */
    public WideEasyLevel() {
        super();
        super.setNumBalls(10);
        super.setPaddle(400, 550);
        super.setName("Wide Easy");
        super.setBackground(new ColoredBackground(2));
        super.setToRemove(15);
        this.makeVelocityList();
        this.makeBlockList();
    }
    /**
     * creates a velocity lists for the balls.
     */
    protected void makeVelocityList() {
        List<Velocity> list = super.initialBallVelocities();
        for (int i = 1; i <= 10; i++) {
            Velocity v;
            if (i % 2 == 1) {
                v = new Velocity(8, 8);
            } else {
                v = new Velocity(9, 9);
            }
            list.add(v);
        }
    }
    /**
     * creates a list of blocks.
     */
    protected void makeBlockList() {
        List<Block> list = super.blocks();
        Color[] colors = new Color[7];
        colors[0] = Color.ORANGE;
        colors[1] = Color.RED;
        colors[2] = Color.YELLOW;
        colors[3] = Color.BLUE;
        colors[4] = Color.PINK;
        colors[5] = Color.GREEN;
        colors[6] = Color.CYAN;
        int j = 0; // for color counting
        int x = 10;
        for (int i = 1; i <= 15; i++) {
            Point loc = new Point(x, 200);
            Block block = new Block(loc, 52, 20);
            block.setBlockColor(colors[j]);
            list.add(block);
            if (j == 6) {
                j = 0;
            } else {
                j++;
            }
            x += 52;
        }
    }
}
