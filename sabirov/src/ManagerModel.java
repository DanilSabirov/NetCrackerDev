import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ManagerModel implements ManagerModelInterfase {

    private ArrayList<Task> tasks;
    private CopyOnWriteArrayList<Observer> observers;

    @Override
    public void initialize() {

    }

    @Override
    public void addTask() {

    }

    @Override
    public void removeTask() {

    }

    @Override
    public void editTask() {

    }

    @Override
    public Task getTask() {
        return null;
    }

    @Override
    public void untitledMethod() {

    }

    @Override
    public int getNumberTask() {
        return 0;
    }

    @Override
    public void registerObserver() {

    }

    @Override
    public void removeObserver() {

    }

    @Override
    public void sortTasks() {

    }

    @Override
    public List getListTasks() {
        return null;
    }
}
