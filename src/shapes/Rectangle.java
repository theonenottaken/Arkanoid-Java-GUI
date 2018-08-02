package shapes;

import java.util.List;
import java.util.ArrayList;

/**
 * Rectangle Class.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public class Rectangle {
    private double width;
    private double height;
    private Point upperLeft;

    /**
     * Create a new rectangle with location and width/height.
     *
     * @param upperLeft
     *            - the upper left point of the rectangle.
     * @param width
     *            - the width of the rectangle
     * @param height
     *            - the height of the rectangle
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     *
     * @param line
     *            - intersection with specific line.
     * @return - (possibly empty) List of intersection points with the specified
     *         line.
     */
    public List<Point> intersectionPoints(Line line) {
        List<Point> points = new ArrayList<Point>();
        List<Line> rectLines = new ArrayList<Line>();
        Point lowerLeft = new Point(upperLeft.getX(), upperLeft.getY() + height);
        Point lowerRight = new Point(lowerLeft.getX() + width, lowerLeft.getY());
        Point upperRight = new Point(lowerRight.getX(), upperLeft.getY());
        Line left = new Line(upperLeft, lowerLeft);
        Line bottom = new Line(lowerLeft, lowerRight);
        Line right = new Line(lowerRight, upperRight);
        Line top = new Line(upperRight, upperLeft);
        rectLines.add(left);
        rectLines.add(bottom);
        rectLines.add(right);
        rectLines.add(top);

        for (Line rectLine : rectLines) {
            Point intersection = line.intersectionWith(rectLine);
            if (intersection != null) {
                points.add(intersection);
            }
        }
        return points;
    }

    /**
     *
     * @return - the width of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     *
     * @return - the height of the rectangle
     */
    public double getHeight() {
        return this.height;
    }

    /**
     *
     * @return - the upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * setting a new upper left point for the rectangle.
     *
     * @param x
     *            - new x
     * @param y
     *            - new y.
     */
    public void setUpperLeft(double x, double y) {
        Point loc = new Point(x, y);
        this.upperLeft = loc;
    }
}
