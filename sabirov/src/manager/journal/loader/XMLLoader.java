package manager.journal.loader;

import manager.journal.XMLJournalTasks;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.nio.file.Path;

/**
 * The loader journal in XML format.
 */

public class XMLLoader implements Loader {
    /**
     * Loads journal in XML format.
     * @param path Path to journal.
     * @return journal in XML format.
     */
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
