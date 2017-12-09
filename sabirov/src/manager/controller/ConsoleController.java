package manager.controller;

import manager.model.Sorting;
import manager.task.Task;
import manager.model.ManagerModelInterfase;
import manager.view.BaseView;
import manager.view.ConsoleView;

public class ConsoleController implements ControllerInterface {

    private BaseView view;
    private ManagerModelInterfase model;

    public ConsoleController(ManagerModelInterfase model) {
        this.model = model;
        this.view = new ConsoleView(model, this);
    }

    @Override
    public void addTask(Task task) {
        if (task.getName() == null && task.getDescription() == null){
            System.out.println("Task not added");
        }
        else {
            model.addTask(task);
        }
    }

    @Override
    public void removeTask(int pos) {
        model.removeTask(pos);
    }

    @Override
    public void editTask(int pos, Task newTask) {
        model.editTask(pos, newTask);
    }

    @Override
    public void changeSorting(Sorting sorting) {
        model.changeSorting(sorting);
    }

    @Override
    public void save() {
        model.save();
    }
}
