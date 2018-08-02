package collisions;

import shapes.Point;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public class Velocity {
    private double dx;
    private double dy;
    private double angle;
    private double speed;

    /**
     *
     * @param dx
     *            - the change in x
     * @param dy
     *            - the change in y
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
        this.angle = 0;
        this.speed = 0;

    }

    /**
     * Take a point with position (x,y) and return a new point. with position
     * (x+dx, y+dy)
     *
     * @param p
     *            - current position
     * @return new position
     */
    public Point applyToPoint(Point p) {
        Point newPoint = new Point((p.getX() + dx), (p.getY() + dy));
        return newPoint;
    }

    /**
     * A function that acts as a constructor.
     *
     * @param angle
     *            -the angle which denotes the initial direction of the Velocity
     * @param speed
     *            - the initial speed in that direction.
     * @return - Velocity with initial angle and speed.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.sin(Math.toRadians(angle));
        double dy = (-1) * speed * Math.cos(Math.toRadians(angle));
        return new Velocity(dx, dy);
    }

    /**
     *
     * @return - dx value.
     */
    public double getDX() {
        return this.dx;
    }

    /**
     *
     * @return - dy value.
     */
    public double getDY() {
        return this.dy;
    }

    /**
     *
     * @return the speed.
     */
    public double getSpeed() {
        this.speed = Math.sqrt((Math.pow(this.getDX(), 2) + Math.pow(
                this.getDY(), 2)));
        return this.speed;
    }

    /**
     *
     * @return the angle.
     */
    public double getAngle() {
        this.angle = Math.atan((this.getDY() / this.getDX()));
        return this.angle;
    }

    /**
     *
     * @param angle1
     *            - sets a new angle.
     */
    public void setAngle(double angle1) {
        this.angle = angle1;
    }

    /**
     *
     * @param speed1
     *            - set a new speed.
     */
    public void setSpeed(double speed1) {
        this.speed = speed1;
    }
}
