package sokoban.boards;

import javafx.scene.layout.Pane;
import org.tinylog.Logger;
import sokoban.domain.Level;
import sokoban.domain.Point;
import sokoban.entities.*;

/**
 * A game board that manages the entities.
 */
public abstract class Board extends Pane {

    /**
     * The width of the board.
     */
    protected int width;

    /**
     * The height of the board.
     */
    protected int height;

    /**
     * The grid size of the entities.
     */
    protected int gridSize;

    /**
     * Player layers to work with.
     */
    protected EntitiesLayer playerLayer;

    /**
     * Spot layers to work with.
     */
    protected EntitiesLayer spotsLayer;

    /**
     * Floor layers to work with.
     */
    protected EntitiesLayer floorLayer;

    /**
     * Generates Board based on given Level.
     * @param level Level from which board will be created
     */
    public Board(Level level) {
        this.width = level.getWidth();
        this.height = level.getHeight();
        gridSize = 60;

        setSize(width * gridSize, height * gridSize);

        playerLayer = new EntitiesLayer(width, height);
        spotsLayer = new EntitiesLayer(width, height);
        floorLayer = new EntitiesLayer(width, height);

        for(var x = 0; x < width; x++) {
            for(var y = 0; y < height; y++) {
                switch (level.getBytesCoordinates(x, y)) {
                    case Level.WALL -> playerLayer.put(new Wall(new Point(x, y), gridSize));
                    case Level.PLAYER -> playerLayer.put(new Player(new Point(x, y), gridSize));
                    case Level.BOX -> playerLayer.put(new Box(new Point(x, y), gridSize));
                    case Level.SPOT -> spotsLayer.put(new Spot(new Point(x, y), gridSize));
                }
            }
        }
        Logger.tag("CONSOLE").info("Board successfully generated");
        getChildren().add(floorLayer);
        getChildren().add(spotsLayer);
        getChildren().add(playerLayer);
    }

    /**
     * Centering level with the given width and height.
     * @param width Given width in pixels
     * @param height Given height in pixels
     */
    private void setSize(int width, int height) {
        setMaxWidth(width);
        setMaxHeight(height);
    }

    /**
     * Returns Board width.
     * @return Board width
     */
    public int getBoardWidth() {
        return width;
    }

    /**
     * Returns Board height.
     * @return Board height
     */
    public int getBoardHeight() {
        return height;
    }

    /**
     * Checks if given Point is within a bounds of this Board.
     * @param point Point which will be checked
     * @return true if given Point is within a bounds of this Board; false otherwise
     */
    protected boolean isPointValid(Point point) {
        return ((point.getX() >= 0) && (point.getX() < width) && (point.getY() >= 0) && (point.getY() < height));
    }
}
