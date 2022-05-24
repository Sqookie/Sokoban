package sokoban.boards;

import org.junit.jupiter.api.Test;
import sokoban.domain.Level;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayBoardTest {
    @Test
    public void basicTest() {
        Level level = Level.mainLevel();
        PlayBoard playBoard = new PlayBoard(level);

        assertEquals(level.getWidth(), playBoard.getBoardWidth());
        assertEquals(level.getHeight(), playBoard.getBoardHeight());
    }
}
