package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
COLORS

#212121 - light black for bg
#121212 - dark black for features?
#bb85fd - violet for buttons, black text
#2e2e2e - grey for input text box with violet prompt text and white words
#0ecdbb - cyan for ...things...
 */
public class Main extends Application {
    Stage window;

    Scene menuScene;

    static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("../SceneControllers/Screens/menu_screen.fxml"));
        window = primaryStage;
        window.setTitle("J SEARCH ETERNAL");
        menuScene = new Scene(root, 800, 1000);

        window.setScene(menuScene);

        window.show();

    }



}
