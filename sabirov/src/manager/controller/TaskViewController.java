package manager.controller;

import javafx.scene.Parent;
import manager.task.Task;
import manager.view.TaskView;

public class TaskViewController {
    private TaskView view;

    public TaskViewController() {
        view = new TaskView(this);
    }

    public void setTask(Task task){
        view.setName(task.getName());
        view.setDescription(task.getDescription());
        view.setEndTime(task.getEndTime().toString());
        view.setDateCreation(task.getDateCreation().toString());
        view.setPriority(Integer.toString(task.getPriority()));
    }

    public Parent getViewRoot(){
        return view.getRoot();
    }
}
