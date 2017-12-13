package manager.controller;

import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import manager.model.ManagerModelInterfase;
import manager.task.Task;
import manager.view.TaskView;

public class TaskViewController {
    private TaskView view;
    private int pos;
    private ControllerInterface parentController;
    private ManagerModelInterfase model;

    public TaskViewController(int pos, ControllerInterface parentController, ManagerModelInterfase model) {
        view = new TaskView(this);
        this.pos = pos;
        this.model = model;
        if(parentController == null){
            throw new NullPointerException();
        }
        this.parentController = parentController;
    }

    public void setTask(Task task){
        view.setName(task.getName());
        view.setDescription(task.getDescription());
        if(task.getEndTime() != null){
            view.setEndTime(task.getEndTime().toString());
        }
        view.setDateCreation(task.getDateCreation().toString());
        view.setPriority(Integer.toString(task.getPriority()));
    }

    public Parent getViewRoot(){
        return view.getRoot();
    }

    public void removeTask() {
        parentController.removeTask(pos);
    }

    public void editTask() {
        EditorController editor = new EditorController(model, pos);
        editor.editTask();
    }
}
