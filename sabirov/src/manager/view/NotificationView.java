package manager.view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import manager.Main;
import manager.task.Task;

import java.io.IOException;

/**
 * Notification window.
 */

public class NotificationView {
    @FXML
    private BorderPane root;

    @FXML
    private Button ok;

    @FXML
    private Label name;

    @FXML
    private Label description;

    private Task task;

    private Stage dialogStage;

    public NotificationView(Task task) {
        this.task = task;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/dialogNotification.fxml"));
        fxmlLoader.setController(this);
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows notification window.
     */
    public void show(){
        Platform.runLater(() -> {
            name.setText(task.getName());
            description.setText(task.getDescription());

            dialogStage = new Stage();
            dialogStage.setTitle("Notification");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(Main.getStage());
            Scene scene = new Scene(root);
            dialogStage.setScene(scene);
            dialogStage.setResizable(false);
            dialogStage.showAndWait();
        });

    }

    @FXML
    private void onClickOk(ActionEvent actionEvent){
        dialogStage.close();
    }
}
