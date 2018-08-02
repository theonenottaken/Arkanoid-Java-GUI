package gameplay;


import animations.AnimationRunner;
import animations.HighScoresAnimation;
import animations.KeyPressStoppableAnimation;
import animations.Task;
import counting.HighScoresTable;

/**
 * ShowHiScoresTask Class. This class implements Task.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public class ShowHiScoresTask implements Task<HighScoresTable> {

    private AnimationRunner runner;
    private KeyPressStoppableAnimation high;

    /**
     * constructor.
     *
     * @param runner
     *            - to run the high scores animation.
     * @param highScoresAnimation
     *            - an high scores animation.
     */
    public ShowHiScoresTask(AnimationRunner runner,
            HighScoresAnimation highScoresAnimation) {
        this.runner = runner;
        this.high = new KeyPressStoppableAnimation(this.runner.getKeyboard(),
                "e", highScoresAnimation);
    }

    /**
     * @return an high scores table.
     */
    public HighScoresTable run() {
        this.runner.run(this.high);
        this.high.showAgain();
        return null;
    }
}