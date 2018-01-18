package manager.controller;

import javafx.scene.Parent;
import manager.model.ManagerModelInterface;
import manager.model.Sorting;
import manager.task.Task;
import manager.view.MainWindowView;

/**
 * Controller for graphic view.
 */

public class MainWindowController implements ControllerInterface {

    private ManagerModelInterface model;
    private MainWindowView view;

    public MainWindowController(ManagerModelInterface model) {
        this.model = model;
        this.view = new MainWindowView(model, this);
    }

    @Override
    public void addTask(Task task) {
        AddController addController = new AddController(model);
        addController.addTask();
    }

    @Override
    public void removeTask(int pos) {
        model.removeTask(pos);
    }

    @Override
    public void editTask(int pos, Task newTask) {

    }

    @Override
    public void changeSorting(Sorting sorting) {
        model.changeSorting(sorting);
    }

    @Override
    public void save() {
        model.save();
    }

    /**
     * Returns main window.
     * @return main window.
     */
    public Parent getViewRoot(){
        return view.getRoot();
    }

}
