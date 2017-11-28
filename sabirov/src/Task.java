import java.awt.*;
import java.util.Date;

public class Task {

    private String caption;
    private String description;
    private int priority;
    private Color color;
    private Date dateCreation;
    private Date endTime;
    private StatusTask status;

    public String getCaption() {
        return caption;
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

    public String setCaption(String caprion) {
        return caprion;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(int priority) {
        if(0 <= priority && priority <= 10){
            this.priority = priority;
        }
        throw new IllegalArgumentException("incorrect priority");
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setEndTime(Date date) {
        endTime = date;
    }

    public StatusTask getStatus() {
        return status;
    }
}
