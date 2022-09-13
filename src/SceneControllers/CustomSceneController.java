package SceneControllers;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import main.GameManager;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class CustomSceneController implements Initializable {
    Scene menuScene;
    Scene gameScene;

    public Button menuButton;

    public Button createBoardButton;

    public ChoiceBox numRowsChoice;
    public ChoiceBox numColsChoice;

    public TextArea textArea;
    public TextField titleInput;

    public void goToMenu() throws IOException {
        Stage window = (Stage) menuButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("Screens/menu.fxml"));

        menuScene = new Scene(root, 800, 1000);
        window.setScene(menuScene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeBoardSizeDropdowns(20, 30, 8);

        createBoardButton.setOnAction(event -> {
            try {
                createBoard();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void createBoard() throws IOException {
        // Pass these values to a method in GameManager object or something
        // like gameManager.startCustomGame(...);
        GameManager.isCustom = true;
        GameManager.customRows = (int) numRowsChoice.getValue();
        GameManager.customCols = (int) numColsChoice.getValue();
        GameManager.customTitle = titleInput.getText();

        String customListText = textArea.getText();

        ArrayList<String> customWords = new ArrayList<>();
        String[] words = customListText.split("\\n");

        Collections.addAll(customWords, words);

        GameManager.customWords = customWords;


        Stage window = (Stage) createBoardButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("Screens/game.fxml"));

        gameScene = new Scene(root, 800, 1000);
        window.setScene(gameScene);
    }


    private void initializeBoardSizeDropdowns(int maxRows, int maxCols, int defaultSize) {
        for (int i = 1; i <= maxRows; i++)
            numRowsChoice.getItems().add(i);

        for (int i = 1; i <= maxCols; i++)
            numColsChoice.getItems().add(i);


        numRowsChoice.setValue(defaultSize);
        numColsChoice.setValue(defaultSize);
    }

}