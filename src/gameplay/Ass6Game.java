package gameplay;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

import counting.HighScoresTable;
import animations.HighScoresAnimation;
import animations.AnimationRunner;
import animations.Menu;
import animations.MenuAnimation;
import animations.Task;
import biuoop.KeyboardSensor;

/**
 * Ass5Game Class. the main class.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public class Ass6Game {

    /**
     * main function.
     *
     * @param args
     *            - input arguments, level numbers.
     */
    public static void main(String[] args) {
        HighScoresTable his = new HighScoresTable(10);
        File highscores = new File("highscores");
       /** LevelInformation[] levelIndices = new LevelInformation[4];
        levelIndices[0] = new DirectHitLevel();
        levelIndices[1] = new WideEasyLevel();
        levelIndices[2] = new Green3Level();
        levelIndices[3] = new FinalFourLevel();
        List<Integer> arguments = stringsToInts(args);*/

        AnimationRunner runner = new AnimationRunner(60);
        KeyboardSensor k = runner.getKeyboard();
        if (highscores.exists()) {
            his = HighScoresTable.loadFromFile(highscores);
        }
        LevelSetsReader lsr = new LevelSetsReader(k, runner, his);
        Menu<Task<HighScoresTable>> subMenu = null;
        if (args.length == 0) {
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("level_sets.txt");
			subMenu = lsr.fromReader(new InputStreamReader(is));
        } else {
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(args[0]);
			subMenu = lsr.fromReader(new InputStreamReader(is));
        }
        HighScoresAnimation scores = new HighScoresAnimation(his, "e", k,
                highscores);
        Menu<Task<HighScoresTable>> menu = new MenuAnimation<Task<HighScoresTable>>(
                "Arkanoid", k, runner);
        menu.addSelection("h", "(h) High scores", new ShowHiScoresTask(runner,
                scores));
        menu.addSubMenu("s", "(s) Play", subMenu);
        menu.addSelection("s", "(s) Play", new MenuTask<HighScoresTable>(menu.getSubMenu("s"), runner));
        menu.addSelection("q", "(q) Quit", new QuitTask());
        // HighScoresTable updatedScores;
        while (true) {
            menu.showAgain();
            runner.run(menu);
            // wait for user selection
            Task<HighScoresTable> task = menu.getStatus();
            his = task.run();
            if (his != null) {
                scores.setTable(his);
            }
            /**
             * try { his.save(highscores); } catch (IOException e) { // TODO
             * Auto-generated catch block e.printStackTrace(); }
             */
        }
    }
}
