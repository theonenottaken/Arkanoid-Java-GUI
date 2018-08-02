package levels;

import java.util.List;
import java.util.ArrayList;

import collisions.Velocity;
import sprites.Background;
import sprites.ColoredBackground;
import sprites.Block;
import sprites.Sprite;

/**
 * class Level. This class implements LevelInformation.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public class Level implements LevelInformation {
    private int numOfBalls;
    private List<Velocity> initBallVelocities;
    private double paddleSpeed;
    private int paddleWidth;
    private String name;
    private BlocksFromSymbolsFactory blocksDef;
    private int rowHeight;
    private Background background;
    private int numOfBlocksToRemove;
    private List<Block> blocks;
    private int blockStartX;
    private int blockStartY;

    /**
     * constructor.
     */
    public Level() {
        this.initBallVelocities = new ArrayList<Velocity>();
        this.blocks = new ArrayList<Block>();
    }

    /**
     *
     * @param bdef
     *            - sets block factory.
     */
    public void setBlockDef(BlocksFromSymbolsFactory bdef) {
        this.blocksDef = bdef;
    }

    /**
     *
     * @param height
     *            - sets row's height.
     */
    public void setRowHeight(int height) {
        this.rowHeight = height;
    }

    /**
     *
     * @param x
     *            - X coordinate of starting point.
     */
    public void setBlockStartX(int x) {
        this.blockStartX = x;
    }

    /**
     *
     * @param y
     *            - y coordinate of starting point.
     */
    public void setBlockStartY(int y) {
        this.blockStartY = y;
    }

    /**
     *
     * @param num
     *            - sets the num of balls.
     */
    public void setnumOfBalls(int num) {
        this.numOfBalls = num;
    }

    /**
     *
     * @param num
     *            - sets the paddle's speed.
     */
    public void setpaddleWidth(int num) {
        this.paddleWidth = num;
    }

    /**
     *
     * @param background2
     *            - sets the background.
     */
    public void setbackground(Background background2) {
        this.background = background2;
    }

    /**
     *
     * @param num
     *            - sets the number of blocks to be removed.
     */
    public void setnumOfBlocksToRemove(int num) {
        this.numOfBlocksToRemove = num;
    }

    /**
     *
     * @param name2
     *            - sets the name.
     */
    public void setname(String name2) {
        this.name = name2;
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
     *
     * @param v - sets the velocity.
     */
    public void setVelocities(List<Velocity> v) {
        this.initBallVelocities = v;
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
    protected void makeVelocityList() {

    }

    /**
     * creates a list of blocks.
     */
    protected void makeBlockList() {

    }

    /**
     *
     * @param blockLines - the rows of atheth blocks.
     */
    public void createBlocks(List<String> blockLines) {
        int xPos = this.blockStartX;
        int yPos = this.blockStartY;
        for (int i = 0; i < blockLines.size(); i++) {

            char[] row = blockLines.get(i).toCharArray();
            if (row.length == 0) {
                continue;
            }
            if (row.length == 1
                    && blocksDef.isSpaceSymbol(String.valueOf(row[0]))) {
                yPos += this.rowHeight;
            } else {
                for (int j = 0; j < row.length; j++) {
                    if (blocksDef.isBlockSymbol(String.valueOf(row[j]))) {
                        Block b = blocksDef.getBlock(String.valueOf(row[j]),
                                xPos, yPos);
                        blocks.add(b);
                        xPos += b.getCollisionRectangle().getWidth();
                    }
                    if (blocksDef.isSpaceSymbol(String.valueOf(row[j]))) {
                        xPos += (blocksDef
                                .getSpaceWidth(String.valueOf(row[j])));
                    }
                }
            }
            yPos += this.rowHeight;
            xPos = this.blockStartX;
        }
        this.setnumOfBlocksToRemove(this.blocks.size());
    }
}
