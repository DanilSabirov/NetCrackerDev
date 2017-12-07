package manager.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import manager.task.Task;

import java.io.IOException;
import java.util.List;

public class GraphicView extends BaseView {
    @FXML
    VBox listTasksVbox;

    @FXML
    Label numberTasks;

    public GraphicView() {

    }

    public void update() {
        listTasksVbox.getChildren().clear();

        numberTasks.setText("Number of tasks: " + model.getNumberTask());

        List<Task> tasks = model.getListTasks();
        for (Task task: tasks){
          //  listTasksVbox.getChildren().add();
        }
    }
}
