package manager.view;

import manager.model.Sorting;
import manager.task.StatusTask;
import manager.task.Task;
import manager.controller.ControllerInterface;
import manager.model.ManagerModelInterfase;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleView extends BaseView {

    private String command;
    private final int WIDTH = 40;
    private Scanner in;

    public ConsoleView() {
        in = new Scanner(System.in);
    }

    private void draw(){
        drawHead();
        drawAllTask(model.getListTasks());
        System.out.println("Number tasks: " + model.getNumberTask());
        printLine(WIDTH, '=');
        System.out.println();
        waitCommand();
    }

    private void waitCommand(){
        System.out.println("1 - Add new task | 2 - Remove task | 3 - Change sorting");
        String command;
        do {
            command = in.next();
            switch (command){
                case "1":
                    drawAddTask();
                    break;
                case "2":
                    drawRemoveTask();
                    break;
                case "3":
                    drawChangeSorting();
                    break;
            }
        }while (!command.equals("1") && !command.equals("2"));
    }

    private void drawAddTask(){
        printLine(WIDTH, '=');
        System.out.println();
        System.out.println("New task");
        printLine(WIDTH, '=');
        System.out.println();

        Task newTask = new Task();
        System.out.println("Name: ");
        newTask.setName(in.nextLine());
        newTask.setName(in.nextLine());
        System.out.println("Description: ");
        newTask.setDescription(in.nextLine());

        getDate();

        int priority;
        do{
            System.out.print("Priority: (0 - 10) ");
            priority = in.nextInt();
        }while (!(0 <= priority && priority <= 10));
        newTask.setPriority(priority);

        String isOk;
        System.out.print("Save? (Y, N) ");
        do{
            isOk = in.next();
        }while (!isOk.equals("Y") && !isOk.equals("N"));

        if (isOk.equals("Y")) {
            controller.addTask(newTask);
        }
    }

    private Date getDate(){
        Calendar cal = Calendar.getInstance();
        Pattern pattern = Pattern.compile("(19|20)\\d\\d-((0[1-9]|1[012])-(0[1-9]|[12]\\d)|(0[13-9]|1[012])-30|(0[13578]|1[02])-31)");
        Matcher matcher;
        String date;
        do{
            System.out.print("End date (YYYY-MM-dd) ");
            date = in.nextLine();
            matcher = pattern.matcher(date);
        }while (!matcher.matches());
        matcher.reset();
        cal.set(Integer.parseInt(date.substring(0, 4)),
                Integer.parseInt(date.substring(5, 7)),
                Integer.parseInt(date.substring(8, 10)));
        return cal.getTime();
    }

    private void drawRemoveTask(){
        System.out.print("Num: ");
        int index = in.nextInt();
        try {
            drawTask(model.getTask(index - 1));
        }
        catch (IllegalArgumentException e){
            System.out.println(e.toString());
            return;
        }

        String isOk;
        System.out.println("Remove? (Y, N) ");
        do{
            isOk = in.next();
        }while (!isOk.equals("Y") && !isOk.equals("N"));

        if(isOk.equals("Y")){
            controller.removeTask(index);
        }
    }

    private void drawChangeSorting(){
        int len = Sorting.values().length;
        for (int i = 0; i < len; i++){
            System.out.println((i + 1) + " - " + Sorting.values()[i]);
        }
        int v;
        do{
            v = in.nextInt();
        }while (!(1 <= v && v <= len));
        controller.changeSorting(Sorting.values()[v - 1]);
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
        printLine(WIDTH, '=');
        System.out.println();
    }

    private void drawTask(Task task){
        System.out.println(task.getName());
        System.out.println();
        System.out.println(task.getDescription());
        System.out.println();
        if(task.getEndTime() != null){
            System.out.println("End date: " + task.getEndTime());
        }
        System.out.println("Created: " + task.getDateCreation());

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
