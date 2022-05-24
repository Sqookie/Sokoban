package sokoban;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SokobanApplicationTest {

    @Test
    public void getNameTest() {
        SokobanApplication.setName("");
        assertEquals("", SokobanApplication.getName());
    }

    @Test
    public void getMovesCountTest() {
        SokobanApplication.setMovesCount(0);
        assertEquals(0, SokobanApplication.getMovesCount());
    }

    @Test
    public void setNameTest() {
        SokobanApplication.setName("Sqookie");
        assertEquals(SokobanApplication.getName(), SokobanApplication.getName());
    }

    @Test
    public void setMovesCountTest() {
        SokobanApplication.setMovesCount(93);
        assertEquals(SokobanApplication.getMovesCount(), SokobanApplication.getMovesCount());
    }
}
