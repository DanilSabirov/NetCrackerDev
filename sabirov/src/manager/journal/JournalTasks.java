package manager.journal;

import manager.task.Task;

import java.util.List;

/**
 * This interface defines a functions journal.
 */

public interface JournalTasks {
    /**
     * Saves a list of tasks.
     * @param taskList
     */
    void saveAllTasks(List<Task> taskList);

    /**
     * Loads a list of tasks.
     * @return a list of tasks.
     */
    List<Task> loadAllTasks();
}
