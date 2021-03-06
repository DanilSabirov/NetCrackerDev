package manager.controller;

import manager.model.ManagerModelInterface;
import manager.model.Sorting;
import manager.task.Task;
import manager.view.BaseView;
import manager.view.ConsoleView;

/**
 * Controller for console view.
 */

public class ConsoleController implements ControllerInterface {

    private BaseView view;
    private ManagerModelInterface model;

    public ConsoleController(ManagerModelInterface model) {
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
