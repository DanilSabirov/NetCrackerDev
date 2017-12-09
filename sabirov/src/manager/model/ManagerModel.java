package manager.model;

import manager.Main;
import manager.Observer;
import manager.saver.Saver;
import manager.saver.XMLSaver;
import manager.task.Task;

import javax.xml.bind.annotation.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

@XmlRootElement(name = "model")
@XmlAccessorType(XmlAccessType.NONE)
public class ManagerModel implements ManagerModelInterfase {

    @XmlElement(name = "task")
    @XmlElementWrapper(name = "listTasks")
    private List<Task> sortedListTasks;

    private CopyOnWriteArrayList<Observer> observers;

    private Sorting sorting = Sorting.NAME;

    public ManagerModel() {
        observers = new CopyOnWriteArrayList<>();
        sortedListTasks = new ArrayList<>();
    }

    private void notifySubscriber(){
        for(Observer o: observers){
            o.update();
        }
    }

    @Override
    public void initialize() {

    }

    @Override
    public void addTask(Task task) {
        sortedListTasks.add(task);
        sortList();
        notifySubscriber();
    }

    @Override
    public void removeTask(int index){
        if(0 <= index && index < sortedListTasks.size()){
            sortedListTasks.remove(index);
        }
        else{
            throw new IllegalArgumentException("Illegal index");
        }
        notifySubscriber();
    }

    @Override
    public void editTask(int index, Task newTask) {
        if (0 <= index && index < sortedListTasks.size()){
            sortedListTasks.set(index, newTask);
        }
        else {
            throw new IllegalArgumentException("Illegal pos");
        }
        sortList();
        notifySubscriber();
    }

    @Override
    public Task getTask(int index) {
        if(0 <= index && index <= sortedListTasks.size()){
            try {
                return sortedListTasks.get(index).clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        throw new IllegalArgumentException("task not found");
    }

    @Override
    public int getNumberTask(){
        return sortedListTasks.size();
    }

    @Override
    public void registerObserver(Observer observer) {
        if (observers.indexOf(observer) == -1){
            observers.add(observer);
        }
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

    @Override
    public List<Task> getListTasks() {
        return sortedListTasks;
    }

    @Override
    public void save() {
        Saver saver = new XMLSaver();
        saver.save(Main.pathModel, this);
    }
}
