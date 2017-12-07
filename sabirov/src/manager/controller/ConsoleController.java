package manager.controller;

import manager.task.Task;
import manager.model.ManagerModelInterfase;
import manager.view.BaseView;
import manager.view.ConsoleView;

public class ConsoleController implements ControllerInterface {

    private BaseView view;
    private ManagerModelInterfase model;

    public ConsoleController(ManagerModelInterfase model) {
        this.view = new ConsoleView();
        this.model = model;

        this.view.initialize(this.model, this);
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
