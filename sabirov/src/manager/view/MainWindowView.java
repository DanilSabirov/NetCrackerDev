package manager.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import manager.controller.ControllerInterface;
import manager.controller.TaskViewController;
import manager.model.ManagerModelInterface;
import manager.model.Sorting;
import manager.task.Task;

import java.io.IOException;
import java.util.List;

/**
 * Main window.
 */

public class MainWindowView extends BaseView {
    @FXML
    private VBox listTasksVbox;

    @FXML
    private Label numberTasks;

    @FXML
    private Button add;

    @FXML
    private ChoiceBox<Sorting> sorting;

    @FXML
    private FXMLLoader fxmlLoader;

    private Parent root;

    public MainWindowView(ManagerModelInterface model, ControllerInterface controller) {
        super(model, controller);
        fxmlLoader = new FXMLLoader(getClass().getResource("fxml/mainWindow.fxml"));
        fxmlLoader.setController(this);
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        initSorting();
        update();
    }

    private void initSorting(){
        final Sorting firtSort = Sorting.REVERSEDATECREATED;

        sorting.setItems(FXCollections.observableArrayList(Sorting.values()));
        sorting.getSelectionModel().select(Sorting.valueOf(firtSort.toString()));

        sorting.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                Sorting sorting = Sorting.values()[newValue.intValue()];
                changeSorting(sorting);
            }
        });
    }

    public void update() {
        listTasksVbox.getChildren().clear();
        numberTasks.setText("Number of tasks: " + model.getNumberTask());

        List<Task> tasks = model.getListTasks();
        for (int i = 0; i < tasks.size(); i++){
            listTasksVbox.getChildren().add(i, makeTask(i));
        }
    }

    private void changeSorting(Sorting sorting){
        controller.changeSorting(sorting);
    }

    private Parent makeTask(int index){
        TaskViewController taskController = new TaskViewController(index, controller, model);
        taskController.setTask(model.getTask(index));
        return taskController.getViewRoot();
    }

    /**
     * Returns main window.
     * @return
     */
    public Parent getRoot(){
        return root;
    }

    @FXML
    private void onClickAdd(ActionEvent actionEvent){
        Task newTask = new Task();
        controller.addTask(newTask);
    }


}
