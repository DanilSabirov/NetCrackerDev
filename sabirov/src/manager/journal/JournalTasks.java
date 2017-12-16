package manager.journal;

import manager.task.Task;

import java.util.List;

public interface JournalTasks {
    public void saveAllTasks(List<Task> taskList);

    public List<Task> loadAllTasks();
}
