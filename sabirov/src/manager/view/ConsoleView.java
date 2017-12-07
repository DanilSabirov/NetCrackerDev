package manager.view;

import manager.task.Task;
import manager.controller.ControllerInterface;
import manager.model.ManagerModelInterfase;

import java.io.IOException;
import java.util.List;

public class ConsoleView extends BaseView {

    private String command;
    private final int WIDTH = 40;

    public ConsoleView() {

    }

    private void draw(){
        drawHead();
        drawAllTask(model.getListTasks());
        System.out.println("Number tasks: " + model.getNumberTask());
        printLine(WIDTH, '/');
        System.out.println('\n');
    }

    private void drawAllTask(List<Task> listTasks){
        for(int i = 0; i < listTasks.size(); i++){
            System.out.println("Num: " + (i + 1));
            drawTask(listTasks.get(i));
            printLine(WIDTH, '-');
            System.out.println();
        }
    }

    private void drawHead(){
        printLine(WIDTH, '#');
        System.out.println();
    }

    private void drawTask(Task task){
        System.out.println(task.getName());
        System.out.println();
        System.out.println(task.getDescription());
        System.out.println();
        System.out.println("End date: " + task.getEndTime());
        if(task.getDateCreation() != null){
            System.out.println("Created: " + task.getDateCreation());
        }
    }

    private void printLine(int len, char c){
        for(int i = 0; i < len; i++){
            System.out.print(c);
        }
    }

    public void update() {
        draw();
    }
}
