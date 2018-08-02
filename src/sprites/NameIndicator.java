package sprites;

import java.awt.Color;

import animations.GameLevel;
import biuoop.DrawSurface;
/**
 * NameIndicator class.
 * This class implements Sprite.
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public class NameIndicator implements Sprite {
    private String name;
    /**
     * constructor.
     * @param str - the name of the level.
     */
    public NameIndicator(String str) {
        this.name = str;
    }

    /**
     * draws the name of the level.
     * @param d - current draw surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(450, 15, "Level Name: " + this.name, 15);
    }

    /**
     *
     * @param g - add it the current game level.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    @Override
    public void timePassed(double dt) {
    }


}
