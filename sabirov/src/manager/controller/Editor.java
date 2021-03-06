package manager.controller;

import manager.model.ManagerModelInterface;
import manager.task.Task;
import manager.view.EditorView;

import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * Base task editor.
 */

public abstract class Editor {
    protected ManagerModelInterface model;

    protected EditorView view;

    public Editor(ManagerModelInterface model) {
        this.model = model;
        view = new EditorView(this);
    }

    /**
     * Generates task from editor view.
     * @return
     */
    protected Task parseTask(){
        Task task = new Task();

        task.setName(view.name.getText());
        task.setDescription(view.description.getText());
        if(view.endDate.getValue() != null){
            Calendar calendar = Calendar.getInstance();

            calendar.setTime(Date.from(view.endDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            calendar.set(Calendar.HOUR, view.hours.getValue());
            calendar.set(Calendar.MINUTE, view.minutes.getValue());

            task.setEndTime(calendar.getTime());
        }
        task.setPriority(view.priority.getValue());
        task.setColor(view.color.getValue());
        return task;
    }

    /**
     * Saves changes.
     */
    public abstract void save();
}
