package manager.controller;

import manager.model.Sorting;
import manager.task.Task;

/**
 * Interface control model.
 */

public interface ControllerInterface {

    /**
     * Adds a new task.
     * @param task new task
     */
    void addTask(Task task);

    /**
     * Removes the task at the specified position in list.
     * @param pos position in a list.
     */
    void removeTask(int pos);

    /**
     * Replaces the task at the specified position in list.
     * @param pos position in a journal.
     * @param newTask new task
     */
    void editTask(int pos, Task newTask);

    /**
     * Changes sorting order.
     * @param sorting
     */
    void changeSorting(Sorting sorting);

    /**
     * Saves tasks.
     */
    void save();
}
