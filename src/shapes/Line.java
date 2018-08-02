package shapes;

import java.util.List;

/**
 * @author Mor Barak and Caleb Shere . ID Numbers: 302620638 and 2-49327691-9
 */
public class Line {
    private Point start;
    private Point end;
    private Point mPoint;
    private double lineLength;

    /**
     *
     *
     * @param upperLeft
     *            - the upper left point.
     *
     * @param lowerLeft
     *            - the lower left point.
     */
    public Line(Point upperLeft, Point lowerLeft) {
        this.start = upperLeft;
        this.end = lowerLeft;
        // Find the midpoint of the line
        this.createMiddle();
    }

    /**
     * Constructs a line that starts at (x1, y1) and ends at (x2, y2).
     *
     * @param x1
     *            - the x coordinate of the start point
     *
     * @param y1
     *            - the y coordinate of the start point
     *
     * @param x2
     *            - the x coordinate of the end point
     *
     * @param y2
     *            - the y coordinate of the end point
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
        // Find the midpoint
        this.createMiddle();
    }

    /**
     *
     * @return - the start point of the line
     */
    public Point start() {
        return this.start;
    }

    /**
     *
     * @return - the end point of the line
     */
    public Point end() {
        return this.end;
    }

    /**
     *
     * @return - the length of the line.
     */
    public double length() {
        lineLength = this.start.distance(end);
        return lineLength;
    }

    /**
     *
     * @return -the middle point of the line.
     */
    public Point middle() {
        return this.mPoint;
    }

    /**
     * createMiddle -- finds the midpoint and assigns it to this.mpoint.
     */
    private void createMiddle() {
        double mx = (end.getX() + start.getX()) / 2;
        double my = (end.getY() + start.getY()) / 2;
        this.mPoint = new Point(mx, my);
    }

    /**
     * @return true if the lines intersect, false otherwise.
     *
     * @param other
     *            - the line that does or does not intersect with this line
     */
    public boolean isIntersecting(Line other) {
        /*
         * Find the line equations for each line in the form ax + by = c. Find
         * a1*b2 - a2*b1.
         */
        double det = calcDet(other);
        if ((det == 0)) {
            // The lines are parallel. They never intersect.
            return false;
        } else {
            // Find the intersection point, assuming the lines are infinite.
            Point interPoint = findIntersection(other);
            // But the lines are not infinite, so make sure the point is on the
            // line
            if ((!pointInLine(other, interPoint))
                    || (!pointInLine(this, interPoint))) {
                return false;
            }
            return true;
        }
    }

    /**
     * @return the intersection point if the lines intersect, and null
     *         otherwise.
     *
     * @param other
     *            - the line that intersects with this one.
     */
    public Point intersectionWith(Line other) {
        if (this.isIntersecting(other)) {
            Point interPoint = findIntersection(other);
            return interPoint;
        }
        return null;
    }

    /**
     * Finds the intersection point of two lines, with the assumption that they
     * do indeed intersect.
     *
     * @param other
     *            - another line.
     * @return - the intersection point.
     */
    public Point findIntersection(Line other) {
        // Stores the a, b, and c constants of the equation of the first line
        double[] firstEquation = findEquation();
        // Stores the constants of the second equation.
        double[] secEquation = other.findEquation();
        // Find a2*b1 - a1*b2
        double det = calcDet(other);
        // Find the x coordinate, using that handy formula.
        double x = (secEquation[1] * firstEquation[2] - firstEquation[1]
                * secEquation[2])
                / det;
        // Find the y coordinate.
        double y = (firstEquation[0] * secEquation[2] - secEquation[0]
                * firstEquation[2])
                / det;
        return new Point(x, y);
    }

    /**
     *
     * @return -the equation of the line
     */
    private double[] findEquation() {
        // Array to store the three constants a, b, and c.
        double[] equation = new double[3];
        // A = y2 - y1
        equation[0] = this.end.getY() - this.start.getY();
        // B = x1 - x2
        equation[1] = this.start.getX() - this.end.getX();
        // C = A*x1 + B*y1
        equation[2] = (equation[0] * this.start.getX())
                + (equation[1] * this.start.getY());
        return equation;
    }

    /**
     *
     * @param other
     *            - an other line.
     * @return - the det of 2 lines.
     */
    private double calcDet(Line other) {
        double[] firstEquation = findEquation();
        double[] secEquation = other.findEquation();
        // det = a1*b2 - a2*b1
        double det = (firstEquation[0] * secEquation[1])
                - (secEquation[0] * firstEquation[1]);
        return det;
    }

    /**
     *
     * @param other
     *            - an other line
     * @return - return true if the lines are equal, false otherwise
     */
    public boolean equals(Line other) {
        if (this.start.equals(other.start) && this.end.equals(other.end)) {
            return true;
        }
        /**
         * As long as the line is the same, it doesn't matter which side is the
         * start and which side is the end.
         */
        if (this.start.equals(other.end) && this.end.equals(other.start)) {
            return true;
        }
        return false;
    }

    /**
     * Find if the point is in the line.
     *
     * @param line
     *            - the line that we are examining.
     *
     * @param collisionPoint
     *            - the point that we are checking to see if it's in the line.
     * @return - if the current point is in the current line.
     */
    public boolean pointInLine(Line line, Point collisionPoint) {
        double minX = line.start.getX();
        double maxX = line.end.getX();
        if (line.start.getX() > line.end.getX()) {
            minX = line.end.getX();
            maxX = line.start.getX();
        }
        double minY = line.start.getY();
        double maxY = line.end.getY();
        if (line.start.getY() > line.end.getY()) {
            minY = line.end.getY();
            maxY = line.start.getY();
        }
        if ((collisionPoint.getX() <= maxX) && (collisionPoint.getX() >= minX)
                && (collisionPoint.getY() <= maxY)
                && (collisionPoint.getY() >= minY)) {
            return true;
        }
        return false;
    }

    /**
     * Checks what is the closest intersection point.
     *
     * @param rect
     *            - rectangle.
     * @return - If this line does not intersect with the rectangle, return
     *         null. Otherwise, return the closest intersection point to the
     *         start of the line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> list = rect.intersectionPoints(this);
        if (list.isEmpty()) {
            return null;
        } else {
            Point closest = list.get(0);
            if (list.size() == 2
                    && list.get(1).distance(this.start) < closest
                            .distance(this.start)) {
                closest = list.get(1);
            }
            return closest;
        }
    }
}
