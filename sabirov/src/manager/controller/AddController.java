package manager.controller;

import manager.model.ManagerModel;
import manager.model.ManagerModelInterfase;
import manager.task.Task;
import manager.view.EditorView;

import java.time.ZoneId;
import java.util.Date;

public class AddController extends Editor{

    public AddController(ManagerModelInterfase model) {
        super(model);
    }

    public void addTask(){
        view.show("Add task");
    }


    public void save() {
        Task task = parseTask();
        model.addTask(task);
    }
}
