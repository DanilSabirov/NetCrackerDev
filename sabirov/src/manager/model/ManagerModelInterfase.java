package manager.model;

import manager.Observer;
import manager.task.Task;

import java.util.List;

public interface ManagerModelInterfase {
    void initialize();

    void addTask(Task task);

    void removeTask(int index);

    void editTask(int index, Task newTask);

    Task getTask(int index);

    int getNumberTask();

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void changeSorting(Sorting sorting);

    List getListTasks();

    void save();
}
