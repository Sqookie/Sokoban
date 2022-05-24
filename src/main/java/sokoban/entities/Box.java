package sokoban.entities;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sokoban.domain.Point;

/**
 * Entity that represents the Box.
 */
public class Box extends Entity {

    /**
     * Checks if the Box is on the Spot or not.
     */
    private boolean isCorrect;

    /**
     * Constructs Box at the given position and grid size.
     * @param position The position which the Entity should be constructed
     * @param gridSize Size of the Entity
     */
    public Box(Point position, int gridSize) {
        super(position, gridSize);
        isCorrect = false;

        double margin = 5;

        Rectangle rectangle = new Rectangle(margin, margin, gridSize - 2 * margin, gridSize - 2 * margin);
        rectangle.setFill(Color.ROYALBLUE);

        getChildren().addAll(rectangle);
    }

    /**
     * Set true if the Box is on the Spot; false otherwise.
     * @param correct Checks if the Box is on the Sport or not.
     */
    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    /**
     * Returns true if the Box is on the Spot; false otherwise.
     * @return true if this Box is on the Spot; false otherwise.
     */
    public boolean isCorrect() {
        return isCorrect;
    }

}
