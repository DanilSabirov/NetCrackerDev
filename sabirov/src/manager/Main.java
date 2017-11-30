package manager;

import manager.controller.Controller;
import manager.controller.ControllerInterface;
import manager.model.ManagerModel;
import manager.model.ManagerModelInterfase;
import manager.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        ManagerModelInterfase model = new ManagerModel();
        ControllerInterface controller = new Controller(model);

    }
}
