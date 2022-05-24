package sokoban.entities;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sokoban.domain.Point;

/**
 * Entity that represents the Wall.
 */
public class Wall extends Entity {

    /**
     * Constructs Wall at the given position and grid size.
     * @param position The position which the Entity should be constructed
     * @param gridSize Size of the Entity
     */
    public Wall(Point position, int gridSize) {
        super(position, gridSize);
        double margin = 0;

        Rectangle rectangle = new Rectangle(margin, margin, gridSize - 2 * margin, gridSize - 2 * margin);
        rectangle.setFill(Color.FORESTGREEN);

        getChildren().addAll(rectangle);
    }
}
