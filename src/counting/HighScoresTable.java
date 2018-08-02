package counting;
import java.util.Collections;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

/**
 * HighScoresTable class. This class implements Serializable.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */

public class HighScoresTable implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int size;
    private List<ScoreInfo> scoresList;

    /**
     * Create an empty high-scores table with the specified size. The size means
     * that the table holds up to size top scores.
     *
     * @param size
     *            - the table's size.
     */
    public HighScoresTable(int size) {
        this.size = size;
        this.scoresList = new ArrayList<ScoreInfo>();
    }

    /**
     * Add a high-score.
     *
     * @param score
     *            - score info to add.
     */
    public void add(ScoreInfo score) {
        this.scoresList.add(score);
    }

    /**
     *
     * @param score
     *            - Score info to remove from list.
     */
    public void remove(ScoreInfo score) {
        this.scoresList.remove(score);
    }

    /**
     *
     * @return table size.
     */
    public int size() {
        return this.size;
    }

    // Return
    /**
     *
     * @return the current high scores. The list is sorted such that the highest
     *         scores come first.
     */
    public List<ScoreInfo> getHighScores() {
        Collections.sort(this.scoresList,this.getComparator());
        return this.scoresList;
    }

    /**
     * compares between two scores.
     */
    private Comparator<ScoreInfo> scoreComparator = new ScoreComparator();
    /**
     *
     * @return compares between two scores.
     */
    public Comparator<ScoreInfo> getComparator() {
        return this.scoreComparator;
    }

    /**
     *
     * @param score
     *            - score to check.
     * @return the rank of the current score. Rank > `size` means the score is
     *         too low and will not be added to the list.
     */
    public int getRank(int score) {
        this.scoresList = this.getHighScores();
        int minScore = 0;
        int rank = 0;
        if (!scoresList.isEmpty()) {
            minScore = scoresList.get(scoresList.size() - 1).getScore();
        } else {
            rank = 1;
            return rank;
        }
        if (score > minScore || scoresList.size() < this.size) {
            for (int i = 0; i < scoresList.size(); i++) {
                if (score > scoresList.get(i).getScore()) {
                    rank = i + 1;
                    break;
                }
            }
            return rank;
        } else {
            return this.size + 1;
        }
    }

    /**
     * Clears the table.
     */
    public void clear() {
        this.scoresList = new ArrayList<ScoreInfo>();
    }

    /**
     *
     * @param filename
     *            - Load table data from file.
     * @throws IOException
     *             - if there is a problem with loading the file.
     */
    public void load(File filename) throws IOException {
        // ObjectInputStream in = null;
        HighScoresTable table = null;
        if (filename.exists()) {
            File ifile = new File(filename.toString());
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(ifile));
            try {
                table = (HighScoresTable) in.readObject();
                //this.clear(); //
                this.scoresList.addAll(table.getHighScores()); // scores- list of
                                                               // the ScoreInfo
                this.size = table.size();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException e) {
                    System.err.println("Failed closing file: " + filename);
                }
            }
        }


    }

    /**
     *
     * @param filename
     *            - Save table data to the specified file.
     * @throws IOException
     *             - if there is a problem with saving the table.
     */
    public void save(File filename) throws IOException {

        String fileName = filename.getName();
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(this);
        } catch (IOException e) {
            System.err.println("Failed saving object");
            e.printStackTrace(System.err);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                System.err.println("Failed closing file: " + fileName);
            }
        }
    }

    /**
     *
     * @param filename
     *            - Read a table from file and return it.
     * @return - High Scores Table.
     */
    @SuppressWarnings("finally")
    public static HighScoresTable loadFromFile(File filename) {
        HighScoresTable hst = new HighScoresTable(2);
        try {
            hst.load(filename);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return hst;
        }
    }
}
