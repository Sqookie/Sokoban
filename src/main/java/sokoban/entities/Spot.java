package sokoban.entities;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sokoban.domain.Point;

/**
 * Entity that represents the Spot and
 * checks which Box should be placed to win game.
 */
public class Spot extends Entity {

    /**
     * Checks if the Box is on the Spot or not.
     */
    private boolean isCorrect;

    /**
     * Spot displayed as rectangle.
     */
    private final Rectangle rectangle;

    /**
     * Constructs Spot at the given position and grid size.
     * @param position The position which the Entity should be constructed
     * @param gridSize Size of the Entity
     */
    public Spot(Point position, int gridSize) {
        super(position, gridSize);
        double margin = 0;

        rectangle = new Rectangle(margin, margin, gridSize - 2 * margin, gridSize - 2 * margin);
        rectangle.setFill(Color.MEDIUMPURPLE);

        getChildren().addAll(rectangle);
    }

    /**
     * Set true if the Box is on the Spot; false otherwise.
     * @param correct Checks if the Box is on the Sport or not.
     */
    public void setCorrect(boolean correct) {
        isCorrect = correct;
        update();
    }

    /**
     * Returns true if the Box is on the Spot; false otherwise.
     * @return true if this Box is on the Spot; false otherwise.
     */
    public boolean isCorrect() {
        return isCorrect;
    }

    /**
     * Changes graphics related properties.
     */
    protected void update() {
        super.update();
        if(rectangle == null) {
            return;
        }
        if(isCorrect) {
            rectangle.setFill(Color.HOTPINK);
        } else {
            rectangle.setFill(Color.MEDIUMPURPLE);
        }
    }
}
