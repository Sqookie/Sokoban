package sokoban.domain;

import org.tinylog.Logger;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Level of the game, it's stored in 2D array of bytes.
 */
public class Level {

    /**
     * Value of the wall.
     */
    public static final byte WALL = 'W';

    /**
     * Value of the player.
     */
    public static final byte PLAYER = 'P';

    /**
     * Value of the box.
     */
    public static final byte BOX = 'B';

    /**
     * Value of the spot.
     */
    public static final byte SPOT = 'S';

    /**
     * The bytes of the Level will consist.
     */
    private final byte[][] bytes;

    /**
     * The width of the Level.
     */
    private final int width;

    /**
     * The height of this Level.
     */
    private final int height;

    /**
     * Constructs Level with given width, height and content bytes.
     * @param width Width of new level
     * @param height Height of new level
     * @param bytes Bytes of the Level will consist
     */
    public Level(int width, int height, byte[][] bytes) {
        this.bytes = new byte[width][height];
        this.width = width;
        this.height = height;

        for(var x = 0; x < width; x++) {
            for(var y = 0; y < height; y++) {
                this.bytes[x][y] = bytes[x][y];
            }
        }
    }

    /**
     * Constructs Level filled with bytes.
     * @return main level
     */
    public static Level mainLevel() {
        return fromString(
                "WWWWW    \n" +
                "WP  W    \n" +
                "W BBW WWW\n" +
                "W B W WSW\n" +
                "WWW WWWSW\n" +
                " WW    SW\n" +
                " W   W  W\n" +
                " W   WWWW\n" +
                " WWWWW     ");
    }

    /**
     * Constructs Level from bytes in string.
     * @param string The string from the Level should be loaded
     * @return Level is constructed from bytes in string
     */
    public static Level fromString(String string) {
        return fromBytes(string.getBytes(StandardCharsets.US_ASCII));
    }

    /**
     * Constructs Level from bytes.
     * @param bytes The bytes from the Level should be created
     * @return New Level constructed from given bytes
     */
    public static Level fromBytes(byte[] bytes) {
        int width = 9;
        int height = 9;
        List<List<Byte>> outerList = new ArrayList<>();
        List<Byte> innerList = new ArrayList<>();
        outerList.add(innerList);

        for (var b : bytes) {
            switch (b) {
                case '\n':
                    innerList = new ArrayList<>();
                    outerList.add(innerList);
                    continue;

                case WALL:
                case PLAYER:
                case BOX:
                case SPOT:
                    break;
            }
            innerList.add(b);
        }

        byte[][] result = new byte[width][height];

        for(var x = 0; x < width; x++) {
            for(var y = 0; y < height; y++) {
                innerList = outerList.get(y);
                result[x][y] = innerList.get(x);
            }
        }
        Logger.tag("CONSOLE").info("Level structure: {}", outerList);
        Logger.tag("CONSOLE").info("Level successfully generated");
        return new Level(width, height, result);
    }

    /**
     * Returns a byte located at given (x, y) coordinates.
     * @param x the x coordinate
     * @param y the y coordinate
     * @return byte located at given (x, y) coordinates
     */
    public int getBytesCoordinates(int x, int y) {
        return bytes[x][y];
    }

    /**
     * Returns the width of the Level.
     * @return width of the Level
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns the height of the Level.
     * @return height of the Level
     */
    public int getHeight() {
        return height;
    }
}
