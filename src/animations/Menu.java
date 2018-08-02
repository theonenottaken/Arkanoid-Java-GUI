package animations;

/**
 * Menu interface extends Animation.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 * @param <T>
 *            - task.
 */
public interface Menu<T> extends Animation {

    /**
     *
     * @param key
     *            - the key to be pressed.
     * @param message
     *            - massage to be shown.
     * @param returnVal
     *            - the task.
     */
    void addSelection(String key, String message, T returnVal);

    /**
     *
     * @return task.
     */
    T getStatus();

    /**
     *
     * @param key
     *            - the key to be pressed.
     * @param message
     *            - massage to be shown.
     * @param subMenu
     *            - the task.
     */
    void addSubMenu(String key, String message, Menu<T> subMenu);

    /**
     * shows it again.
     */
    void showAgain();

    /**
     *
     * @param key
     *            - sets the key.
     */
    void setKey(String key);

    /**
     *
     * @return the key.
     */
    String getKey();

    /**
     *
     * @param key
     *            key.
     * @return sub menu.
     */
    Menu<T> getSubMenu(String key);
}
