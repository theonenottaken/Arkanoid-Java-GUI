package levels;


import biuoop.DrawSurface;

import java.awt.Image;

import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import sprites.Block;

/**
 * ImageFill class. implements BlockFiller.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public class ImageFill implements BlockFiller {

    private Image image;

    /**
     * constructor.
     */
    public ImageFill() {
        this.image = null;
    }

    /**
     *
     * @param path
     *            - location of image.
     */
    public ImageFill(String path) {
        this.loadImage(path);
    }

    /**
     *
     * @param filename
     *            - name of image.
     */
    public void loadImage(String filename) {
        try {
        	InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(filename);
        	this.image = ImageIO.read(is);
            //this.image = ImageIO.read(newFile(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param d
     *            - surface.
     * @param b
     *            - block.
     */
    public void fillBlock(DrawSurface d, Block b) {
        int x = (int) b.getCollisionRectangle().getUpperLeft().getX();
        int y = (int) b.getCollisionRectangle().getUpperLeft().getY();
        d.drawImage(x, y, this.image);
    }

}
