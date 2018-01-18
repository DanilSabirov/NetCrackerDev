package manager.controller;

import manager.model.ManagerModelInterface;
import manager.task.Task;

/**
 * Controller to add new task.
 */

public class AddController extends Editor{

    public AddController(ManagerModelInterface model) {
        super(model);
    }

    /**
     * Opens editor window.
     */
    public void addTask(){
        view.show("Add task");
    }

    /**
     * Saves new task.
     */
    public void save() {
        Task task = parseTask();
        model.addTask(task);
    }
}
