package sokoban.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import org.tinylog.Logger;
import sokoban.SokobanApplication;
import sokoban.domain.Mode;
import sokoban.json.JsonBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Controller for Leaderboard game mode.
 */
public class LeaderboardController extends Controller {

    /**
     * Represents the top 10 players in the leaderboard.
     */
    @FXML
    private Text topPlayers;

    /**
     * Represents the top 10 player moves in the leaderboard.
     */
    @FXML
    private Text topPlayerMoves;

    /**
     * Constructs LeaderboardController associated with given game mode. Appropriate scene
     * with given width and height is created and linked with this new
     * LeaderboardController.
     * @param game Object to which Controller should be associated with
     * @param width Width of the Scene
     * @param height Height of the Scene
     * @throws IOException Throws IOException when unable to read FXML file
     */
    public LeaderboardController(SokobanApplication game, int width, int height) throws IOException {
        super(game, width, height);
    }

    /**
     * Returns path to FXML file. Must be overwritten by derived class,
     * so parent constructor can work properly.
     * @return path to FXML file
     */
    @Override
    protected String getFxmlPath() {
        return "/fxml/LeaderBoard.fxml";
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

    /**
     * Method called automatically by FXMLLoader after loading FXML file
     * containing definition of Scene. Will read the top 10 player data
     * from the json file.
     */
    @FXML
    private void initialize() {
        JsonBuilder jsonBuilder = new JsonBuilder();
        Platform.runLater(() -> {
            StringBuilder topPlayersText = new StringBuilder();
            StringBuilder topPlayerMovesText = new StringBuilder();
            try {
                List<Map.Entry<String, Long>> list = jsonBuilder.getTopTenPlayerNames();
                list.forEach((a) -> topPlayersText.append(a.getKey()).append("\n"));
                list.forEach((b) -> topPlayerMovesText.append(b.getValue()).append("\n"));
            } catch (IOException e) {
                Logger.tag("CONSOLE").error("An errors has occurred: {}", e.getMessage());
            }
            topPlayers.setText(topPlayersText.toString());
            topPlayerMoves.setText(topPlayerMovesText.toString());
            Logger.tag("CONSOLE").info("Leaderboard successfully generated");
        });
    }
}
