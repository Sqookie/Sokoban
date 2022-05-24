package sokoban.boards;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import org.tinylog.Logger;
import sokoban.domain.Point;
import sokoban.entities.Entity;
import sokoban.entities.Player;

/**
 * This class representing grid with given width and height.
 */
public class EntitiesLayer extends Pane {

    /**
     * Lookup table containing references to entities.
     */
    private final Entity[][] Entities;

    /**
     * The width of the EntitiesLayer.
     */
    private final int width;

    /**
     * The height of the EntitiesLayer.
     */
    private final int height;

    /**
     * Reference to Player entity present on the Layer. Can be null if there
     * is no Player.
     */
    private Player player;

    /**
     * Constructs new EntitiesLayer with given size.
     * @param width Width of new EntitiesLayer
     * @param height Height of new EntitiesLayer
     */
    public EntitiesLayer(int width, int height) {
        this.width = width;
        this.height = height;

        Entities = new Entity[width][height];

        setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    /**
     * Removes entity present at the given Point. If there is no entity, does
     * nothing.
     * @param point Point from which entity should be removed
     */
    public void clear(Point point) {
        Entity entity = get(point);
        if(entity == null) {
            return;
        }
        if(entity instanceof Player) {
            player = null;
        }
        Entities[point.getX()][point.getY()] = null;
        getChildren().remove(entity);
    }

    /**
     * Put entity into Layer using its position. If other entity is already
     * present at that position, it will be replaced with the new one.
     * @param entity Entity to be placed into layer
     */
    public void put(Entity entity) {
        Point point = entity.getPosition();
        if(entity instanceof Player) {
            player = (Player) entity;
        }
        clear(point);
        Entities[point.getX()][point.getY()] = entity;
        getChildren().add(entity);
        Logger.tag("CONSOLE").info("{}", point);
    }

    /**
     * Returns entity present at given position.
     * @param point Point representing position from which Entity should be fetched.
     * @return entity present at given position
     */
    public Entity get(Point point) {
        return Entities[point.getX()][point.getY()];
    }

    /**
     * Returns reference to Player present at layer. Can be null.
     * @return reference to Player if there is Player on Layer; null otherwise
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Returns Layer width.
     * @return Layer width
     */
    public int getLayerWidth() {
        return width;
    }

    /**
     * Returns Layer height.
     * @return Layer height
     */
    public int getLayerHeight() {
        return height;
    }

    /**
     * Removes Player present on Layer. If there is no Player, does nothing.
     */
    public void clearPlayer() {
        Player player = getPlayer();
        if (player != null) {
            clear(player.getPosition());
        }
    }
}
