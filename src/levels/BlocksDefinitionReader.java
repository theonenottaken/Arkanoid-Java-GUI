package levels;

import java.io.BufferedReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * BlocksDefinitionReader class.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */
public class BlocksDefinitionReader {

    /**
     *
     * @param reader
     *            - a reader.
     * @return a blocks to be created.
     */
    public static BlocksFromSymbolsFactory fromReader(java.io.Reader reader) {
        
           
        BufferedReader br = new BufferedReader(reader);
        BlockProperties bp = new BlockProperties();
        BlockProperties bpDefaults = new BlockProperties();
        BlockProperties bpSpaces = new BlockProperties();
        BlocksFromSymbolsFactory bfsf = new BlocksFromSymbolsFactory();
        List<String[]> blockDef = new ArrayList<String[]>();
        List<String[]> spacerDef = new ArrayList<String[]>();
        String[] defaults = null;
        String line = null;
        try {
            while ((line = br.readLine()) != null) {
                String[] row = line.split(" ");
                String type = row[0];
                if (type.equals("bdef")) {
                    blockDef.add(row);
                }
                if (type.equals("sdef")) {
                    spacerDef.add(row);
                }
                if (type.equals("default")) {
                    defaults = row;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String[] rowProperty : blockDef) {
            bp = bp.readProperties(rowProperty);
            if (defaults != null) {
                bpDefaults = bpDefaults.readProperties(defaults);
                bpDefaults.merge(bp);
                // System.out.println("height = " + bpDefaults.getHeight() +
                // " wi = " + bpDefaults.getWidth() + " stro = " +
                // bpDefaults.getStroke() + " hit = " +
                // bpDefaults.getHitPoints() + " symb = " +
                // bpDefaults.getSymbol());
                bfsf.setBlockSymbol(bpDefaults.getSymbol(), bpDefaults);
            } else {
                bfsf.setBlockSymbol(bp.getSymbol(), bp);
            }

        }

        // bp = bp.readProperties();

        for (String[] rowProperty : spacerDef) {
            bpSpaces = bpSpaces.readProperties(rowProperty);
            bfsf.setSpaceSymbol(bpSpaces.getSymbol(), bpSpaces.getWidth());
        }

        return bfsf;

    }

}
