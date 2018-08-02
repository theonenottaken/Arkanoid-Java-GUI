package gameplay;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.List;

import biuoop.KeyboardSensor;
import animations.AnimationRunner;
import animations.Menu;
import animations.MenuAnimation;
import animations.Task;
import levels.BlocksDefinitionReader;
import levels.LevelInformation;
import counting.HighScoresTable;

/**
 * LevelSetsReader Class.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public class LevelSetsReader {

    private KeyboardSensor keyboard;
    private AnimationRunner runner;
    private HighScoresTable hst;

    /**
     * constructor.
     *
     * @param k
     *            - Keyboard Sensor.
     * @param a
     *            - an animation ruuner.
     * @param h
     *            - high scores table. all those parameters are required for the
     *            game flow constructor.
     */
    public LevelSetsReader(KeyboardSensor k, AnimationRunner a,
            HighScoresTable h) {
        this.keyboard = k;
        this.runner = a;
        this.hst = h;
    }

    /**
     *
     * @param reader
     *            - an i.o redaer.
     * @return - a menu.
     */
    public Menu<Task<HighScoresTable>> fromReader(java.io.Reader reader) {
        LineNumberReader lnr = new LineNumberReader(new BufferedReader(reader));
        String row = null;
        // int line = 1;
        String key = null;
        String name = null;
        LevelSpecificationReader lsr;
        List<LevelInformation> li;
        Menu<Task<HighScoresTable>> subMenu = new MenuAnimation<Task<HighScoresTable>>(
                "Choose Difficulty", this.keyboard, this.runner);
        GameFlow game = new GameFlow(this.runner, this.keyboard, this.hst);

        try {

            while ((row = lnr.readLine()) != null) {
                // row = lnr.readLine();
                if (lnr.getLineNumber() % 2 == 1) {
                    String[] levels = row.split(":");
                    key = levels[0];
                    name = levels[1];
                    // row = lnr.readLine();
                } else if (lnr.getLineNumber() % 2 == 0) {

                    lsr = new LevelSpecificationReader();
                	InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(row);
                    li = lsr.fromReader(new InputStreamReader(is));
                    subMenu.addSelection(key, "(" + key + ")" + " Play " + name, 
                    					 new NewGameTask(game, li));
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            reader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return subMenu;
    }
}
