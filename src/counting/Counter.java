package counting;
/**
 * Counter Class.
 * @author Mor Barak and Caleb shere
 * ID numbers: 2493276919 and 302620638
 *
 */
public class Counter {

    private int count = 0;
    /**
     * constructor.
     */
    public Counter() { }
    /**
     *
     * @param number - a starting number to count from.
     */
    public Counter(int number) {
        this.count = number;
    }
    /**
     *
     * @param number - add number to current count.
     */
    public void increase(int number) {
        this.count = this.count + number;
    }
    /**
     *
     * @param number - subtract number from current count.
     */
    public void decrease(int number) {
        this.count = this.count - number;
    }

    /**
     *
     * @return - get current count.
     */
    public int getValue() {
        return this.count;
    }
}
