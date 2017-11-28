import java.util.List;

public interface ManagerModelInterfase {

    public void initialize();

    public void addTask();

    public void removeTask();

    public void editTask();

    public Task getTask();

    public void untitledMethod();

    public int getNumberTask();

    public void registerObserver();

    public void removeObserver();

    public void sortTasks();

    public List getListTasks();
}
