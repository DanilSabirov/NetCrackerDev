package manager.controller;

import manager.Task;

public interface ControllerInterface {

    public void addTask(Task task);

    public void removeTask(Long id);

    public void editTask(Long id, Task newTask);
}
