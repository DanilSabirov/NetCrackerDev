package manager.controller;

import javafx.scene.Parent;
import manager.model.ManagerModelInterface;
import manager.task.Task;
import manager.view.TaskView;

/**
 * Controller for task display.
 */

public class TaskViewController {
    private TaskView view;
    private int pos;
    private ControllerInterface parentController;
    private ManagerModelInterface model;

    public TaskViewController(int pos, ControllerInterface parentController, ManagerModelInterface model) {
        view = new TaskView(this);
        this.pos = pos;
        this.model = model;
        if(parentController == null){
            throw new NullPointerException();
        }
        this.parentController = parentController;
    }

    /**
     * Sets value for labels.
     */

    public void setTask(Task task){
        view.setName(task.getName());
        view.setDescription(task.getDescription());
        if(task.getEndTime() != null){
            view.setEndTime(task.getEndTime().toString());
        }
        view.setDateCreation(task.getDateCreation().toString());
        view.setPriority(Integer.toString(task.getPriority()));
    }

    /**
     * Returns root task view.
     * @return root task view.
     */
    public Parent getViewRoot(){
        return view.getRoot();
    }

    /**
     * Removes task.
     */
    public void removeTask() {
        parentController.removeTask(pos);
    }

    /**
     * Replaces task.
     */
    public void editTask() {
        EditorController editor = new EditorController(model, pos);
        editor.editTask();
    }
}
