public abstract class BaseView implements Observer {

    private ManagerModelInterfase model;

    private ControllerInterface controller;

    public abstract void update();
}
