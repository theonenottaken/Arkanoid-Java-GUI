package gameplay;

import java.util.List;
import java.util.ArrayList;

import collisions.Collidable;
import collisions.CollisionInfo;
import shapes.Line;
import shapes.Point;

/**
 * GameEnvironment Class.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public class GameEnvironment {
    private List<Collidable> objects;

    /**
     * Constructor. This class is based on a list of collidable objects.
     */
    public GameEnvironment() {
        this.objects = new ArrayList<Collidable>();
    }

    /**
     * This function add a collidable object to the list of collidable objects.
     *
     * @param c
     *            - a collidable object
     */
    public void addCollidable(Collidable c) {
        objects.add(c);
    }

    /**
     * This function removes a collidable object from the list of collidable
     * objects.
     *
     * @param c
     *            - collidable object.
     */
    public void removeCollidable(Collidable c) {
        objects.remove(c);
    }

    /**
     *
     * @param trajectory
     *            - the line that represent the trajectory of the ball.
     * @return - information about the closest collision0
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        List<Collidable> collidables = new ArrayList<Collidable>(this.objects);
        if (!collidables.isEmpty()) {
            Collidable foundObject = collidables.get(0);
            Point closest = trajectory
                    .closestIntersectionToStartOfLine(foundObject
                            .getCollisionRectangle());
            for (int i = 1; i < collidables.size(); i++) {
                Collidable object = collidables.get(i);
                Point nextPoint = trajectory
                        .closestIntersectionToStartOfLine(object
                                .getCollisionRectangle());
                if (nextPoint != null) {
                    if (closest == null
                            || trajectory.start().distance(nextPoint) < trajectory
                                    .start().distance(closest)) {
                        closest = nextPoint;
                        foundObject = object;
                    }
                }
            }
            if (closest == null) {
                return null;
            } else {
                return new CollisionInfo(closest, foundObject);
            }
        }
        return null;
    }

    /**
     *
     * @return - the collidable objects list.
     */
    public List<Collidable> getList() {
        return objects;
    }
}
