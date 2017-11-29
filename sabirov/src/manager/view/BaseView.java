package manager.view;

import manager.Observer;
import manager.controller.ControllerInterface;
import manager.model.ManagerModelInterfase;

public abstract class BaseView implements Observer {

    private ManagerModelInterfase model;

    private ControllerInterface controller;

    public abstract void update();
}
