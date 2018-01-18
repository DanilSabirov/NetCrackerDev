package manager.journal;

import manager.task.Task;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The journal that stores tasks in XML format.
 */

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
