package manager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import manager.controller.ConsoleController;
import manager.controller.ControllerInterface;
import manager.controller.MainWindowController;
import manager.loader.Loader;
import manager.loader.XMLLoader;
import manager.model.ManagerModelInterfase;
import manager.task.Task;

import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;

public class Main extends Application{
    private static ManagerModelInterfase model;
    public static Path pathModel = Paths.get("save.xml");

    public static void main(String[] args) {
      //  args = new String[1];
      //  args[0] = "-c";
        if (args.length == 0){
            launch(args);
        }
        else if (args[0].equals("-c")  || args[0].equals("--console")){
            startConsole();
        }
        Runtime.getRuntime().exit(0);
    }

    private static void startConsole() {
        loadModel();
        ControllerInterface controller = new ConsoleController(model);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        loadModel();
        MainWindowController controller = new MainWindowController(model);

        primaryStage.setTitle("Task manager");
        primaryStage.setScene(new Scene(controller.getViewRoot()));
        primaryStage.show();
    }

    private static void loadModel(){
        Loader loader = new XMLLoader();
        model = loader.load(pathModel);
    }

    private void addTestTasks(ControllerInterface controller){
        Calendar cal = Calendar.getInstance();

        Task t1 = new Task();
        t1.setName("Dev_1");
        t1.setDescription("TaskManager");
        cal.set(2017, 11, 30);
        t1.setEndTime(cal.getTime());
        t1.setColor(new Color(255, 0, 0));
        t1.setPriority(10);

        Task t2 = new Task();
        t2.setName("SQL_6");
        t2.setDescription("Operator WITH");
        cal.set(2017, 12, 7);
        t2.setEndTime(cal.getTime());
        t2.setColor(new Color(10, 150, 55));
        t2.setPriority(6);

        Task t3 = new Task();
        t3.setName("SQL_7");
        t3.setDescription("EAV");
        cal.set(2017, 12, 14);
        t3.setEndTime(cal.getTime());
        t3.setColor(new Color(10, 150, 55));
        t3.setPriority(6);

        Task t4 = new Task();
        t4.setName("Java 7");
        t4.setDescription("Thread");
        cal.set(2017, 12, 14);
        t4.setEndTime(cal.getTime());
        t4.setColor(new Color(100, 150, 205));
        t4.setPriority(6);

        Task t5 = new Task();
        t5.setName("SQL_8");
        t5.setDescription("Analytics functions in oracle");
        cal.set(2017, 12, 21);
        t5.setEndTime(cal.getTime());
        t5.setColor(new Color(10, 150, 55));
        t5.setPriority(6);

        Task t6 = new Task();
        t6.setName("dev");
        t6.setDescription("Server");
        cal.set(2017, 12, 30);
        t6.setEndTime(cal.getTime());
        t6.setColor(new Color(255, 0, 0));
        t6.setPriority(6);

        controller.addTask(t1);
        controller.addTask(t2);
        controller.addTask(t3);
        controller.addTask(t4);
        controller.addTask(t5);
        controller.addTask(t6);
    }


}
