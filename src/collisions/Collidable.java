package collisions;

import shapes.Point;
import shapes.Rectangle;
import sprites.Ball;

/**
 * Collidable interface.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public interface Collidable {
    /**
     *
     * @return -the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with a given
     * velocity.
     *
     * @param collisionPoint
     *            - The collision point.
     * @param currentVelocity
     *            - the current velocity of the colliding object.
     * @param hitter - the hitting ball.
     * @return -the new velocity expected after the hit (based on the force the
     *         object inflicted on us).
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
