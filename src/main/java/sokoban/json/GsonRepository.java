package sokoban.json;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * This class manages the load-, save file methods.
 * @param <T> The type of the class
 */
public class GsonRepository<T> extends Repository<T> {

    /**
     * Makes a functional json method.
     */
    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    /**
     * Associated with the Repository Class.
     * @param elementType The type of the Class
     */
    public GsonRepository(Class<T> elementType) {
        super(elementType);
    }

    /**
     * Gets the data from the given json file.
     * @param file File to work with
     * @throws IOException If the file could not be read
     */
    public void loadFromFile(File file) throws IOException {
        try (var reader = new FileReader(file)) {
            var listType = TypeToken.getParameterized(List.class, elementType).getType();
            elements = GSON.fromJson(reader, listType);
        }
    }

    /**
     * Saves the data to the given json file.
     * @param file File to work with
     * @throws IOException If the file could not be read
     */
    public void saveToFile(File file) throws IOException {
        try (var writer = new FileWriter(file)) {
            GSON.toJson(elements, writer);
        }
    }
}
