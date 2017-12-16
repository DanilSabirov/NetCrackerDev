package manager.task;

import javafx.scene.paint.Color;

import javax.xml.bind.annotation.*;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"name", "description", "dateCreation", "endTime", "status", "priority"/*, "color"*/})
public class Task implements Cloneable{
    @XmlElement(required = true)
    private String name;

    @XmlElement
    private String description;

    @XmlElement(required = true)
    private int priority = 5;

 //   @XmlElement
    private Color color = Color.WHITE;

    @XmlElement(required = true)
    private Date dateCreation;

    @XmlElement
    private Date endTime = null;

    @XmlElement(required = true)
    private StatusTask status = StatusTask.IN_PROGRESS;

    public Task() {
        dateCreation = new Date();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public Color getColor() {
        return color;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public Date getEndTime() {
        return endTime;
    }

    public StatusTask getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(int priority) {
        if(0 <= priority && priority <= 10){
            this.priority = priority;
        }
        else {
            throw new IllegalArgumentException("incorrect priority");
        }
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setEndTime(Date date) {
        endTime = date;
    }

    @Override
    public Task clone() throws CloneNotSupportedException {
        return (Task) super.clone();
    }

    public static class Comparators{
        public static Comparator<Task> NAME = new Comparator<Task>(){
            @Override
            public int compare(Task o1, Task o2) {
                if(o1.getName() == null){
                    return -1;
                }
                if(o2.getName() == null){
                    return 1;
                }
                return o1.getName().compareTo(o2.getName());
            }
        };

        public static Comparator<Task> REVERSENAME = new Comparator<Task>(){
            @Override
            public int compare(Task o1, Task o2) {
                if(o1.getName() == null){
                    return 1;
                }
                if(o2.getName() == null){
                    return -1;
                }
                return o2.getName().compareTo(o1.getName());
            }
        };

        public static Comparator<Task> DATECREATED = new Comparator<Task>(){
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getDateCreation().compareTo(o2.getDateCreation());
            }
        };

        public static Comparator<Task> REVERSEDATECREATED = new Comparator<Task>(){
            @Override
            public int compare(Task o1, Task o2) {
                return o2.getDateCreation().compareTo(o1.getDateCreation());
            }
        };

        public static Comparator<Task> ENDDATE = new Comparator<Task>(){
            @Override
            public int compare(Task o1, Task o2) {
                if(o1.getEndTime() == null){
                    return -1;
                }
                if(o2.getEndTime() == null){
                    return 1;
                }
                return o1.getEndTime().compareTo(o2.getEndTime());
            }
        };

        public static Comparator<Task> REVERSEENDDATE = new Comparator<Task>(){
            @Override
            public int compare(Task o1, Task o2) {
                if(o1.getEndTime() == null){
                    return 1;
                }
                if(o2.getEndTime() == null){
                    return -1;
                }
                return o2.getEndTime().compareTo(o1.getEndTime());
            }
        };

        public static Comparator<Task> PRIORITY = new Comparator<Task>(){
            @Override
            public int compare(Task o1, Task o2) {
                return Integer.compare(o2.getPriority(), o1.getPriority());
            }
        };

        public static Comparator<Task> REVERSEPRIORITY = new Comparator<Task>(){
            @Override
            public int compare(Task o1, Task o2) {
                return Integer.compare(o1.getPriority(), o2.getPriority());
            }
        };
    }
}
