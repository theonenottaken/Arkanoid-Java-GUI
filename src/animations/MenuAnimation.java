package animations;

import java.awt.Color;

import java.util.List;
import java.util.ArrayList;
import biuoop.KeyboardSensor;
import biuoop.DrawSurface;

/**
 * NewGameTask Class. This class implements Task.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 * @param <T>
 *            - task.
 */
public class MenuAnimation<T> implements Menu<T> {

    private List<String> selections;
    private List<T> tasks;
    private List<String> names;
    private KeyboardSensor keyboard;
    private boolean stop;
    private T status;
    private String title;
    private AnimationRunner runner;
    private List<Menu<T>> subMenus;
    private String subKey;

    /**
     * constructor.
     *
     * @param title
     *            - the title of the menu.
     * @param keyboard
     *            - keyboard Sensor.
     * @param runner
     *            - to run.
     */
    public MenuAnimation(String title, KeyboardSensor keyboard,
            AnimationRunner runner) {
        this.runner = runner;
        this.title = title;
        this.keyboard = keyboard;
        this.stop = false;
        this.status = null;
        this.tasks = new ArrayList<T>();
        this.names = new ArrayList<String>();
        this.selections = new ArrayList<String>();
        this.subKey = null;
        this.subMenus = new ArrayList<Menu<T>>();
    }

    /**
     * @param d
     *            - surface.
     * @param dt
     *            - the normalized value.
     */
    public void doOneFrame(DrawSurface d, double dt) {
        d.setColor(Color.RED);
        d.drawText(200, 100, this.title, 60);
        d.setColor(Color.BLACK);
        for (int i = 0; i < names.size(); i++) {
            d.drawText(300, 200 + (i * 60), this.names.get(i), 40);
        }
        for (int i = 0; i < names.size(); i++) {
            if (this.keyboard.isPressed(selections.get(i))) {
                this.status = this.tasks.get(i);
                if (selections.get(i).equals("s")) {
                    d.drawText(400, 400, "Loading...", 15);
                }
                this.stop = true;
            }
        }
    }

    /**
     * @return - if it should stop.
     */
    public boolean shouldStop() {
        return this.stop;
    }

    /**
     * @param key
     *            - key.
     * @param message
     *            - the name of the selection.
     * @param returnVal
     *            - task.
     */
    public void addSelection(String key, String message, T returnVal) {
        this.tasks.add(returnVal);
        this.names.add(message);
        this.selections.add(key);
    }

    /**
     * @return T
     *            - task.
     */
    public T getStatus() {
        return this.status;
    }

    /**
     * shows it again.
     */
    public void showAgain() {
        this.stop = false;
    }

    /**
     * @param key
     *            - key.
     * @param message
     *            - the name of the selection.
     * @param subMenu
     *            - sub menu.
     */
    public void addSubMenu(String key, String message, Menu<T> subMenu) {

        subMenu.setKey(key);
        this.subMenus.add(subMenu);
    }

    /**
     * @param key
     *            - key.
     * @return submenu that is supposed to appear after pressing key.
     */
    public Menu<T> getSubMenu(String key) {
        for (Menu<T> subMenu : this.subMenus) {
            if (subMenu.getKey().equals(key)) {
                return subMenu;
            }
        }
        return null;
    }

    /**
     * @param key
     *            - key.
     */
    public void setKey(String key) {
        this.subKey = key;
    }

    /**
     * @return the key.
     */
    public String getKey() {
        return this.subKey;
    }

}
