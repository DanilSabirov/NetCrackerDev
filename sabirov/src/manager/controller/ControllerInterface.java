package manager.controller;

import manager.model.Sorting;
import manager.task.Task;

public interface ControllerInterface {

    public void addTask(Task task);

    public void removeTask(int pos);

    public void editTask(int pos, Task newTask);

    public void changeSorting(Sorting sorting);
}
