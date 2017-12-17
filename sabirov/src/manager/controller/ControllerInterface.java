package manager.controller;

import manager.model.Sorting;
import manager.task.Task;

public interface ControllerInterface {

    void addTask(Task task);

    void removeTask(int pos);

    void editTask(int pos, Task newTask);

    void changeSorting(Sorting sorting);

    void save();
}
