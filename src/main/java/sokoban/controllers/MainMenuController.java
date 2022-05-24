package sokoban.controllers;

import javafx.scene.input.KeyEvent;
import org.tinylog.Logger;
import sokoban.SokobanApplication;
import sokoban.domain.Mode;

import java.io.IOException;

/**
 * Controller for Main Menu game mode.
 */
public class MainMenuController extends Controller {

    /**
     * Constructs MainMenuController associated with given game mode. Appropriate scene
     * with given width and height is created and linked with this new
     * MainMenuController.
     * @param game Object to which Controller should be associated with
     * @param width Width of the Scene
     * @param height Height of the Scene
     * @throws IOException Throws IOException when unable to read FXML file
     */
    public MainMenuController(SokobanApplication game, int width, int height) throws IOException {
        super(game, width, height);
    }

    /**
     * Returns path to FXML file. Must be overwritten by derived class,
     * so parent constructor can work properly.
     * @return path to FXML file
     */
    @Override
    protected String getFxmlPath() {
        return "/fxml/MainMenu.fxml";
    }

    /**
     * Method onKeyPressed() is called when key is pressed.
     * @param e KeyEvent object from JavaFX
     */
    @Override
    public void onKeyPressed(KeyEvent e) {
        switch (e.getCode()) {
            case DIGIT1 -> {
                game.changeMode(Mode.PLAYERNAME);
                Logger.tag("CONSOLE").info("DIGIT1 key pressed");
            }
            case DIGIT2 -> {
                game.changeMode(Mode.LEADERBOARD);
                Logger.tag("CONSOLE").info("DIGIT2 key pressed");
            }
            case DIGIT3 -> {
                game.changeMode(Mode.CONTROLS);
                Logger.tag("CONSOLE").info("DIGIT3 key pressed");
            }
            case ESCAPE -> {
                Logger.tag("CONSOLE").info("ESCAPE key pressed");
                game.exit();
            }
        }
    }
}
