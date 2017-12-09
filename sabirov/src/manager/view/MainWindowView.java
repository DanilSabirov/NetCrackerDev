package manager.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import manager.controller.ControllerInterface;
import manager.controller.TaskViewController;
import manager.model.ManagerModelInterfase;
import manager.task.Task;

import java.io.IOException;
import java.util.List;

public class MainWindowView extends BaseView {
    @FXML
    VBox listTasksVbox;

    @FXML
    Label numberTasks;

    private Parent root;
    private FXMLLoader fxmlLoader;

    public MainWindowView(ManagerModelInterfase model, ControllerInterface controller) {
        super(model, controller);
        fxmlLoader = new FXMLLoader(getClass().getResource("fxml/mainWindow.fxml"));
        fxmlLoader.setController(this);
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        update();
    }

    public void update() {
        listTasksVbox.getChildren().clear();

        numberTasks.setText("Number of tasks: " + model.getNumberTask());

        List<Task> tasks = model.getListTasks();
        for (int i = 0; i < tasks.size(); i++){
            listTasksVbox.getChildren().add(i, makeTask(i));
        }
    }

    private Parent makeTask(int index){
//        AnchorPane rootPane = new AnchorPane();
//        rootPane.setPadding(new Insets(5.0));
//        Button button = new Button("Task " + index);
//
//        AnchorPane.setBottomAnchor(button, 0.0);
//        AnchorPane.setTopAnchor(button, 0.0);
//        AnchorPane.setBottomAnchor(button, 0.0);
//        AnchorPane.setRightAnchor(button, 0.0);
//        AnchorPane.setLeftAnchor(button, 0.0);
//
//        rootPane.getChildren().add(button);
        TaskViewController taskController = new TaskViewController();
        taskController.setTask(model.getTask(index));
        return taskController.getViewRoot();
    }

    public Parent getRoot(){
        return root;
    }
}
