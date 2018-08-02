package animations;

import java.awt.Color;

import java.io.File;
import java.util.List;
import sprites.ColoredBackground;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import counting.HighScoresTable;
import counting.ScoreInfo;

/**
 * HighScoresAnimation class. This class implements Animation.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */

public class HighScoresAnimation implements Animation {

    private HighScoresTable his;
    // private KeyboardSensor keyboard;
    private File filename;
    private ColoredBackground backGround;

    /**
     *
     * @param scores
     *            - HighScoresTable to present.
     * @param endKey
     *            - the key pressed when the user wants to exit the screen.
     * @param keyboard
     *            - keyboard sensor.
     * @param filename
     *            - the name of the file that contains the HighScoresTable.
     */
    public HighScoresAnimation(HighScoresTable scores, String endKey,
            KeyboardSensor keyboard, File filename) {

        this.his = scores;
        this.filename = filename;
        this.backGround = new ColoredBackground(1);
    }

    // ...

    @Override
    public void doOneFrame(DrawSurface d, double dt) {

        this.backGround.drawBackground(d);
        List<ScoreInfo> scoresList = his.getHighScores();
        d.setColor(Color.RED);
        d.drawText(150, 60, "High scores table: ", 60);
        d.setColor(Color.BLUE);
        d.drawText(250, 105, "Name:", 32);
        d.drawText(480, 105, "Score:", 32);
        d.drawText(20, 570, "Press 'e' to exit this screen", 15);
        d.setColor(Color.GREEN);
        int counting = 0;
        for (ScoreInfo score : scoresList) {
            counting = counting + 26;
            d.drawText(250, 120 + counting, score.getName(), 25);
            d.drawText(480, 120 + counting, String.valueOf(score.getScore()),
                    25);
        }
    }

    @Override
    public boolean shouldStop() {
        return false;
    }

    /**
     *
     * @param newHis
     *            - a new high score table.
     */
    public void setTable(HighScoresTable newHis) {
        this.his = newHis;
    }
}
