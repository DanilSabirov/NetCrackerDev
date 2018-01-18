package manager.controller;

import manager.model.ManagerModelInterface;
import manager.task.Task;

import java.time.ZoneId;
import java.util.Calendar;

/**
 * Controller for task editing.
 */

public class EditorController extends Editor{
    private int indexTask;

    /**
     * Create editor view for task.
     */

    public EditorController(ManagerModelInterface model, int indexTask) {
        super(model);
        this.indexTask = indexTask;
    }

    /**
     * Opens editor window.
     */
    public void editTask(){
        fillView(indexTask);
        view.show("Edit task");
    }

    /**
     * Fill edit view field.
     */
    private void fillView(int indexTask){
        Task task = model.getTask(indexTask);

        view.name.setText(task.getName());
        view.description.setText(task.getDescription());
        view.priority.getSelectionModel().select(task.getPriority());
        view.color.setValue(task.getColor());
        if (task.getEndTime() != null){
            view.endDate.setValue(task.getEndTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(task.getEndTime());

            view.hours.getSelectionModel().select(calendar.get(Calendar.HOUR));
            view.minutes.getSelectionModel().select(calendar.get(Calendar.MINUTE));
        }
    }

    @Override
    public void save() {
        Task task = parseTask();
        model.editTask(indexTask, task);
    }
}
