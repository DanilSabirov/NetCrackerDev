package manager.controller;

import manager.Task;
import manager.model.ManagerModelInterfase;
import manager.view.BaseView;
import manager.view.ConsoleView;

public class Controller implements ControllerInterface {

    private BaseView view;
    private ManagerModelInterfase model;

    public Controller(ManagerModelInterfase model) {
        this.view = new ConsoleView(model, this);
        this.model = model;
        model.initialize();
    }

    public void addTask(Task task) {
        model.addTask(task);
    }

    public void removeTask(int pos) {
        model.removeTask(pos);
    }

    public void editTask(int pos, Task newTask) {
        model.editTask(pos, newTask);
    }
}
