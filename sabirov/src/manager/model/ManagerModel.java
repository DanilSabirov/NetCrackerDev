package manager.model;

import manager.Observer;
import manager.Sorting;
import manager.Task;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ManagerModel implements ManagerModelInterfase {

    private Map<Long , Task> tasks;
    private List<Task> sortedListTasks;
    private CopyOnWriteArrayList<Observer> observers;
    private Sorting sorting = Sorting.NAME;
    private Random sequenceId = new Random(System.currentTimeMillis());

    public ManagerModel() {
        tasks = new TreeMap<>();
        observers = new CopyOnWriteArrayList<>();
        sortedListTasks = new ArrayList<>();
    }

    private void notifySubscriber(){
        for(Observer o: observers){
            o.update();
        }
    }

    private long nextId(){
        long newId ;
        do{
            newId = sequenceId.nextLong();
        }
        while (!tasks.containsKey(newId));
        return newId;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void addTask(Task task) {
        tasks.put(/*nextId()*/ 0l, task);
        updateList();
        notifySubscriber();
    }

    @Override
    public void removeTask(long id){
        if(tasks.remove(id) == null){
            throw new IllegalArgumentException("task not found");
        }
        updateList();
        notifySubscriber();
    }

    @Override
    public void editTask(long id, Task newTask) {
        Task tmp = tasks.get(id);
        if(tmp != null){
            tmp = newTask;
        }
        else {
            throw new IllegalArgumentException("task not found");
        }
        updateList();
        notifySubscriber();
    }

    @Override
    public Task getTask(long id) {
        Task tmp = tasks.get(id);
        if(tmp != null){
            try {
                return tmp.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        throw new IllegalArgumentException("task not found");
    }

    @Override
    public int getNumberTask(){
        return tasks.size();
    }

    @Override
    public void registerObserver(Observer observer) {
        if (observers.indexOf(observer) == -1){
            observers.add(observer);
        }
        notifySubscriber();
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void changeSorting(Sorting sorting) {
        this.sorting = sorting;
        sortList();
        notifySubscriber();
    }

    private void sortList(){
        switch (sorting){
            case NAME:
                Collections.sort(sortedListTasks, Task.Comparators.NAME);
                break;
            case REVERSENAME:
                Collections.sort(sortedListTasks, Task.Comparators.REVERSENAME);
                break;
            case DATECREATED:
                Collections.sort(sortedListTasks, Task.Comparators.DATECREATED);
                break;
            case REVERSEDATECREATED:
                Collections.sort(sortedListTasks, Task.Comparators.REVERSEDATECREATED);
                break;
            case ENDDATE:
                Collections.sort(sortedListTasks, Task.Comparators.ENDDATE);
                break;
            case REVERSEENDDATE:
                Collections.sort(sortedListTasks, Task.Comparators.REVERSEENDDATE);
                break;
            default:
                throw new UnsupportedOperationException();
        }
    }

    private void updateList(){
        List<Task> newList = new ArrayList<>();
        newList.addAll(tasks.values());
        sortedListTasks = newList;
        sortList();
    }

    @Override
    public List getListTasks() {
        return sortedListTasks;
    }
}
