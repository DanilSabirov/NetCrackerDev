package manager.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import manager.controller.TaskViewController;

import java.io.IOException;

/**
 * Task view.
 */

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

    /**
     * Sets name label.
     */
    public void setName(String name) {
        this.name.setText(name);
    }

    /**
     * Sets description label.
     */
    public void setDescription(String description) {
        this.description.setText(description);
    }

    /**
     * Sets end time label.
     */
    public void setEndTime(String endTime) {
        this.endTime.setText(endTime);
    }

    /**
     * Sets date creation label.
     */
    public void setDateCreation(String dateCreation) {
        this.dateCreation.setText(dateCreation);
    }

    /**
     * Sets priority label.
     */
    public void setPriority(String priority) {
        this.priority.setText(priority);
    }

    /**
     * Returns root view.
     * @return root view.
     */
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
