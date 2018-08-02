package counting;

import java.io.Serializable;
import java.util.Comparator;

/**
 * ScoreComparator class. This class implements Comparator<ScoreInfo>, Serializable.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */

public class ScoreComparator implements Comparator<ScoreInfo>, Serializable {

    /**
     * a method to make the comparator Serializable.
     */
    private static final long serialVersionUID = 1L;

    @Override
    public int compare(ScoreInfo score1, ScoreInfo score2) {
        return score2.getScore() - score1.getScore();
    }

}
