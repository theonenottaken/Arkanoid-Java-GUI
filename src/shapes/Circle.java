package shapes;


/**
 * Circle class, part of a Monte-Carlo PI calculator.
 *
 * @author biuoop staff
 */
public class Circle {
   private Point center;
   private double radius;

   /**
    * Create a circle from a center specified as (x, y) and a radius.
    *
    * @param x the x location
    * @param y the y location
    * @param radius the circle's radius
    */
   public Circle(double x, double y, double radius) {
      this.center = new Point(x, y);
      this.radius = radius;
   }

   /**
    * Checks is the circle contain the given point.
    *
    * @param p a point
    * @return true if p is within the circle, false otherwise
    */
   public boolean containsPoint(Point p) {
      return p.distance(this.center) < this.radius;
   }
}
