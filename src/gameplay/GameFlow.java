package gameplay;

import animations.AnimationRunner;
import animations.EndScreen;
import animations.GameLevel;
import animations.HighScoresAnimation;
import animations.KeyPressStoppableAnimation;
import biuoop.DialogManager;
import biuoop.KeyboardSensor;

import java.io.File;
import java.io.IOException;
import java.util.List;

import counting.Counter;
import counting.HighScoresTable;
import counting.ScoreInfo;
import levels.LevelInformation;

/**
 * GameFlow class.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public class GameFlow {
    private AnimationRunner runner;
    private KeyboardSensor keyboard;
    private Counter score;
    private Counter lives;
    private HighScoresTable his;
    private ScoreInfo scoreInfo;
    private String name;
    private File highscores = new File("highscores");
    private boolean died;

    /**
     * constructor.
     *
     * @param runner
     *            - an animation runner.
     * @param keyboard
     *            - keyboard's key.
     * @param his
     *            - High Scores Table.
     */
    public GameFlow(AnimationRunner runner, KeyboardSensor keyboard,
            HighScoresTable his) {
        this.keyboard = keyboard;
        this.runner = runner;
        this.score = new Counter();
        this.lives = new Counter(1);
        this.his = his;
        this.name = null;
        this.scoreInfo = null;
        this.died = false;
    }

    /**
     * runs the levels by the list's order.
     *
     * @param levels
     *            - list of levels to run.
     * @return an high scores table.
     */
    public HighScoresTable runLevels(List<LevelInformation> levels) {
        // this.his = HighScoresTable.loadFromFile(highscores);
        // ...
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, this.score, this.lives,
                    this.runner, this.keyboard);

            level.initialize();
            while (level.getBlocksRemoved().getValue() < level.getInfo()
                    .numberOfBlocksToRemove()
                    && level.getLives().getValue() > 0) {
                level.playOneTurn();
            }

            if (level.getLives().getValue() == 0) {

                this.died = true;
                if (his.getRank(this.score.getValue()) < his.size()
                        || his.getHighScores().isEmpty()) {
                    DialogManager dialog = this.runner.getGUI()
                            .getDialogManager();
                    this.name = dialog.showQuestionDialog("Name",
                            "What is your name?", "");
                    this.scoreInfo = new ScoreInfo(this.name,
                            this.score.getValue());
                    his.add(this.scoreInfo);
                    if (his.getHighScores().size() > his.size()) {
                        his.remove(his.getHighScores().get(
                                his.getHighScores().size() - 1));
                    }
                    try {
                        his.save(highscores);
                        // this.his = HighScoresTable.loadFromFile(highscores);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                // runner.run(new KeyPressStoppableAnimation("space",
                // screen , keyboard));
                this.runner.run(new KeyPressStoppableAnimation(this.keyboard,
                        "e", new HighScoresAnimation(this.his, "e",
                                this.keyboard, this.highscores)));

                this.runner.run(new KeyPressStoppableAnimation(this.keyboard,
                        KeyboardSensor.SPACE_KEY, new EndScreen(this.keyboard,
                                true, this.score.getValue())));
                // this.runner.getGUI().close();
                break;
            }
        }
        if (!this.died) {
            if (his.getRank(this.score.getValue()) < his.size()
                    || his.getHighScores().isEmpty()) {
                DialogManager dialog = this.runner.getGUI().getDialogManager();
                this.name = dialog.showQuestionDialog("Name",
                        "What is your name?", "");
                this.scoreInfo = new ScoreInfo(this.name, this.score.getValue());
                his.add(this.scoreInfo);
                if (his.getHighScores().size() > his.size()) {
                    his.remove(his.getHighScores().get(
                            his.getHighScores().size() - 1));
                }
                try {
                    this.his.save(highscores);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            runner.run(new KeyPressStoppableAnimation(this.keyboard, "e",
                    new HighScoresAnimation(this.his, "e", this.keyboard,
                            this.highscores)));

            this.runner.run(new KeyPressStoppableAnimation(this.keyboard,
                    KeyboardSensor.SPACE_KEY, new EndScreen(this.keyboard,
                            false, this.score.getValue())));
        }
        this.lives = new Counter(1);
        this.score = new Counter();
        this.died = false;
        // this.runner.getGUI().close();
        return HighScoresTable.loadFromFile(highscores);
    }
}
