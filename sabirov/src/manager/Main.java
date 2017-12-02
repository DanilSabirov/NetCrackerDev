package manager;

import manager.controller.Controller;
import manager.controller.ControllerInterface;
import manager.model.ManagerModel;
import manager.model.ManagerModelInterfase;
import manager.view.ConsoleView;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.awt.*;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ManagerModelInterfase model;
        Path path = Paths.get("save.xml");

        Loader loader = new XMLLoader();
        model = loader.load(path);

        ControllerInterface controller = new Controller(model);
/*
        Task t = new Task();
        t.setName("Name");
        t.setDescription("Desc");
        t.setEndTime(new Date());
        t.setColor(new Color(100, 155, 255));
        t.setPriority(7);

        Task t1 = new Task();
        t1.setName("Name1");
        t1.setDescription("Desc1");
        t1.setEndTime(new Date());
        t1.setColor(new Color(1, 15, 55));
        t1.setPriority(6);

        controller.addTask(t1);
        controller.addTask(t);
*/

     //   Saver saver = new XMLSaver();
     //   saver.save(path, model);


    }
}
