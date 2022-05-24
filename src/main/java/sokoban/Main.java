package sokoban;

import javafx.application.Application;
import org.tinylog.Logger;

/**
 * Main class to run the program.
 */
public class Main {
    /**
     * Main method of class.
     * @param args arguments passed to application
     */
    public static void main(String[] args) {
        // Run in Terminal: mvn exec:java OR java -jar .\target\Sokoban-1.0.jar OR java -jar .\target\Sokoban-1.0-shaded.jar
        // Run in Git bash: mvn exec:java OR java -jar ./target/Sokoban-1.0.jar OR java -jar ./target/Sokoban-1.0-shaded.jar
        Logger.tag("CONSOLE").info("Application successfully launched");
        Application.launch(SokobanApplication.class, args);
    }
}
