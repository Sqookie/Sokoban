package sokoban.json;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * This class manages the data and will be used globally.
 */
public class JsonBuilder {

    /**
     * Writes the Player name, and it's number of moves
     * to the json file.
     * @param name Name of the Player
     * @param moves Number of moves from the Player
     * @throws IOException If the file could not be read
     */
    public static void writeToFile(String name, int moves) throws IOException {
        var repository = new GameStateRepository();
        var data = GameState.builder()
                .name(name)
                .moves(moves)
                .build();
        File file = new File("leaderBoard.json");
        if (file.exists())
            repository.loadFromFile(file);
        repository.add(data);
        repository.saveToFile(file);
    }

    /**
     * Returns the top 10 player from the json file.
     * @return The top 10 player from the json file
     * @throws IOException If the file could not be read
     */
    public List<Map.Entry<String, Long>> getTopTenPlayerNames() throws IOException {
        var repository = new GameStateRepository();
        repository.loadFromFile(new File("leaderBoard.json"));
        return repository.getTopTen();
    }
}
