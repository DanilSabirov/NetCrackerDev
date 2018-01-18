package manager.model;

import manager.DialogNotification;
import manager.Main;
import manager.Observer;
import manager.journal.JournalTasks;
import manager.journal.XMLJournalTasks;
import manager.journal.saver.Saver;
import manager.journal.saver.XMLSaver;
import manager.task.Task;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ManagerModel implements ManagerModelInterface {
    private JournalTasks journal;

    private List<Task> sortedListTasks;

    private CopyOnWriteArrayList<Observer> observers;

    private Sorting sorting = Sorting.NAME;

    private List<Timer> timers;

    public ManagerModel(JournalTasks journal) {
        this.journal = journal;
        initialize();
    }

    private void notifySubscriber(){
        for(Observer o: observers){
            o.update();
        }
        updateNotifications();
    }

    @Override
    public void initialize() {
        sortedListTasks = journal.loadAllTasks();
        timers = new ArrayList<>();
        observers = new CopyOnWriteArrayList<>();
    }

    private void updateNotifications(){
        clearTimers();
        for(Task task: sortedListTasks){
            Date endTime = task.getEndTime();
            if(endTime != null && endTime.compareTo(new Date()) == 1){
                DialogNotification dialog = new DialogNotification(task);
                Timer timer = new Timer(true);

                timer.schedule(dialog, endTime);

                timers.add(timer);
            }
        }
    }

    private void clearTimers(){
        for (Timer timer: timers){
            timer.cancel();
        }
        timers.clear();
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
            case PRIORITY:
                Collections.sort(sortedListTasks, Task.Comparators.PRIORITY);
                break;
            case REVERSEPRIORITY:
                Collections.sort(sortedListTasks, Task.Comparators.REVERSEPRIORITY);
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
        saver.save(Main.pathJournal, (XMLJournalTasks) journal);
    }
}
