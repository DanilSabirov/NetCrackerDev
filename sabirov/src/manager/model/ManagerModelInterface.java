package manager.model;

import manager.Observer;
import manager.task.Task;

import java.util.List;

/**
 * This interface defines task management model.
 */

public interface ManagerModelInterface {
    /**
     * Initials the model.
     */
    void initialize();

    /**
     * Adds a new task to the journal.
     * @param task new task
     */
    void addTask(Task task);

    /**
     * Removes the task at the specified position in journal.
     * @param index position in a journal.
     */
    void removeTask(int index);

    /**
     * Replaces the task at the specified position in journal.
     * @param index position in a journal.
     * @param newTask new task
     */
    void editTask(int index, Task newTask);

    /**
     * Returns the task at the specified position in journal.
     * @param index
     * @return the task at the specified position
     */
    Task getTask(int index);

    /**
     * Returns number of tasks.
     * @return number of tasks.
     */
    int getNumberTask();

    /**
     * Adds new Observer.
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     * Removes the observer.
     * @param observer
     */
    void removeObserver(Observer observer);

    /**
     * Changes sorting order.
     * @param sorting
     */
    void changeSorting(Sorting sorting);

    /**
     * Returns list of task.
     * @return list of task.
     */
    List getListTasks();

    /**
     * Saves tasks in journal.
     */
    void save();
}
