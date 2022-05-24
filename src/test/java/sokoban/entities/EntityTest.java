package sokoban.entities;

import org.junit.jupiter.api.Test;
import sokoban.domain.Direction;
import sokoban.domain.Point;

import static org.junit.jupiter.api.Assertions.*;

public class EntityTest {
    @Test
    public void entityTest() {
        Entity entity = new Box(new Point(30, 44), 40);

        assertEquals(30, entity.getPosition().getX());
        assertEquals(44, entity.getPosition().getY());

        entity.move(Direction.UP);
        assertEquals(30, entity.getPosition().getX());
        assertEquals(43, entity.getPosition().getY());

        entity.move(Direction.RIGHT);
        assertEquals(31, entity.getPosition().getX());
        assertEquals(43, entity.getPosition().getY());

        entity.move(Direction.DOWN);
        assertEquals(31, entity.getPosition().getX());
        assertEquals(44, entity.getPosition().getY());

        entity.move(Direction.LEFT);
        assertEquals(30, entity.getPosition().getX());
        assertEquals(44, entity.getPosition().getY());

        entity.setPosition(new Point(9, 7));
        assertEquals(9, entity.getPosition().getX());
        assertEquals(7, entity.getPosition().getY());
    }

    @Test
    public void spotTest() {
        Spot spot = new Spot(new Point(23, 33), 40);

        assertFalse(spot.isCorrect());

        spot.setCorrect(true);
        assertTrue(spot.isCorrect());

        spot.setCorrect(false);
        assertFalse(spot.isCorrect());
    }

    @Test
    public void boxTest() {
        Box box = new Box(new Point(23, 33), 40);

        assertFalse(box.isCorrect());

        box.setCorrect(true);
        assertTrue(box.isCorrect());

        box.setCorrect(false);
        assertFalse(box.isCorrect());
    }
}