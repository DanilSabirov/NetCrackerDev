package manager.controller;

import manager.model.ManagerModelInterfase;
import manager.task.Task;
import manager.view.EditorView;

import java.time.ZoneId;
import java.util.Date;

public abstract class Editor {
    protected ManagerModelInterfase model;

    protected EditorView view;

    public Editor(ManagerModelInterfase model) {
        this.model = model;
        view = new EditorView(this);
    }

    protected Task parseTask(){
        Task task = new Task();

        task.setName(view.name.getText());
        task.setDescription(view.description.getText());
        if(view.endDate.getValue() != null){
            task.setEndTime(Date.from(view.endDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        }
        task.setPriority(view.priority.getValue());
        task.setColor(view.color.getValue());
        return task;
    }

    public abstract void save();
}
