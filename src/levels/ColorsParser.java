package levels;

/**
 * ColorsParser class.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public class ColorsParser {

    /**
     *
     * @param s
     *            - color in string.
     * @return - an Hsb format of color.
     */
    public static java.awt.Color colorFromString(String s) {
        if (!s.startsWith("color")) {
            return null;
        } else {
            String sub = s.substring(6);
            if (sub.startsWith("RGB")) {
                String[] rgb = sub.substring(4, sub.length() - 2).split(",");
                float[] hsbvals = null;
                hsbvals = java.awt.Color.RGBtoHSB(Integer.parseInt(rgb[0]),
                        Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2]),
                        hsbvals);
                return java.awt.Color.getHSBColor(hsbvals[0], hsbvals[1],
                        hsbvals[2]);
            } else {
                java.awt.Color color;
                try {
                    java.lang.reflect.Field field = java.awt.Color.class
                            .getField(sub.substring(0, sub.length() - 1));
                    color = (java.awt.Color) field.get(null);
                } catch (Exception e) {
                    color = null;
                }
                return color;
            }
        }
    }
}
