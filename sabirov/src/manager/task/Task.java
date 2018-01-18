package manager.task;

import javafx.scene.paint.Color;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Comparator;
import java.util.Date;

/**
 * The class Task describes a user task.
 */

@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"name", "description", "dateCreation", "endTime", "status", "priority"/*, "color"*/})
public class Task implements Cloneable {
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

    /**
     * Returns the name of the task
     * @return the name of the task
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the description of the task.
     * @return the description of the task.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the priority of the task. The range of value from 0 to 10. Default value is 5.
     * @return the priority of the task.
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Returns the task color.
     * @return the task color.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Returns the date creation of the object of Task class.
     * @return the date creation of the object of Task class.
     */
    public Date getDateCreation() {
        return dateCreation;
    }

    /**
     * Returns the date when the task must be completed, or null if the date not defined.
     * @return returns the date when the task must be completed.
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * Returns the execution status.
     * @return
     * @see StatusTask
     */
    public StatusTask getStatus() {
        return status;
    }

    /**
     * Sets the task name.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the task description.
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the task priority. The range of value from 0 to 10.
     * @param priority
     */
    public void setPriority(int priority) {
        if (0 <= priority && priority <= 10) {
            this.priority = priority;
        } else {
            throw new IllegalArgumentException("incorrect priority");
        }
    }

    /**
     * Sets the task color.
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Sets the date when the task must be completed,
     * @param date
     */
    public void setEndTime(Date date) {
        endTime = date;
    }

    @Override
    public Task clone() throws CloneNotSupportedException {
        return (Task) super.clone();
    }

    /**
     * The Comparators class performs Task comparison.
     */
    public static class Comparators {
        public static Comparator<Task> NAME = new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if (o1.getName() == null) {
                    return -1;
                }
                if (o2.getName() == null) {
                    return 1;
                }
                return o1.getName().compareTo(o2.getName());
            }
        };

        public static Comparator<Task> REVERSENAME = new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if (o1.getName() == null) {
                    return 1;
                }
                if (o2.getName() == null) {
                    return -1;
                }
                return o2.getName().compareTo(o1.getName());
            }
        };

        public static Comparator<Task> DATECREATED = new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getDateCreation().compareTo(o2.getDateCreation());
            }
        };

        public static Comparator<Task> REVERSEDATECREATED = new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o2.getDateCreation().compareTo(o1.getDateCreation());
            }
        };

        public static Comparator<Task> ENDDATE = new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if (o1.getEndTime() == null) {
                    return -1;
                }
                if (o2.getEndTime() == null) {
                    return 1;
                }
                return o1.getEndTime().compareTo(o2.getEndTime());
            }
        };

        public static Comparator<Task> REVERSEENDDATE = new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if (o1.getEndTime() == null) {
                    return 1;
                }
                if (o2.getEndTime() == null) {
                    return -1;
                }
                return o2.getEndTime().compareTo(o1.getEndTime());
            }
        };

        public static Comparator<Task> PRIORITY = new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return Integer.compare(o2.getPriority(), o1.getPriority());
            }
        };

        public static Comparator<Task> REVERSEPRIORITY = new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return Integer.compare(o1.getPriority(), o2.getPriority());
            }
        };
    }
}
