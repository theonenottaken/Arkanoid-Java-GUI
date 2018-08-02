package counting;

import java.io.Serializable;

/**
 * ScoreInfo class. This class implements Serializable.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public class ScoreInfo implements Serializable {

    /**
     * keep it serializble.
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private int score;

    /**
     * constructor.
     * @param name - player's name.
     * @param score - player's score.
     */
    public ScoreInfo(String name, int score) {
        this.score = score;
        this.name = name;
    }

    /**
     *
     * @return - the player's name.
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @return - the player's score.
     */
    public int getScore() {
        return this.score;
    }
}
