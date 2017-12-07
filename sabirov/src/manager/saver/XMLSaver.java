package manager.saver;

import manager.model.ManagerModel;
import manager.model.ManagerModelInterfase;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.nio.file.Path;

public class XMLSaver implements Saver {
    @Override
    public void save(Path path, ManagerModelInterfase model) {
        try {
            JAXBContext context = JAXBContext.newInstance(ManagerModel.class);
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(model, path.toFile());
        } catch (PropertyException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
