package collisions;
/**
 * HitNotifier interface.
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public interface HitNotifier {

    //
    /**
     * Add hl as a listener to hit events.
     * @param hl - hit listener object.
     */
    void addHitListener(HitListener hl);
    /**
     * Remove hl from the list of listeners to hit events.
     * @param hl -  hit listener object.
     */
    void removeHitListener(HitListener hl);
}
