package gameplay;

import java.util.Random;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

import java.awt.Color;

import sprites.Ball;

/**
 * @author Mor Barak and Caleb Shere . ID Numbers: 302620638 and 2-49327691-9
 *
 *         Makes an animation of one ball bouncing around a window.
 */
public class BouncingBallAnimation {
    private Ball ball = null;

    /**
     * Constructs a new bouncing ball animation.
     */
    public BouncingBallAnimation() {
    }

    /**
     *
     * @param args
     *            - arguments
     */
    public static void main(String[] args) {
        GUI gui = new GUI("title", 800, 600);
        BouncingBallAnimation balli = new BouncingBallAnimation();
        // Makes a ball of radius 40 to bounce around in the GUI window.
        balli.createBounceBall(40);
        // Run infinitely until the user closes the window.
        while (true) {
            DrawSurface d = gui.getDrawSurface();
            Sleeper sleeper = new Sleeper();
            // Ball moves on the screen, bounces if it reaches a wall.
            balli.getBall().moveOneStep();
            balli.getBall().drawOn(d);
            gui.show(d);
            sleeper.sleepFor(50);
        }
    }

    /**
     * Makes the ball to bounce around.
     *
     * @param r
     *            -the size of the ball
     * @throws IllegalArgumentException
     *             - invalid input
     */
    public void createBounceBall(int r) throws IllegalArgumentException {
        if (r >= 300 || r <= 0) {
            throw new IllegalArgumentException("Invalid radius");
        }
        Random rand = new Random();
        // Make a ball with random start position and color
        int x = rand.nextInt(100) + 50;
        int y = rand.nextInt(100) + 300;
        this.ball = new Ball(x, y, r, Color.RED);
        if (r < 50) {
            // Make small balls faster and big balls slower
            ball.setVelocity(20 / r, 20 / r);
        } else {
            // Same speed for all balls bigger than radius 50
            ball.setVelocity(10.6, 10.6);
        }
    }

    /**
     * @return - the ball of this animation.
     */
    public Ball getBall() {
        return this.ball;
    }
}
