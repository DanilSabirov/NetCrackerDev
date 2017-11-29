package manager.model;

import manager.Observer;
import manager.Sorting;
import manager.Task;

import java.util.List;

public interface ManagerModelInterfase {
    public void initialize();

    public void addTask(Task task);

    public void removeTask(long id);

    public void editTask(long id, Task newTask);

    public Task getTask(long id);

    public int getNumberTask();

    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void changeSorting(Sorting sorting);

    public List getListTasks();
}
