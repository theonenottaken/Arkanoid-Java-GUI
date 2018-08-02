package sprites;

import counting.Counter;
import animations.GameLevel;
import biuoop.DrawSurface;
/**
 * LivesIndicator class.
 * This class implements Sprite.
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public class LivesIndicator implements Sprite {
    private Counter currLives;
    private String presentLives;
    /**
     * constructor.
     * @param currLives - current number of lives remain.
     */
    public LivesIndicator(Counter currLives) {
        this.currLives = currLives;
    }

    /**
     * convert the number of lives into string.
     */
    public void makeString() {
        this.presentLives = new Integer(currLives.getValue()).toString();
    }

    @Override
    public void drawOn(DrawSurface d) {
        makeString();
        d.drawText(150, 15, "Lives: " + this.presentLives, 15);
    }
    /**
     *
     * @param g - add to current game level.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    @Override
    public void timePassed(double dt) {
    }
}
