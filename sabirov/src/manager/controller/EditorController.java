package manager.controller;

import manager.model.ManagerModelInterfase;
import manager.task.Task;
import manager.view.EditorView;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class EditorController extends Editor{
    private int indexTask;

    public EditorController(ManagerModelInterfase model, int indexTask) {
        super(model);
        this.indexTask = indexTask;
    }

    public void editTask(){
        fillView(indexTask);
        view.show("Edit task");
    }

    private void fillView(int indexTask){
        Task task = model.getTask(indexTask);

        view.name.setText(task.getName());
        view.description.setText(task.getDescription());
        view.endDate.setValue(task.getEndTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        view.priority.getSelectionModel().select(task.getPriority());
        view.color.setValue(task.getColor());
    }

    @Override
    public void save() {
        Task task = parseTask();
        model.editTask(indexTask, task);
        model.save();
    }
}
