package manager.view;

import manager.Observer;
import manager.controller.ControllerInterface;
import manager.model.ManagerModelInterface;

/**
 * Base view.
 */

public abstract class BaseView implements Observer {

    protected ManagerModelInterface model;
    protected ControllerInterface controller;

    public BaseView(ManagerModelInterface model, ControllerInterface controller){
        if (model != null && controller != null){
            this.model = model;
            this.controller = controller;
            model.registerObserver(this);
        }
        else {
            throw new NullPointerException();
        }
    }

    public abstract void update();
}
