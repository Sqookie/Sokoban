package sokoban.json;

import lombok.Builder;
import lombok.Data;

/**
 * This class represents which data should be stored to the json file.
 */
@Builder
@Data
class GameState {
    /**
     * Player names to work with.
     */
    private String name;

    /**
     * Number of moves to work with.
     */
    private long moves;
}