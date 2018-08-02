package gameplay;

import java.awt.Color;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import collisions.Velocity;
import sprites.Background;
import sprites.ColoredBackground;
import sprites.ImgBackground;
import levels.ColorsParser;
import levels.Level;
import levels.BlocksFromSymbolsFactory;
import levels.LevelInformation;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import levels.BlocksDefinitionReader;

/**
 * LevelSpecificationReader Class.
 *
 * @author Mor Barak and Caleb shere ID numbers: 2493276919 and 302620638
 *
 */

public class LevelSpecificationReader {

    /**
     *
     * @param reader
     *            - reads the file
     * @return - list of level Information that will be run at the main class.
     */
    public List<LevelInformation> fromReader(java.io.Reader reader) {
        List<LevelInformation> levels = new LinkedList<LevelInformation>();
        BufferedReader bf = new BufferedReader(reader);
        String row = null;
        try {

            while ((row = bf.readLine()) != null) {

                // starting a new level - initiate all the parameters.
                if (row.equals(("START_LEVEL"))) {

                    BlocksFromSymbolsFactory blocksDef = null;
                    String levelName = null;
                    List<Velocity> ballVelocities = new ArrayList<Velocity>();
                    Background background = null;
                    int paddleSpeed = 0;
                    int paddleWidth = 0;
                    int blockStartX = 0;
                    int blockStartY = 0;
                    int rowHeight = 0;
                    int numOfBlocks = 0;
                    List<String> blockLines = new ArrayList<String>();
                    int validation = 0;
                    row = bf.readLine();
                    // starts to read until the end of the level.
                    while (!(row.equals("END_LEVEL"))) {
                        String[] property = row.split(":");
                        if (property[0].equals("level_name")) {
                            levelName = property[1];
                            validation++;
                        } else if (property[0].equals("block_definitions")) {
                        	InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(property[1]);
                            blocksDef = BlocksDefinitionReader
                                    .fromReader(new InputStreamReader(is));
                            validation++;
                        } else if (property[0].equals("paddle_speed")) {
                            paddleSpeed = Integer.parseInt(property[1]);
                            validation++;
                        } else if (property[0].equals("paddle_width")) {
                            paddleWidth = Integer.parseInt(property[1]);
                            validation++;
                        } else if (property[0].equals("blocks_start_x")) {
                            blockStartX = Integer.parseInt(property[1]);
                            validation++;
                        } else if (property[0].equals("blocks_start_y")) {
                            blockStartY = Integer.parseInt(property[1]);
                            validation++;
                        } else if (property[0].equals("row_height")) {
                            rowHeight = Integer.parseInt(property[1]);
                            validation++;
                        } else if (property[0].equals("num_blocks")) {
                            numOfBlocks = Integer.parseInt(property[1]);
                            validation++;
                        } else if (property[0].equals("background")) {
                            Color c = ColorsParser.colorFromString(property[1]);
                            if (c == null) {
                                background = new ImgBackground(
                                        property[1].substring(6,
                                                property[1].length() - 1));
                            } else {
                                background = new ColoredBackground(c);
                            }
                            validation++;
                        } else if (property[0].equals("ball_velocities")) {
                            if (property.length > 1) {
                                String[] vals = property[1].split(" ");

                                for (int i = 0; i < vals.length; i++) {
                                    String[] as = vals[i].split(",");
                                    int[] angspeed = new int[2];
                                    angspeed[0] = Integer.parseInt(as[0]);
                                    angspeed[1] = Integer.parseInt(as[1]);
                                    ballVelocities.add(Velocity
                                            .fromAngleAndSpeed(angspeed[0],
                                                    angspeed[1]));
                                }
                            }
                            validation++;
                        }
                        if (row.equals(("START_BLOCKS"))) {
                            row = bf.readLine();
                            while (!(row.equals("END_BLOCKS"))) {
                                blockLines.add(row);
                                row = bf.readLine();
                            }
                        }
                        row = bf.readLine();
                    }
                    if (validation == 10) {
                        Level as = new Level();
                        as.setPaddleSpeed(paddleSpeed);
                        as.setVelocities(ballVelocities);
                        as.setbackground(background);
                        as.setnumOfBlocksToRemove(numOfBlocks);
                        as.setpaddleWidth(paddleWidth);
                        as.setname(levelName);
                        as.setBlockStartX(blockStartX);
                        as.setBlockStartY(blockStartY);
                        as.setRowHeight(rowHeight);
                        as.setnumOfBalls(ballVelocities.size());
                        as.setBlockDef(blocksDef);
                        as.createBlocks(blockLines);
                        levels.add(as);

                    } else {
                        System.out.println("missing level definition fields");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("error parsing level definition file");
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return levels;
    }
}
