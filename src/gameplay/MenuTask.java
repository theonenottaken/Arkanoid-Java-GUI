package gameplay;

import counting.HighScoresTable;
import animations.AnimationRunner;
import animations.Menu;
import animations.Task;

/**
 * MenuTask<T> Class. This class implements Task.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 * @param <T>
 *            - a task to run.
 */
public class MenuTask<T> implements Task<HighScoresTable> {

    private Menu<Task<HighScoresTable>> menu;
    private AnimationRunner runner;

    /**
     * constructor.
     *
     * @param menu
     *            - a menu animation.
     * @param runner
     *            - to run the animation.
     */
    public MenuTask(Menu<Task<HighScoresTable>> menu, AnimationRunner runner) {
        this.menu = menu;
        this.runner = runner;
    }

    /**
     * @return - an high score table.
     */
    public HighScoresTable run() {
        this.runner.run(this.menu);
        Task<HighScoresTable> task = menu.getStatus();
        HighScoresTable hst = task.run();
        menu.showAgain();
        return hst;
    }

}
