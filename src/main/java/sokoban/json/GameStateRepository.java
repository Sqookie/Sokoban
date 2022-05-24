package sokoban.json;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

/**
 * This class used to get the data with a functional method.
 */
public class GameStateRepository extends GsonRepository<GameState> {

    /**
     * Automatically calls the GameState java class.
     */
    public GameStateRepository() {
        super(GameState.class);
    }

    /**
     * Returns the tio 10 player from the json file.
     * @return The top 10 player from the json file
     */
    public List<Map.Entry<String, Long>> getTopTen() {
        var elementList = elements.stream()
                .collect(groupingBy(GameState::getName, maxBy(Comparator.comparingLong(GameState::getMoves))));

        TreeMap<String,Long> treeMapElementList = new TreeMap<>();
        for(var values : elementList.entrySet()) {
            treeMapElementList.put(values.getKey(), values.getValue().get().getMoves());
        }

        var list = new ArrayList<>(treeMapElementList.entrySet());
        list.sort(Map.Entry.comparingByValue());

        return list.stream()
                .limit(10)
                .toList();
    }
}