package sprites;

import java.awt.Image;



import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import animations.GameLevel;
import biuoop.DrawSurface;

/**
 * ImgBackground Class. this class implements Background.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public class ImgBackground implements Background {
    private Image img;

    /**
     *
     * @param path
     *            - image path.
     */
    public ImgBackground(String path) {
        try {
        	InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(path);
        	this.img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.drawImage(0, 0, img);

    }

    @Override
    public void timePassed(double dt) {
        // TODO Auto-generated method stub

    }

    /**
     *
     * @param g
     *            - level game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);

    }

}
