package manager.controller;

import javafx.scene.Parent;
import manager.model.Sorting;
import manager.task.Task;
import manager.model.ManagerModelInterfase;
import manager.view.MainWindowView;

public class MainWindowController implements ControllerInterface {

    private ManagerModelInterfase model;
    private MainWindowView view;

    public MainWindowController(ManagerModelInterfase model) {
        this.model = model;
        this.view = new MainWindowView(model, this);
    }

    @Override
    public void addTask(Task task) {
        model.addTask(task);
    }

    @Override
    public void removeTask(int pos) {

    }

    @Override
    public void editTask(int pos, Task newTask) {

    }

    @Override
    public void changeSorting(Sorting sorting) {

    }

    @Override
    public void save() {
        model.save();
    }

    public Parent getViewRoot(){
        return view.getRoot();
    }

}
