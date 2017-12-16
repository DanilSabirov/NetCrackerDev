package manager.journal;

import manager.Main;
import manager.task.Task;
import manager.saver.*;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "jornal")
@XmlAccessorType(XmlAccessType.NONE)
public class XMLJournalTasks implements JournalTasks {
    @XmlElement(name = "task")
    @XmlElementWrapper(name = "listTasks")
    private List<Task> listTasks;

    public XMLJournalTasks(){
        listTasks = new ArrayList<Task>();
    }

    @Override
    public void saveAllTasks(List<Task> taskList) {
        listTasks = taskList;
    }

    @Override
    public List<Task> loadAllTasks() {
        return listTasks;
    }


}
