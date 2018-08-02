package gameplay;

import animations.Task;
import counting.HighScoresTable;

/**
 * QuitTask Class. This class implements Task.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */

public class QuitTask implements Task<HighScoresTable> {

    @Override
    public HighScoresTable run() {
        System.exit(1);
        return null;
    }
}
