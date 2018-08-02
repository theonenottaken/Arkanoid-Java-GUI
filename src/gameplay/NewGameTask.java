package gameplay;

import java.util.List;
import levels.LevelInformation;
import animations.Task;
import counting.HighScoresTable;

/**
 * NewGameTask Class. This class implements Task.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */

public class NewGameTask implements Task<HighScoresTable> {
    private GameFlow game;
    private List<LevelInformation> levels;

    /**
     *
     * @param game
     *            - current game.
     * @param levels
     *            - list of levels to be run.
     */
    public NewGameTask(GameFlow game, List<LevelInformation> levels) {
        this.game = game;
        this.levels = levels;
    }

    @Override
    public HighScoresTable run() {
        return this.game.runLevels(levels);
    }
}
