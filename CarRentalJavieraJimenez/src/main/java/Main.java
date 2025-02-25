import controller.MainController;

/**
 * Main class to launch the Car-Rent system.
 */
public class Main {

    /**
     * Entry point of the application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.launchMainMenu();
    }
}
