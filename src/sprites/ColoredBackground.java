package sprites;

import java.awt.Color;


import java.lang.reflect.Field;



import shapes.Point;
import biuoop.DrawSurface;

/**
 * Background Class. this class implements Sprite.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public class ColoredBackground implements Sprite, Background {
    private int levelNum;
    private Color backColor;

    /**
     *
     * @param num
     *            - representing a color for the background.
     */
    public ColoredBackground(int num) {
        this.levelNum = num;
        if (levelNum == 1) {
            this.backColor = Color.BLACK;
        } else if (levelNum == 2) {
            this.backColor = Color.WHITE;
        } else if (levelNum == 3) {
            this.backColor = Color.GREEN;
        } else if (levelNum == 4) {
            this.backColor = Color.BLUE;
        }
    }

    /**
     *
     * @param color
     *            - color.
     */
    public ColoredBackground(Color color) {
        this.backColor = color;
    }

    /**
     *
     * @param substring
     *            - a string.
     */
    public ColoredBackground(String substring) {
        try {
            System.out.println(substring);
            Field field = Class.forName("java.awt.Color").getField("yellow");
            System.out.println("nullush2");
            this.backColor = (Color) field.get(null);
        } catch (Exception e) {
            this.backColor = null; // Not defined
        }
    }

    /**
     * for now - do nothing.
     *
     * @param dt
     *            - specifies the amount of seconds passed since the last call.
     */
    public void timePassed(double dt) {
        // do nothing.
    }

    /**
     * draws the background and fill it with color. also, draws a face or target
     * draw.
     *
     * @param d
     *            - the draw surface.
     */
    public void drawOn(DrawSurface d) {
        Point center = new Point(0, 0);
        d.setColor(this.backColor);
        d.drawRectangle(1, 1, 798, 598);
        d.fillRectangle(1, 1, 798, 598);
        if (this.levelNum == 1) {
            drawLevelOne(d);
        } else if (this.levelNum == 2) {
            center = new Point(400, 210);
            drawFace(d, center);
            d.setColor(Color.RED);
            d.drawLine(370, 230, 430, 260);
        } else if (this.levelNum == 3) {
            center = new Point(200, 400);
            drawFace(d, center);
            d.setColor(Color.RED);
            d.drawLine(170, 430, 230, 430);
        } else if (this.levelNum == 4) {
            center = new Point(200, 450);
            drawFace(d, center);
            d.setColor(Color.RED);
            d.drawLine(170, 470, 230, 470);
            d.drawLine(185, 495, 215, 495);
            d.drawLine(170, 470, 185, 495);
            d.drawLine(230, 470, 215, 495);
            d.drawLine(170, 470, 160, 462);
            d.drawLine(230, 470, 240, 462);
            d.drawLine(157, 466, 163, 458);
            d.drawLine(237, 458, 243, 466);
        }
    }

    /**
     *
     * @param d - surface.
     */
    public void drawBackground(DrawSurface d) {
        d.setColor(this.backColor);
        d.drawRectangle(1, 1, 798, 598);
        d.fillRectangle(1, 1, 798, 598);
    }

    /**
     *
     * @return - the background's color.
     */
    public Color getColor() {
        return this.backColor;

    }

    /**
     * draws the target for the first level.
     *
     * @param d
     *            - current draw surface.
     */
    private void drawLevelOne(DrawSurface d) {
        d.setColor(Color.BLUE);
        d.drawCircle(400, 160, 30);
        d.drawCircle(400, 160, 50);
        d.drawCircle(400, 160, 70);
        d.drawLine(320, 160, 480, 160);
        d.drawLine(400, 85, 400, 235);
    }

    /**
     * draws a face.
     *
     * @param d
     *            - current draw surface.
     * @param center
     *            - the center of the face.
     */
    private void drawFace(DrawSurface d, Point center) {
        int x = (int) center.getX();
        int y = (int) center.getY();
        d.setColor(Color.YELLOW);
        d.drawCircle(x, y, 80);
        d.fillCircle(x, y, 80);
        d.setColor(Color.blue);
        d.drawCircle(x - 30, y - 20, 8);
        d.fillCircle(x - 30, y - 20, 8);
        d.drawCircle(x + 30, y - 20, 8);
        d.fillCircle(x + 30, y - 20, 8);
        d.setColor(Color.black);
        d.drawLine(x, y - 80, x, y - 110);
        d.drawLine(x - 30, y - 75, x - 60, y - 100);
        d.drawLine(x + 30, y - 75, x + 60, y - 100);
        d.setColor(Color.black);
        d.drawLine(x - 42, y - 32, x - 22, y - 32);
        d.drawLine(x + 42, y - 32, x + 22, y - 32);
    }
}
