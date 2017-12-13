package manager.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import manager.controller.TaskViewController;
import manager.task.Task;

import java.io.IOException;
import java.util.Random;

public class TaskView {
    @FXML
    private Label name;

    @FXML
    private Label description;

    @FXML
    private Label endTime;

    @FXML
    private Label dateCreation;

    @FXML
    private Label priority;

    @FXML
    private MenuItem editItem;

    @FXML
    private MenuItem deleteItem;

    Parent root;

    private FXMLLoader fxmlLoader;

    private TaskViewController controller;

    public TaskView(TaskViewController controller) {
        fxmlLoader = new  FXMLLoader(getClass().getResource("fxml/taskView.fxml"));
        fxmlLoader.setController(this);
        this.controller = controller;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public void setDescription(String description) {
        this.description.setText(description);
    }

    public void setEndTime(String endTime) {
        this.endTime.setText(endTime);
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation.setText(dateCreation);
    }

    public void setPriority(String priority) {
        this.priority.setText(priority);
    }

    public Parent getRoot() {
        return root;
    }

    @FXML
    private void onClickEdit(){
        controller.editTask();
    }

    @FXML
    private void onClickDelete(ActionEvent actionEvent) {
        controller.removeTask();
    }
}
