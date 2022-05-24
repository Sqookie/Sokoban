package sokoban.controllers;

import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import org.tinylog.Logger;
import sokoban.SokobanApplication;
import sokoban.boards.PlayBoard;
import sokoban.domain.Direction;
import sokoban.domain.Level;
import sokoban.domain.Mode;
import sokoban.json.JsonBuilder;

import java.io.IOException;

import static sokoban.domain.Direction.*;

/**
 * Controller for Play game mode. It manages PlayBoard and
 * handles keystrokes.
 */
public class PlayController extends Controller{

    /**
     * Represents the level on the Pane.
     */
    @FXML
    private StackPane mainPane;

    /**
     * Represents the number of moves from the Player.
     */
    @FXML
    private Text countText;

    /**
     * PlayBoard representing current state of game board.
     */
    private PlayBoard playBoard;

    /**
     * Main level of the game.
     */
    private Level level;

    /**
     * Constructs PlayController associated with given game mode. Appropriate scene
     * with given width and height is created and linked with this new
     * PlayController.
     * @param game Object to which Controller should be associated with
     * @param width Width of the Scene
     * @param height Height of the Scene
     * @throws IOException Throws IOException when unable to read FXML file
     */
    public PlayController(SokobanApplication game, int width, int height) throws IOException {
        super(game, width, height);
    }

    /**
     * Returns path to FXML file. Must be overwritten by derived class,
     * so parent constructor can work properly.
     * @return path to FXML file
     */
    @Override
    protected String getFxmlPath() {
        return "/fxml/Play.fxml";
    }

    /**
     * Method called automatically by FXMLLoader after loading FXML file
     * containing definition of Scene. Will automatically load level
     * after the application starts.
     */
    @FXML
    public void initialize() {
        loadLevel();
    }

    /**
     * Loads level after the application starts.
     */
    private void loadLevel() {
        Level level = this.level;
        if (level == null) {
            level = Level.mainLevel();
        }
        playBoard = new PlayBoard(level);
        mainPane.getChildren().add(0, playBoard);
        update();
        Logger.tag("CONSOLE").info("Level successfully loaded");
    }

    /**
     * Method onKeyPressed() is called when key is pressed.
     * @param e KeyEvent object from JavaFX
     */
    @Override
    public void onKeyPressed(KeyEvent e) {
        Direction direction = null;
        switch (e.getCode()) {
            case ESCAPE:
                game.changeMode(Mode.LEADERBOARD);
                Logger.tag("CONSOLE").info("ESCAPE key pressed");
                Logger.tag("CONSOLE").warn("Player give up");
            case W, UP:
                direction = UP;
                Logger.tag("CONSOLE").info("W/UP key pressed");
                break;
            case D, RIGHT:
                direction = RIGHT;
                Logger.tag("CONSOLE").info("D/RIGHT key pressed");
                break;
            case S, DOWN:
                direction = DOWN;
                Logger.tag("CONSOLE").info("S/DOWN key pressed");
                break;
            case A, LEFT:
                direction = LEFT;
                Logger.tag("CONSOLE").info("A/LEFT key pressed");
                break;
        }
        if (!PlayBoard.winState() && direction != null) {
            playBoard.movePlayer(direction);
            update();
        }
    }

    /**
     * Update player moves count and will store the player data
     * after every Box has been pushed to the correct Spot.
     */
    private void update() {
        countText.setText("" + PlayBoard.getMovesCount());
        SokobanApplication.setMovesCount(PlayBoard.getMovesCount());

        if(PlayBoard.winState()) {
            game.changeMode(Mode.LEADERBOARD);

            try {
                JsonBuilder.writeToFile(SokobanApplication.getName(),SokobanApplication.getMovesCount());
                Logger.tag("CONSOLE").warn("Successfully saved data to json: [{}, {}]",
                        SokobanApplication.getName(), SokobanApplication.getMovesCount());
            } catch (IOException e) {
                Logger.tag("CONSOLE").error(e.getMessage());
            }
        }
    }
}
