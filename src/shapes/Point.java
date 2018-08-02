package shapes;

/**
 * Point Class.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public class Point {
    private double x;
    private double y;

    /**
     * Construct a point given x and y coordinates.
     *
     * @param x
     *            - the x coordinate
     * @param y
     *            - the y coordinate
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return the x coordinate
     */
    public double getX() {
        return this.x;
    }

    /**
     * @return the y coordinate
     */
    public double getY() {
        return this.y;
    }

    /**
     * @param b
     *            a point to measure the distance to
     * @return the distance to the other point
     */
    public double distance(Point b) {
        double dx = this.getX() - b.getX();
        double dy = this.getY() - b.getY();
        return Math.sqrt((dx * dx) + (dy * dy));
    }

    /**
     *
     * @param other
     *            - other point
     * @return - if both points are equal
     */
    public boolean equals(Point other) {
        return (other.getX() == this.x) && (other.getY() == this.y);
    }
}
