package manager.view;

import manager.Observer;
import manager.controller.ControllerInterface;
import manager.model.ManagerModelInterfase;

public abstract class BaseView implements Observer {

    protected ManagerModelInterfase model;
    protected ControllerInterface controller;

    public BaseView(ManagerModelInterfase model, ControllerInterface controller){
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
