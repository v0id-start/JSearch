package SceneControllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuSceneController implements Initializable {

    public Button playButton;
    public Button customButton;
    public Button exitButton;

    public PieChart pieChart;

    private void goToScene(Button button, String path) throws IOException{
        Stage window = (Stage) button.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource(path));
        window.setScene(new Scene(root, 800, 1000));
    }

    public void goToDifficulty() throws IOException {
        goToScene(playButton, "Screens/difficulty_screen.fxml");
    }

    public void goToCustom() throws IOException {
        goToScene(customButton, "Screens/customize_screen.fxml");
    }

    public void exit()
    {
        Stage window = (Stage) exitButton.getScene().getWindow();
        window.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PieChart.Data youData = new PieChart.Data("Good at Word Searches", 100);
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(youData);

        pieChart.setData(pieChartData);

    }
}
