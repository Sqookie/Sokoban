package sokoban.domain;

/**
 * A point representing a location in (x, y) coordinate.
 */
public class Point {

    /**
     * The x coordinate of the Point.
     */
    private int x;

    /**
     * The y coordinate of the Point.
     */
    private int y;

    /**
     * Constructs Point with the same location as the specified Point object.
     * @param point Point basing on which new Point will be created
     */
    public Point(Point point) {
        this(point.x, point.y);
    }

    /**
     * Constructs a Point at the specified (x, y) location.
     * @param x the x coordinate of newly constructed Point
     * @param y the y coordinate of newly constructed Point
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x coordinate of the Point.
     * @return the x coordinate of the Point
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y coordinate of the Point.
     * @return the y coordinate of the Point
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the y coordinate the Point.
     * @param y the new y coordinate of the Point
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Sets the x coordinate of Point.
     * @param x the new x coordinate of the Point
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets the location of the point to specific coordinates.
     * @param x the x coordinate of the new location
     * @param y the y coordinate of the new location
     */
    public void move(int x, int y) {
        setX(x);
        setY(y);
    }

    /**
     * Translates the point at location (x, y) by dx along x-axis and dy
     * along the y-axis so  it now represents the point (x + dx, y + dy).
     * @param dx distance to move the Point along x-axis
     * @param dy distance to move the Point along y-axis
     */
    public void translate(int dx, int dy) {
        move(x + dx, y + dy);
    }

    /**
     * Translates the point at location (x, y) from the given direction.
     * @param direction the direction in which this Point should be moved
     */
    public void translate(Direction direction) {
        switch (direction) {
            case UP -> translate(0, -1);
            case RIGHT -> translate(1, 0);
            case DOWN -> translate(0, 1);
            case LEFT -> translate(-1, 0);
        }
    }

    /**
     * Returns a string representing the Point coordinates.
     * @return a string representing the Point coordinates
     */
    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ')';
    }

}
