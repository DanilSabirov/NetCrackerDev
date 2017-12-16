package manager.loader;

import manager.journal.XMLJournalTasks;
import manager.model.ManagerModel;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.nio.file.Path;

public class XMLLoader implements Loader {
    @Override
    public XMLJournalTasks load(Path path) {
        XMLJournalTasks journal = null;
        try {
            JAXBContext context = JAXBContext.newInstance(XMLJournalTasks.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            journal = (XMLJournalTasks) unmarshaller.unmarshal(path.toFile());
        } catch (JAXBException e) {
            System.err.println("Error load journal");
            journal = new XMLJournalTasks();
        }
        return journal;
    }
}
