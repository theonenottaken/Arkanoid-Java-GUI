package levels;

import java.util.List;
import java.awt.Color;

import collisions.Velocity;
import shapes.Point;
import sprites.ColoredBackground;
import sprites.Block;
/**
 * FinalFourLevel Class.
 *This class extends AllLevels.
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public class FinalFourLevel extends AllLevels {
    /**
     * constructor.
     */
    public FinalFourLevel() {
        super();
        super.setNumBalls(3);
        super.setPaddle(900, 65);
        super.setName("Final Four");
        super.setBackground(new ColoredBackground(4));
        super.setToRemove(105);
        this.makeVelocityList();
        this.makeBlockList();

    }
    /**
     * creating a list of velocities for the balls.
     */
    protected void makeVelocityList() {
        List<Velocity> list = super.initialBallVelocities();
        for (int i = 1; i <= 3; i++) {
            Velocity v = new Velocity(7, 7);
            list.add(v);
        }
    }
    /**
     * creating a list of blocks.
     */
    protected void makeBlockList() {
        List<Block> list = super.blocks();
        Color[] colors = new Color[5];
        colors[0] = Color.RED;
        colors[1] = Color.YELLOW;
        colors[2] = Color.GREEN;
        colors[3] = Color.WHITE;
        int x = 10;
        int y = 50;
        int numHits;
        int colorCounter = 0;
        Color blockColor = null;
        for (int i = 0; i < 7; i++) {
            if (i == 0 || i == 3 || i == 6) {
                numHits = 2;
                blockColor = Color.GRAY;
            } else {
                numHits = 1;
                blockColor = colors[colorCounter];
                colorCounter++;
            }
            for (int j = 0; j < 15; j++) {
                Point loc = new Point(x, y);
                Block block = new Block(loc, 52, 20, numHits);
                block.setBlockColor(blockColor);
                list.add(block);
                x += 52;
            }
            y += 20;
            x = 10;
        }
    }
}
