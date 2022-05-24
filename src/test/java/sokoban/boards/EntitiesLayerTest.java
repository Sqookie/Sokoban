package sokoban.boards;

import org.junit.jupiter.api.Test;
import sokoban.domain.Point;
import sokoban.entities.Player;
import sokoban.entities.Wall;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EntitiesLayerTest {
    @Test
    public void basicTest() {
        EntitiesLayer entitiesLayer = new EntitiesLayer(50, 60);

        assertEquals(50, entitiesLayer.getLayerWidth());
        assertEquals(60, entitiesLayer.getLayerHeight());
    }

    @Test
    public void getTest() {
        EntitiesLayer entitiesLayer = new EntitiesLayer(36, 31);

        assertNull(entitiesLayer.get(new Point(3, 6)));
    }

    @Test
    public void putTest() {
        EntitiesLayer entitiesLayer = new EntitiesLayer(36, 31);

        assertNull(entitiesLayer.get(new Point(3, 6)));
    }

    @Test
    public void clearTest() {
        EntitiesLayer entitiesLayer = new EntitiesLayer(50, 18);

        assertNull(entitiesLayer.get(new Point(3, 6)));
        entitiesLayer.put(new Wall(new Point(3, 6), 60));
        entitiesLayer.clear(new Point(3, 6));
        assertNull(entitiesLayer.get(new Point(3, 6)));
    }

    @Test
    public void playerTest() {
        EntitiesLayer entitiesLayer = new EntitiesLayer(25, 21);

        assertNull(entitiesLayer.getPlayer());
        assertNull(entitiesLayer.get(new Point(12, 8)));

        entitiesLayer.put(new Player(new Point(12, 8), 60));

        assertEquals(12, entitiesLayer.getPlayer().getPosition().getX());
        assertEquals(8, entitiesLayer.getPlayer().getPosition().getY());

        entitiesLayer.clearPlayer();
        entitiesLayer.put(new Player(new Point(0, 3), 60));

        assertEquals(0, entitiesLayer.getPlayer().getPosition().getX());
        assertEquals(3, entitiesLayer.getPlayer().getPosition().getY());

        assertNull(entitiesLayer.get(new Point(12, 8)));
    }
}