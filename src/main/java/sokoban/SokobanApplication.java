package sokoban;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.tinylog.Logger;
import sokoban.controllers.*;
import sokoban.domain.Mode;

/**
 * This class manages the Stage and changes Scenes.
 */
public class SokobanApplication extends Application {

    /**
     * Width of the Game window in pixels.
     */
    private static final int WIDTH = 800;

    /**
     * Height of the Game window in pixels.
     */
    private static final int HEIGHT = 600;

    /**
     * Stage of the Game.
     */
    private Stage stage;

    /**
     * Controller of the Player Name scene.
     */
    private PlayerNameController playerNameController;

    /**
     * Controller of the Player scene.
     */
    private PlayController playController;

    /**
     * Controller of the Main Menu scene.
     */
    private MainMenuController mainMenuController;

    /**
     * Controller of the Controls scene.
     */
    private ControlsController controlsController;

    /**
     * Controller of the Leaderboard scene.
     */
    private LeaderboardController leaderboardController;

    /**
     * Player name will be stored and used globally.
     */
    private static String playerName = "";

    /**
     * Player moves will be stored and used globally.
     */
    private static int movesCount = 0;

    /**
     * Constructs SokobanApplication object. Called automatically by JavaFX.
     */
    public SokobanApplication() {
        super();
    }

    /**
     * Entry point for JavaFX application.
     * @param primaryStage To be able to draw the window
     * @throws Exception If the argument is wrong
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setTitle("Sokoban");

        stage.setMinWidth(WIDTH);
        stage.setMinHeight(HEIGHT);

        playerNameController = new PlayerNameController(this, WIDTH, HEIGHT);
        playController = new PlayController(this, WIDTH, HEIGHT);
        mainMenuController = new MainMenuController(this, WIDTH, HEIGHT);
        controlsController = new ControlsController(this, WIDTH, HEIGHT);
        leaderboardController = new LeaderboardController(this, WIDTH, HEIGHT);

        changeMode(Mode.MENU);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Changes different game modes.
     * @param mode Which mode should the game switch to.
     */
    public void changeMode(Mode mode) {
        switch (mode) {
            case PLAYERNAME -> {
                Logger.tag("CONSOLE").info("ChangeMode method called (PLAYERNAME)");
                stage.setScene(playerNameController.getScene());
            }
            case PLAY -> {
                Logger.tag("CONSOLE").info("ChangeMode method called (PLAY)");
                stage.setScene(playController.getScene());
            }
            case MENU -> {
                Logger.tag("CONSOLE").info("ChangeMode method called (MENU)");
                stage.setScene(mainMenuController.getScene());
            }
            case CONTROLS -> {
                Logger.tag("CONSOLE").info("ChangeMode method called (CONTROLS)");
                stage.setScene(controlsController.getScene());
            }
            case LEADERBOARD -> {
                Logger.tag("CONSOLE").info("ChangeMode method called (LEADERBOARD)");
                stage.setScene(leaderboardController.getScene());
            }
        }
    }

    /**
     * Terminates application.
     */
    public void exit() {
        Platform.exit();
        System.exit(0);
        Logger.tag("CONSOLE").info("Exit method called");
    }

    /**
     * Player names will be set and used globally.
     * @param playerName Player names to be set.
     */
    public static void setName(String playerName) {
        SokobanApplication.playerName = playerName;
        Logger.tag("CONSOLE").info("Name set: {}", playerName);
    }

    /**
     * Returns the name of the Player.
     * @return The name of the Player
     */
    public static String getName(){
        return SokobanApplication.playerName;
    }

    /**
     * Player moves will be set and used globally.
     * @param movesCount Player moves to be set.
     */
    public static void setMovesCount(int movesCount) {
        SokobanApplication.movesCount = movesCount;
        Logger.tag("CONSOLE").info("Moves count set to {}", movesCount);
    }

    /**
     * Returns the number of Player moves.
     * @return The number of Player moves.
     */
    public static int getMovesCount() {
        return SokobanApplication.movesCount;
    }
}
