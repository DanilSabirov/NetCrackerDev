package manager.controller;

import manager.Task;
import manager.model.ManagerModelInterfase;
import manager.view.BaseView;

public class Controller implements ControllerInterface {

    private BaseView view;
    private ManagerModelInterfase model;

    public Controller(BaseView view, ManagerModelInterfase model) {
        this.view = view;
        this.model = model;
        model.initialize();
    }

    public void addTask(Task task) {
        model.addTask(task);
    }

    public void removeTask(Long id) {
        model.removeTask(id);
    }

    public void editTask(Long id, Task newTask) {
        model.editTask(id, newTask);
    }
}
