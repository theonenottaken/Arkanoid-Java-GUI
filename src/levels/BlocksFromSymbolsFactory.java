package levels;

import java.util.HashMap;
import java.util.Map;

import sprites.Block;

/**
 * BlocksFromSymbolsFactory class.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */

public class BlocksFromSymbolsFactory {

    private Map<String, Integer> spacerWidths;
    private Map<String, BlockCreator> blockCreators;

    /**
     * constructor.
     */
    public BlocksFromSymbolsFactory() {
        this.spacerWidths = new HashMap<String, Integer>();
        this.blockCreators = new HashMap<String, BlockCreator>();
    }

    /**
     *
     * @param s
     *            - symbol.
     * @return - returns true if 's' is a valid space symbol.
     */
    public boolean isSpaceSymbol(String s) {
        return spacerWidths.containsKey(s);
    }

    /**
     *
     * @param s
     *            - symbol.
     * @return - returns true if 's' is a valid block symbol.
     */
    public boolean isBlockSymbol(String s) {
        return blockCreators.containsKey(s);
    }

    /**
     *
     * @param symbol
     *            - a symbol.
     * @param bc
     *            - creates the block.
     */
    void setBlockSymbol(String symbol, BlockCreator bc) {
        this.blockCreators.put(symbol, bc);
    }

    /**
     *
     * @param symbol
     *            - a symbol.
     * @param width
     *            - the width of the space.
     */
    void setSpaceSymbol(String symbol, Integer width) {
        this.spacerWidths.put(symbol, width);
    }


    /**
     *
     * @param s
     *            - symbol.
     * @param xpos
     *            - X starting point.
     * @param ypos
     *            - Y starting point.
     * @return - Return a block according to the definitions associated with
     *         symbol s. The block will be located at position (xpos, ypos).
     */
    public Block getBlock(String s, int xpos, int ypos) {
        BlockCreator b = this.blockCreators.get(s);
        return b.create(xpos, ypos);
    }

    /**
     *
     * @param s
     *            - symbol.
     * @return - Returns the width in pixels associated with the given
     *         spacer-symbol.
     */
    public int getSpaceWidth(String s) {
        return this.spacerWidths.get(s);
    }

}
