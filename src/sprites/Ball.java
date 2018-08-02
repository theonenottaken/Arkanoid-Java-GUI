package sprites;

import animations.GameLevel;
import biuoop.DrawSurface;
import gameplay.GameEnvironment;

import java.awt.Color;

import collisions.CollisionInfo;
import collisions.Velocity;
import shapes.Line;
import shapes.Point;

/**
 * Ball Class. this class implements Sprite.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */

public class Ball implements Sprite {
    private Velocity v;
    private Point center;
    private int r;
    private Color color;
    private GameEnvironment environment;
    private double dt = 1.00 / 60;

    /**
     * Constructs a Ball with the given center point, radius, and color.
     *
     * @param center
     *            - the center point of the circle
     *
     * @param r
     *            - the radius of the circle
     *
     * @param color
     *            - the color of the ball (circle)
     */
    public Ball(Point center, int r, Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.v = new Velocity(0, 0);
        this.environment = new GameEnvironment();
    }

    /**
     * Another constructor, but takes the x and y coordinates of the center
     * Point as parameters, instead of the whole Point.
     *
     * @param x
     *            - x coordinate of the center
     * @param y
     *            - y coordinate of the center
     * @param r
     *            - the ball's radius(size)
     * @param color
     *            - the ball's color
     */
    public Ball(int x, int y, int r, Color color) {
        this.r = r;
        this.color = color;
        this.center = new Point(x, y);
        this.v = new Velocity(0, 0);
        this.environment = new GameEnvironment();
    }

    /**
     * removes the ball from the game.
     *
     * @param g
     *            - current game level
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
        g.setNumOfBalls(-1);
    }

    /**
     *
     * @return - x coordinate of the circle's center.
     */
    public int getX() {
        return (int) center.getX();
    }

    /**
     *
     * @return - y coordinate of center.
     */
    public int getY() {
        return (int) center.getY();
    }

    /**
     *
     * @return - the center point of the circle.
     */
    public Point getCenter() {
        return this.center;
    }

    /**
     *
     * @return - radius of the circle
     */
    public int getSize() {
        return r;
    }

    /**
     *
     * @return - the color of the circle.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Draw the ball on the given DrawSurface.
     *
     * @param surface
     *            - the DrawSurface to be drawn upon.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.drawCircle(getX(), getY(), getSize());
        surface.fillCircle(getX(), getY(), getSize());
    }

    /**
     *
     * @param vel
     *            - Sets the velocity to the value of v.
     */
    public void setVelocity(Velocity vel) {
        this.v = vel;
    }

    /**
     *
     * Sets the velocity as a composition of the given change in x (dx) and
     * given change in y (dy).
     *
     * @param dx
     *            - change in x.
     * @param dy
     *            - change in y
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /**
     *
     * @param vel
     *            - velocity.
     */
    public void initVelocity(Velocity vel) {
        this.v = Velocity
                .fromAngleAndSpeed(vel.getAngle(), vel.getSpeed() * dt);
    }

    /**
     *
     * @return - the ball's velocity.
     */
    public Velocity getVelocity() {
        return this.v;
    }

    /**
     *
     * @return the ball's speed.
     */
    public double getBallSpeed() {
        return this.getVelocity().getSpeed();
    }

    /**
     *
     * @return - game Environment.
     */
    public GameEnvironment getGame() {
        return this.environment;
    }

    /**
     *
     * @param g
     *            - adding the ball to this specific game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.setNumOfBalls(1);
    }

    /**
     * Moves the ball one "step" on the screen, in the direction it's going in.
     */
    public void moveOneStep() {

        // If the ball has reached the left or right edge of the window...
        if ((this.center.getX() >= (800 - this.r))
                || (this.center.getX() <= this.r)) {
            this.v = getVelocity();
            // Bounce off the wall and keep going in the other direction.
            setVelocity((this.v.getDX()) * (-1), this.v.getDY());

            this.v.setSpeed((this.getVelocity().getSpeed() * (dt)));

        }
        // If the ball has reached the top or bottom edge of the screen...
        if ((this.center.getY() >= (600 - this.r))
                || (this.center.getY() <= (this.r + 30))) {
            this.v = getVelocity();
            // Bounce off the wall and keep going in the other direction.
            setVelocity(this.v.getDX(), (this.v.getDY()) * (-1));
            this.v.setSpeed(this.getVelocity().getSpeed() * (dt));
        }
        Line newLine = new Line(this.center, this.getVelocity().applyToPoint(
                this.center));
        CollisionInfo cInfo = environment.getClosestCollision(newLine);
        if (cInfo != null) {
            Velocity newVelocity = cInfo.collisionObject().hit(this,
                    cInfo.collisionPoint(), this.v);
            this.setVelocity(newVelocity.getDX(), newVelocity.getDY());
            this.v.setSpeed(this.getVelocity().getSpeed() * (1 / dt));
            this.center = this.getVelocity().applyToPoint(this.center);
        } else {
            this.center = this.getVelocity().applyToPoint(this.center);
        }
    }

    /**
     * @param dt1
     *            normalized value. letting the ball know that time has passed .
     */
    public void timePassed(double dt1) {
        this.dt = dt1;
        this.moveOneStep();
    }

    /**
     * setting game environment.
     *
     * @param env
     *            - game environment
     */
    public void setGameEnvironment(GameEnvironment env) {
        this.environment = env;
    }

    /**
     *
     * @param p
     *            - new location for the ball.
     */
    public void setLoc(Point p) {
        this.center = p;
    }
}
