package sprites;

import biuoop.DrawSurface;
/**
 * Sprite interface.
 * @author Mor Barak and Caleb shere
 * ID numbers: 2493276919 and 302620638
 *
 */
public interface Sprite {
    /**
     * draw the sprite to the screen.
     * @param d - the surface to draw on .
     */
   void drawOn(DrawSurface d);
   /**
    *@param dt - normalized value.
    * notify the sprite that time has passed.
    */
   void timePassed(double dt);
}
