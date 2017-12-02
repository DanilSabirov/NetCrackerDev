package manager.view;

import manager.Task;
import manager.controller.ControllerInterface;
import manager.model.ManagerModelInterfase;

import java.io.IOException;
import java.util.List;

public class ConsoleView extends BaseView {

    private String command;
    private final int WIDTH = 40;

    public ConsoleView(ManagerModelInterfase model, ControllerInterface controller) {
        super(model, controller);
        model.registerObserver(this);
    }

    private void draw(){
        try {
            Runtime.getRuntime().exec("clear");
        } catch (IOException e) {
            e.printStackTrace();
        }
        drawHead();
        drawAllTask(model.getListTasks());
    }

    private void drawAllTask(List<Task> listTasks){
        for(Task t: listTasks){
            drawTask(t);
        }
    }

    private void drawHead(){
        System.out.println("|     Name       |       Description      |       End date    |");
    }

    private void drawTask(Task task){
        System.out.print("| " + task.getName() + " " + task.getDescription() + " ");
        if(task.getEndTime() == null){
            System.out.println("null");
        }
        else{
            System.out.println(task.getEndTime());
        }
    }

    private void printLine(int len){
        for(int i = 0; i < len; i++){
            System.out.print("-");
        }
    }

    public void update() {
        draw();
    }
}
