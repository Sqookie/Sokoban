package sokoban.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import sokoban.SokobanApplication;

import java.io.IOException;

/**
 * Controller class sets up scene and provides some
 * methods which can be overwritten by derived classes.
 */
abstract public class Controller {

    /**
     * Used to change game modes.
     */
    protected SokobanApplication game;

    /**
     * Scene associated with this controller.
     */
    protected Scene scene;

    /**
     * Constructs Controller associated with given game mode. Appropriate scene
     * with given width and height is created and linked with this new
     * Controller.
     * @param game Object to which Controller should be associated with
     * @param width Width of the Scene
     * @param height Height of the Scene
     * @throws IOException Throws IOException when unable to read FXML file
     */
    public Controller(SokobanApplication game, int width, int height) throws IOException {
        this.game = game;

        var loader = new FXMLLoader(getClass().getResource(getFxmlPath()));
        loader.setController(this);
        Parent root = loader.load();
        scene = new Scene(root, width, height);
        scene.setOnKeyPressed(this::onKeyPressed);
    }

    /**
     * Returns path to FXML file. Must be overwritten by derived class,
     * so parent constructor can work properly.
     * @return path to FXML file
     */
    abstract protected String getFxmlPath();

    /**
     * Returns Scene associated with this Controller.
     * @return Scene associated with this Controller
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * Method onKeyPressed() is called when key is pressed.
     * @param e KeyEvent object from JavaFX
     */
    public void onKeyPressed(KeyEvent e) {
    }
}
