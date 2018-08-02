package collisions;

import shapes.Point;

/**
 * CollisionInfo Class.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public class CollisionInfo {
    private Point point;
    private Collidable object;

    /**
     * Constructor.
     *
     * @param collisionPoint
     *            - initialization
     * @param collisionObject
     *            - initialization
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.point = collisionPoint;
        this.object = collisionObject;
    }

    /**
     *
     * @return - the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return this.point;
    }

    /**
     *
     * @return - the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.object;
    }

}
