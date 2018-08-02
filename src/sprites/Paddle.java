package sprites;

import java.awt.Color;

import collisions.Collidable;
import collisions.Velocity;
import shapes.Point;
import shapes.Rectangle;
import animations.AnimationRunner;
import animations.GameLevel;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * Paddle Class. This class implements Sprite and Collidable.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Block block;
    private AnimationRunner runner;
    private double speed;
    private double dt = 1.00 / 60;

    /**
     * constructor.
     *
     * @param upperLeft
     *            - the upper left point.
     * @param width
     *            - the width of the paddle.
     * @param height
     *            - the hight of the paddle.
     * @param speed
     *            - the speed of the paddle.
     */
    public Paddle(Point upperLeft, double width, double height, double speed) {
        this.block = new Block(upperLeft, width, height);
        this.runner = null;
        this.speed = speed;
        this.speed = (this.speed + (1.00 / this.dt) - 1) / (1.00 / dt);
    }

    /**
     *
     * @return - the paddle's speed.
     */
    public double getPaddleSpeed() {
        return this.speed;
    }

    /**
     * set a new location to the paddle.
     *
     * @param newUpperLeft
     *            - the nwe upper left point.
     */
    public void setLocation(Point newUpperLeft) {
        this.block.getCollisionRectangle().setUpperLeft(newUpperLeft.getX(),
                newUpperLeft.getY());
    }

    /**
     *
     * @param game
     *            - remove the paddle from the current game level.
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }

    /**
     *
     * Moves the paddle to the left.
     */
    public void moveLeft() {
        double x2;

        if (block.getCollisionRectangle().getUpperLeft().getX() < this.speed) {
            x2 = 0;
        } else {
            x2 = block.getCollisionRectangle().getUpperLeft().getX()
                    - this.speed;
        }
        block.getCollisionRectangle().setUpperLeft(x2,
                block.getCollisionRectangle().getUpperLeft().getY());
    }

    /**
     * Moves the paddle to the right.
     */
    public void moveRight() {
        double x2;
        if (block.getCollisionRectangle().getUpperLeft().getX() > (800 - block
                .getCollisionRectangle().getWidth() - this.speed)) {
            x2 = 800 - block.getCollisionRectangle().getWidth();
        } else {
            x2 = block.getCollisionRectangle().getUpperLeft().getX()
                    + this.speed;
        }
        block.getCollisionRectangle().setUpperLeft(x2,
                block.getCollisionRectangle().getUpperLeft().getY());
    }

    /**
     * This function let the object know that time has passed and a key was
     * pressed.
     *
     * @param dt2
     *            - specifies the amount of seconds passed since the last call.
     */
    public void timePassed(double dt2) {
        this.dt = dt2;
        keyboard = runner.getGUI().getKeyboardSensor();
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        } else if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }

    /**
     * This function draws the paddle on the surface.
     *
     * @param surface
     *            - given surface.
     */
    public void drawOn(DrawSurface surface) {

        surface.setColor(Color.MAGENTA);
        surface.drawRectangle((int) this.block.getCollisionRectangle()
                .getUpperLeft().getX(), (int) this.block
                .getCollisionRectangle().getUpperLeft().getY(),
                (int) this.block.getCollisionRectangle().getWidth(),
                (int) this.block.getCollisionRectangle().getHeight());
        surface.fillRectangle((int) this.block.getCollisionRectangle()
                .getUpperLeft().getX(), (int) this.block
                .getCollisionRectangle().getUpperLeft().getY(),
                (int) this.block.getCollisionRectangle().getWidth(),
                (int) this.block.getCollisionRectangle().getHeight());
        double xCoord, yCoord, width, height;
        xCoord = this.getCollisionRectangle().getUpperLeft().getX();
        yCoord = this.getCollisionRectangle().getUpperLeft().getY();
        width = this.getCollisionRectangle().getWidth();
        height = this.getCollisionRectangle().getHeight();
        surface.setColor(Color.BLACK);
        surface.drawLine((int) xCoord, (int) yCoord, (int) (xCoord + width),
                (int) yCoord);
        surface.drawLine((int) (xCoord + width), (int) yCoord,
                (int) (xCoord + width), (int) (yCoord + height));
        surface.drawLine((int) (xCoord + width), (int) (yCoord + height),
                (int) xCoord, (int) (yCoord + height));
        surface.drawLine((int) xCoord, (int) (yCoord + height), (int) xCoord,
                (int) yCoord);

    }

    /**
     * @return - the collision rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return this.block.getCollisionRectangle();
    }

    /**
     * @param collisionPoint
     *            - given collision Point.
     * @param currentVelocity
     *            - given current Velocity
     * @param hitter
     *            - the hitting ball.
     * @return - the new velocity after a collision occurred
     */
    public Velocity hit(Ball hitter, Point collisionPoint,
            Velocity currentVelocity) {
        double xCoord = this.block.getCollisionRectangle().getUpperLeft()
                .getX();
        double yCoord = this.block.getCollisionRectangle().getUpperLeft()
                .getY();
        double fifth = this.block.getCollisionRectangle().getWidth() / 5;
        speed = (int) Math.sqrt(Math.pow(currentVelocity.getDX(), 2)
                + Math.pow(currentVelocity.getDY(), 2));
        Velocity newVelocity;
        if ((collisionPoint.getX() == xCoord && collisionPoint.getY() < yCoord)
                || (collisionPoint.getX() == xCoord
                        + this.block.getCollisionRectangle().getWidth() && collisionPoint
                        .getY() < yCoord)) { // if the ball hits the paddle on
                                             // the side...
            newVelocity = new Velocity(currentVelocity.getDX() * (-1),
                    currentVelocity.getDY());
        } else if (collisionPoint.getX() <= (xCoord + fifth)
                && (collisionPoint.getX() >= xCoord)) {
            newVelocity = Velocity.fromAngleAndSpeed(300, speed);
        } else if (collisionPoint.getX() <= (xCoord + (2 * fifth))) {
            newVelocity = Velocity.fromAngleAndSpeed(330, speed);
        } else if (collisionPoint.getX() <= (xCoord + (3 * fifth))) {
            newVelocity = this.block.hit(null, collisionPoint, currentVelocity);
        } else if (collisionPoint.getX() <= (xCoord + (4 * fifth))) {
            newVelocity = Velocity.fromAngleAndSpeed(30, speed);
        } else {
            newVelocity = Velocity.fromAngleAndSpeed(60, speed);

        }
        return newVelocity;
    }

    /**
     * add this paddle to the game.
     *
     * @param g
     *            - the game.
     */
    public void addToGame(GameLevel g) {
        this.runner = g.getRunner();
        g.addSprite(this);
        g.addCollidable(this);
    }
}
