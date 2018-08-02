package animations;

/**
 * Task interface.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 * @param <T> - the task to run.
 *
 */

public interface Task<T> {

    /**
     *
     * @return - run the task.
     */
    T run();

}
