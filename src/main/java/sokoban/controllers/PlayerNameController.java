package sokoban.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.tinylog.Logger;
import sokoban.SokobanApplication;
import sokoban.domain.Mode;

import java.io.IOException;

/**
 * Controller for Player Name game mode. It manages the player
 * name and will be stored in a variable.
 */
public class PlayerNameController extends Controller {

    /**
     * Represents the name of the Player.
     */
    @FXML
    private TextField nameField;

    /**
     * Error label will be shown if the player name is invalid.
     */
    @FXML
    private Label errorLabel;

    /**
     * Method nextScene() is called when button is pressed.
     * @param actionEvent ActionEvent object from JavaFX
     */
    @FXML
    public void nextScene(ActionEvent actionEvent) {
        if(nameField.getText().length() == 0){
            errorLabel.setText("Please enter a valid name!");
            Logger.tag("CONSOLE").info("Play button pressed");
            Logger.tag("CONSOLE").error("Invalid name");
            return;
        }
        game.changeMode(Mode.PLAY);
        SokobanApplication.setName(nameField.getText());
        Logger.tag("CONSOLE").info("Play button pressed");
    }

    /**
     * Constructs PlayerNameController associated with given game mode.
     * Appropriate scene with given width and height is created and linked
     * with this new PlayerNameController.
     * @param game Object to which Controller should be associated with
     * @param width Width of the Scene
     * @param height Height of the Scene
     * @throws IOException Throws IOException when unable to read FXML file
     */
    public PlayerNameController(SokobanApplication game, int width, int height) throws IOException {
        super(game, width, height);
    }

    /**
     * Returns path to FXML file. Must be overwritten by derived class,
     * so parent constructor can work properly.
     * @return path to FXML file
     */
    @Override
    protected String getFxmlPath() {
        return "/fxml/PlayerName.fxml";
    }

    /**
     * Method onKeyPressed() is called when key is pressed.
     * @param e KeyEvent object from JavaFX
     */
    @Override
    public void onKeyPressed(KeyEvent e) {
        if (e.getCode() == KeyCode.ESCAPE) {
            game.changeMode(Mode.MENU);
            nameField.setText("");
            errorLabel.setText("");
            Logger.tag("CONSOLE").info("ESCAPE key pressed");
        }
    }
}
