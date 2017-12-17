package manager.journal;

import manager.task.Task;

import java.util.List;

public interface JournalTasks {
    void saveAllTasks(List<Task> taskList);

    List<Task> loadAllTasks();
}
