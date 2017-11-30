package manager.model;

import manager.Observer;
import manager.Sorting;
import manager.Task;

import java.util.List;

public interface ManagerModelInterfase {
    public void initialize();

    public void addTask(Task task);

    public void removeTask(int index);

    public void editTask(int index, Task newTask);

    public Task getTask(int index);

    public int getNumberTask();

    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void changeSorting(Sorting sorting);

    public List getListTasks();
}
