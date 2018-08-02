package levels;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import shapes.Point;
import shapes.Rectangle;
import sprites.Block;

/**
 * BlockProperties class. This class implements BlockCreator.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */

public class BlockProperties implements BlockCreator {
    private Integer width;
    private Integer height;
    private Integer hitPoints;
    private Color stroke;
    private String symbol;
    private int numOfFields;
    private int minNumOfFields;
    private Map<Integer, BlockFiller> fillers;

    /**
     * constructor.
     */
    BlockProperties() {
        this.setHeight(null);
        this.setSymbol(null);
        this.setHitPoints(null);
        this.setMinNumOfFields(4);
        this.setWidth(null);
        this.setStroke(null);

        this.fillers = new HashMap<Integer, BlockFiller>();
    }

    /**
     *
     * @param w
     *            - width of the block.
     */
    public void setWidth(Integer w) {
        this.width = w;
        this.numOfFields++;
    }

    /**
     *
     * @param h
     *            - the height of the block.
     */
    public void setHeight(Integer h) {
        this.height = h;
        this.numOfFields++;
    }

    /**
     *
     * @param s
     *            - the symbol of the block.
     */
    public void setSymbol(String s) {
        this.symbol = s;
        this.numOfFields++;
    }

    /**
     *
     * @param s
     *            - color.
     */
    public void setStroke(Color s) {
        this.stroke = s;
    }

    /**
     *
     * @param hp
     *            - the number of the hit points of the block.
     */
    public void setHitPoints(Integer hp) {
        this.hitPoints = hp;
        this.numOfFields++;
    }

    /**
     *
     * @param num
     *            - the minimum number of fields required for the block.
     */
    public void setMinNumOfFields(int num) {
        this.minNumOfFields = num;
    }

    /**
     *
     * @return - the current number of fields.
     */
    public int getNumOfFields() {
        return this.numOfFields;
    }

    /**
     *
     * @return - the minimum number of fields required for the block.
     */
    public int getMinNumOfFields() {
        return this.minNumOfFields;
    }

    /**
     *
     * @return the width of the block.
     */
    public Integer getWidth() {
        return this.width;
    }

    /**
     *
     * @return - the height of the block.
     */
    public Integer getHeight() {
        return this.height;
    }

    /**
     *
     * @return - the symbol that represent the block.
     */
    public String getSymbol() {
        return this.symbol;
    }

    /**
     *
     * @return - the color.
     */
    public Color getStroke() {
        return this.stroke;
    }

    /**
     *
     * @return - the number of the hit points of the block.
     */
    public Integer getHitPoints() {
        return this.hitPoints;
    }

    /**
     *
     * @return a map of block fillers.
     */

    public Map<Integer, BlockFiller> getFill() {
        return fillers;
    }

    /**
     *
     * @param i
     *            - to the map.
     * @param filler
     *            - adds the curr filler to the map.
     */
    public void addFill(Integer i, BlockFiller filler) {
        this.fillers.put(i, filler);
    }

    /**
     *
     * @param fill1
     *            - set a new fillers.
     */
    public void setFill(Map<Integer, BlockFiller> fill1) {
        this.fillers = fill1;
    }

    /**
     *
     * @return if the block has the minimum fields required for construction.
     */

    public boolean validBlock() {
        return (this.numOfFields == this.getMinNumOfFields());
    }

    /**
     *
     * @param properties
     *            - an array of strings that represent the properties of the
     *            current block.
     * @return - the block's properties.
     */
    public BlockProperties readProperties(String[] properties) {

        for (int i = 0; i < properties.length; i++) {

            String[] property = properties[i].split(":");
            if (property[0].equals("symbol")) {
                this.setSymbol(new String(property[1]));
            } else if (property[0].equals("height")) {
                this.setHeight(Integer.decode(property[1]));
            } else if (property[0].equals("width")) {
                this.setWidth(Integer.decode(property[1]));
            } else if (property[0].equals("hit_points")) {
                this.setHitPoints(Integer.decode(property[1]));
            } else if (property[0].equals("stroke")) {

                this.setStroke(ColorsParser.colorFromString((property[1])));
            } else if (property[0].matches("fill.*")) {
                int index = 0;
                if (property[0].matches("fill-[1-9]*")) {
                    String[] fillIndex = property[0].split("-");
                    index = Integer.decode(fillIndex[1]);
                } else {
                    index = 1;
                }
                Color c = ColorsParser.colorFromString(property[1]);
                if (c == null) {
                    this.addFill(
                            index,
                            new ImageFill(property[1].substring(6,
                                    property[1].length() - 1)));
                } else {
                    this.addFill(index, new BlocksColorFill(c));
                }
            }
        }
        return this;
    }

    /**
     * @param xpos
     *            - the x coordinate of the block.
     * @param ypos
     *            - the y coordinate of the block.
     * @return - the block with his new properties.
     */
    public Block create(int xpos, int ypos) {
        Rectangle rect = new Rectangle(new Point((double) xpos, (double) ypos),
                this.getWidth().doubleValue(), this.getHeight().doubleValue());
        return new Block(rect, this.getHitPoints().intValue(),
                this.getStroke(), this.fillers);

    }

    /**
     *
     * @param other
     *            - merges between two block properties.
     */
    public void merge(BlockProperties other) {
        this.height = other.height == null ? this.height : other.height;
        this.width = other.width == null ? this.width : other.width;
        this.symbol = other.symbol == null ? this.symbol : other.symbol;
        this.hitPoints = other.hitPoints == null ? this.hitPoints
                : other.hitPoints;
        this.stroke = other.stroke == null ? this.stroke : other.stroke;
        this.fillers = other.fillers == null ? this.fillers : other.fillers;
    }
}
