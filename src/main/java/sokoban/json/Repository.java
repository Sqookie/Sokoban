package sokoban.json;

import java.util.ArrayList;
import java.util.List;

/**
 * This Class manages the basic configurations.
 * @param <T> The type of the Class.
 */
public abstract class Repository<T> {

    /**
     * The type of the element.
     */
    protected Class<T> elementType;

    /**
     * List of the elements.
     */
    protected List<T> elements;

    /**
     * Stores the elements and creates an ArrayList.
     * @param elementType Type of the element
     */
    protected Repository(Class<T> elementType) {
        this.elementType = elementType;
        elements = new ArrayList<>();
    }

    /**
     * Type of the elements to be stored in List.
     * @param element Type of the element
     */
    public void add(T element) {
        elements.add(element);
    }
}
