package sprites;

import java.util.ArrayList;
import java.util.List;

import biuoop.DrawSurface;
/**
 * SpriteCollection Class.
 * @author Mor Barak and Caleb shere
 * ID numbers: 2493276919 and 302620638
 *
 */
public class SpriteCollection {
    private List<Sprite> spritesList;
    private double dt;
    /**
     * Constructor.
     * A list of sprites.
     *@param dt - normalized value.
     */
    public SpriteCollection(double dt) {
       this.spritesList = new ArrayList<Sprite>();
       this.dt = dt;
    }
    /**
     * Adding to the sprites list.
     * @param s - a sprite object.
     */
    public void addSprite(Sprite s) {
       this.spritesList.add(s);
    }
    /**
     * Remove the current sprite from the list.
     * @param s - sprite object.
     */
    public void removeSprite(Sprite s) {
        this.spritesList.remove(s);
    }

    /**
     *  call timePassed() on all sprites.
     */
   public void notifyAllTimePassed() {
       List<Sprite> s = new ArrayList<Sprite>(this.spritesList);
       for (Sprite sp : s) {
           sp.timePassed(dt);
       }

   }
   /**
    *
    * @return - list of sprites.
    */
   public List<Sprite> getSList() {
       return this.spritesList;
   }

   /**
    * call drawOn(d) on all sprites.
    * @param d - the surface to draw on it0
    */
   public void drawAllOn(DrawSurface d) {
       for (Sprite s : this.spritesList) {
           s.drawOn(d);
       }
           }
   }

