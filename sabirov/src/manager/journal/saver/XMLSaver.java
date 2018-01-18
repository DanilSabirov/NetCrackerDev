package manager.journal.saver;

import manager.journal.XMLJournalTasks;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.nio.file.Path;

/**
 * The saver journal in XML format.
 */

public class XMLSaver implements Saver {
    @Override
    public void save(Path path, XMLJournalTasks journal) {
        try {
            JAXBContext context = JAXBContext.newInstance(XMLJournalTasks.class);
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(journal, path.toFile());
        } catch (PropertyException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
