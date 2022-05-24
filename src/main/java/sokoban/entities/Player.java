package sokoban.entities;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import sokoban.domain.Point;

/**
 * Entity that represents a Player.
 */
public class Player extends Entity {

    /**
     * Constructs Player at the given position and grid size.
     * @param position The position which the Entity should be constructed
     * @param gridSize Size of the Entity
     */
    public Player(Point position, int gridSize) {
        super(position, gridSize);
        double margin = 5;

        Circle circle = new Circle(gridSize/2,gridSize/2, gridSize/2 - margin);
        circle.setFill(Color.DARKBLUE);

        getChildren().addAll(circle);
    }
}
