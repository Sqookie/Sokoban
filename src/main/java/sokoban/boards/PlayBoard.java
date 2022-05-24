package sokoban.boards;

import org.tinylog.Logger;
import sokoban.domain.Direction;
import sokoban.domain.Level;
import sokoban.domain.Point;
import sokoban.entities.Box;
import sokoban.entities.Entity;
import sokoban.entities.Player;
import sokoban.entities.Spot;

/**
 * A game board suited for playing the level. Contains Player which can be moved
 * according to rules of the game, and can push boxes.
 */
public class PlayBoard extends Board {

    /**
     * Counts how many times the player has moved.
     */
    private static int movesCount;

    /**
     * Is win fulfilled.
     */
    private static boolean winState;

    /**
     * Constructs PlayBoard based on given Level.
     * @param level Level from which board will be created
     */
    public PlayBoard(Level level) {
        super(level);
        updateWinState();
    }

    /**
     * Moves Player to the given direction according to rules in the game.
     * @param direction The direction which the Player will be moved
     */
    public void movePlayer(Direction direction) {
        Player player = playerLayer.getPlayer();

        Point currentPlayerPosition = player.getPosition();
        Point newPlayerPosition = new Point(currentPlayerPosition);
        newPlayerPosition.translate(direction);

        player.setDirection(direction);

        if(!isPointValid(newPlayerPosition)) {
            Logger.tag("CONSOLE").error("Invalid position");
            return;
        }

        Entity entity = playerLayer.get(newPlayerPosition);

        if(entity == null) {
            playerLayer.clearPlayer();
            player.move(direction);
            playerLayer.put(player);
        } else {
            if(entity instanceof Box box) {
                Point newBoxPosition = new Point(newPlayerPosition);
                newBoxPosition.translate(direction);

                if(!isPointValid(newBoxPosition) || playerLayer.get(newBoxPosition) != null) {
                    Logger.tag("CONSOLE").error("Invalid position");
                    return;
                }

                playerLayer.clearPlayer();
                playerLayer.clear(newPlayerPosition);

                player.move(direction);
                box.move(direction);

                playerLayer.put(player);
                playerLayer.put(box);

                Spot spot = (Spot) spotsLayer.get(newBoxPosition);
                if(spot != null) {
                    box.setCorrect(true);
                    spot.setCorrect(true);
                } else {
                    box.setCorrect(false);
                }

                spot = (Spot) spotsLayer.get(newPlayerPosition);
                if(spot != null) {
                    spot.setCorrect(false);
                }
                updateWinState();
            } else {
                return;
            }
        }
        movesCount++;
        Logger.tag("CONSOLE").info("Moves increased to {}", getMovesCount());
    }

    /**
     * Returns true if win is fulfilled; false otherwise.
     * @return true if win is fulfilled; false otherwise
     */
    public static boolean winState() {
        return winState;
    }

    /**
     * Recalculates the win state.
     */
    private void updateWinState() {
        Spot spot;
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                spot = (Spot) spotsLayer.get(new Point(x, y));
                if(spot != null && !spot.isCorrect()) {
                    winState = false;
                    Logger.tag("CONSOLE").info("Win state is {}", winState);
                    return;
                }
            }
        }
        winState = true;
        Logger.tag("CONSOLE").info("Win state is {}", winState);
    }

    /**
     * Returns the number of moves from the Player.
     * @return the number of moves from the Player
     */
    public static int getMovesCount() {
        return movesCount;
    }
}
