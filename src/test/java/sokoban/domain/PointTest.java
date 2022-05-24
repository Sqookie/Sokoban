package sokoban.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTest {
    @Test
    public void getTest() {
        Point point;
        point = new Point(8, 9);
        assertEquals(8, point.getX());
        assertEquals(9, point.getY());

        point = new Point(2, 4);
        assertEquals(2, point.getX());
        assertEquals(4, point.getY());

        point = new Point(7, 13);
        assertEquals(7, point.getX());
        assertEquals(13, point.getY());

        point = new Point(23, 40);
        assertEquals(23, point.getX());
        assertEquals(40, point.getY());
    }

    @Test
    public void setTest() {
        Point point = new Point(1, 9);
        point.setX(30);
        assertEquals(30, point.getX());

        point.setX(44);
        assertEquals(44, point.getX());

        point.setX(0);
        assertEquals(0, point.getX());

        point.setY(14);
        assertEquals(14, point.getY());

        point.setY(1);
        assertEquals(1, point.getY());

        point.setX(60);
        point.setY(53);
        assertEquals(60, point.getX());
        assertEquals(53, point.getY());

        point.setX(43);
        point.setY(21);
        assertEquals(43, point.getX());
        assertEquals(21, point.getY());
    }

    @Test
    public void moveTest() {
        Point point = new Point(4, 2);

        point.move(61, 23);
        assertEquals(61, point.getX());
        assertEquals(23, point.getY());

        point.move(-6, 4);
        assertEquals(-6, point.getX());
        assertEquals(4, point.getY());

        point.move(0, 0);
        assertEquals(0, point.getX());
        assertEquals(0, point.getY());
    }

    @Test
    public void translateXYTest() {
        Point point = new Point(-5, 7);

        point.translate(4, -1);
        assertEquals(-1, point.getX());
        assertEquals(6, point.getY());

        point.translate(0, 0);
        assertEquals(-1, point.getX());
        assertEquals(6, point.getY());

        point.translate(-7, -40);
        assertEquals(-8, point.getX());
        assertEquals(-34, point.getY());

        point.translate(100, 200);
        assertEquals(92, point.getX());
        assertEquals(166, point.getY());
    }

    @Test
    public void translateDirectionTest() {
        Point point = new Point(23, 33);

        point.translate(Direction.UP);
        assertEquals(23, point.getX());
        assertEquals(32, point.getY());

        point.translate(Direction.LEFT);
        assertEquals(22, point.getX());
        assertEquals(32, point.getY());

        point.translate(Direction.DOWN);
        assertEquals(22, point.getX());
        assertEquals(33, point.getY());

        point.translate(Direction.RIGHT);
        assertEquals(23, point.getX());
        assertEquals(33, point.getY());
    }
}