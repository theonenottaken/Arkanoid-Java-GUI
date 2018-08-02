package levels;

import java.util.List;
import java.util.ArrayList;

import collisions.Velocity;
import sprites.ColoredBackground;
import sprites.Block;
import sprites.Sprite;

/**
 * abstract class AllLevels. This class implements LevelInformation.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public abstract class AllLevels implements LevelInformation {
    private int numOfBalls;
    private List<Velocity> initBallVelocities;
    private double paddleSpeed;
    private int paddleWidth;
    private String name;
    private ColoredBackground background;
    private int numOfBlocksToRemove;
    private List<Block> blocks;

    /**
     * constructor.
     */
    public AllLevels() {
        this.initBallVelocities = new ArrayList<Velocity>();
        this.blocks = new ArrayList<Block>();
    }

    /**
     *
     * @param num
     *            - new number of balls.
     */
    protected void setNumBalls(int num) {
        this.numOfBalls = num;
    }

    /**
     *
     * @param speed
     *            - new speed for paddle.
     * @param width
     *            - new width for ths paddle.
     */
    protected void setPaddle(double speed, int width) {
        this.paddleSpeed = speed;
        this.paddleWidth = width;
    }

    /**
     *
     * @param n
     *            - set the name.
     */
    protected void setName(String n) {
        this.name = n;
    }

    /**
     *
     * @param back
     *            - set the background.
     */
    protected void setBackground(ColoredBackground back) {
        this.background = back;
    }

    /**
     *
     * @param num
     *            - the number of blocks removed.
     */
    protected void setToRemove(int num) {
        this.numOfBlocksToRemove = num;
    }

    /**
     * @return the number of balls.
     */
    public int numberOfBalls() {
        return this.numOfBalls;
    }

    /**
     * @return list of velocities of the balls.
     */
    public List<Velocity> initialBallVelocities() {
        return this.initBallVelocities;
    }

    /**
     * @return the paddle's speed.
     */
    public double paddleSpeed() {
        return this.paddleSpeed;
    }

    /**
     *
     * @param speed
     *            - sets a new speed for the paddle.
     */
    public void setPaddleSpeed(double speed) {
        this.paddleSpeed = speed;
    }

    /**
     * @return the paddle's width.
     */
    public int paddleWidth() {
        return this.paddleWidth;
    }

    /**
     * @return the level's name.
     */
    public String levelName() {
        return this.name;
    }

    /**
     * @return the background.
     */
    public Sprite getBackground() {
        return this.background;
    }

    /**
     * @return a list of blocks in the level.
     */
    public List<Block> blocks() {
        return this.blocks;
    }

    /**
     * @return the number of blocks being removed.
     */
    public int numberOfBlocksToRemove() {
        return this.numOfBlocksToRemove;
    }

    /**
     * creates a velocities list for the balls.
     */
    protected abstract void makeVelocityList();

    /**
     * creates a list of blocks.
     */
    protected abstract void makeBlockList();
}
