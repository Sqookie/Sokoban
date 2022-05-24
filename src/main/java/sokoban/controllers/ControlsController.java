package sokoban.controllers;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.tinylog.Logger;
import sokoban.SokobanApplication;
import sokoban.domain.Mode;

import java.io.IOException;

/**
 * Controller for Controls game mode.
 */
public class ControlsController extends Controller {

    /**
     * Constructs ControlsController associated with given game mode. Appropriate scene
     * with given width and height is created and linked with this new
     * ControlsController.
     * @param game Object to which Controller should be associated with
     * @param width Width of the Scene
     * @param height Height of the Scene
     * @throws IOException Throws IOException when unable to read FXML file
     */
    public ControlsController(SokobanApplication game, int width, int height) throws IOException {
        super(game, width, height);
    }

    /**
     * Returns path to FXML file. Must be overwritten by derived class,
     * so parent constructor can work properly.
     * @return path to FXML file
     */
    @Override
    protected String getFxmlPath() {
        return "/fxml/Controls.fxml";
    }

    /**
     * Method onKeyPressed() is called when key is pressed.
     * @param e KeyEvent object from JavaFX
     */
    @Override
    public void onKeyPressed(KeyEvent e) {
        if (e.getCode() == KeyCode.ESCAPE) {
            game.changeMode(Mode.MENU);
            Logger.tag("CONSOLE").info("ESCAPE key pressed");
        }
    }
}
