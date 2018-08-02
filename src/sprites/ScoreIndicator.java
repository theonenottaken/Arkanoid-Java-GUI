package sprites;

import counting.ScoreTrackingListener;
import animations.GameLevel;
import biuoop.DrawSurface;
/**
 * ScoreIndicator class.
 * This class implements Sprite.
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public class ScoreIndicator implements Sprite {

    private String presentScore;
    private ScoreTrackingListener scoreTracking;
    /**
     * constructor.
     * @param scoreTracking - keeps track on the score counter.
     */
    public ScoreIndicator(ScoreTrackingListener scoreTracking) {
        this.scoreTracking = scoreTracking;
    }
    /**
     * convert the score into string.
     */
    public void makeString() {
        this.presentScore = scoreTracking.getValue().toString();
    }

    @Override
    public void drawOn(DrawSurface d) {
        makeString();
        d.drawText(300, 15, "Score: " + this.presentScore, 15);
    }

    @Override
    public void timePassed(double dt) {
    }
    /**
     *
     * @param g - add it to the current game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
