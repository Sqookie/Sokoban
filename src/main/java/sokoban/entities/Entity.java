package sokoban.entities;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sokoban.domain.Direction;
import sokoban.domain.Point;

/**
 * An entity with position and graphical representation.
 */
public abstract class Entity extends Pane {

    /**
     * The position of the Entity.
     */
    private Point position;

    /**
     * Grid size of the Entity.
     */
    private final int gridSize;

    /**
     * Constructs Entity at the given position and grid size.
     * @param position The position which the Entity should be constructed
     * @param gridSize Size of the Entity
     */
    public Entity(Point position, int gridSize) {
        this.position = new Point(position);
        this.gridSize = gridSize;

        getChildren().add(new Rectangle(gridSize, gridSize, Color.TRANSPARENT));

        update();
    }

    /**
     * Move the Entity to the given direction.
     * @param direction The direction the Entity will be moved
     */
    public void move(Direction direction) {
        position.translate(direction);
        update();
    }

    /**
     * Returns the Entity position.
     * @return Returns Point specifying position of the Entity
     */
    public Point getPosition() {
        return new Point(position);
    }

    /**
     * Sets the Entity position.
     * @param position Point specifying position of the Entity
     */
    public void setPosition(Point position) {
        this.position = new Point(position);
        update();
    }

    /**
     * Sets the Entity direction.
     * @param direction The direction the Entity will be moved
     */
    public void setDirection(Direction direction) {
        update();
    }

    /**
     * Changes graphics related properties.
     */
    protected void update() {
        setWidth(gridSize);
        setHeight(gridSize);

        setLayoutX(position.getX() * gridSize);
        setLayoutY(position.getY() * gridSize);
    }

}
