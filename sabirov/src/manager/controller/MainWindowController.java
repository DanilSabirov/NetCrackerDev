package manager.controller;

import manager.Main;
import manager.task.Task;
import manager.model.ManagerModelInterfase;
import manager.view.BaseView;

public class MainWindowController implements ControllerInterface {

    private ManagerModelInterfase model;
    private BaseView view;

    public MainWindowController(ManagerModelInterfase model) {
        this.view = Main.loaderFXML.getController();
        this.model = model;

        this.view.initialize(this.model, this);
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
}
