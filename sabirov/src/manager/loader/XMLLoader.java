package manager.loader;

import manager.model.ManagerModelInterfase;
import manager.model.ManagerModel;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.nio.file.Path;

public class XMLLoader implements Loader{
    @Override
    public ManagerModelInterfase load(Path path) {
        ManagerModel model = null;
        try {
            JAXBContext context = JAXBContext.newInstance(ManagerModel.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            model = (ManagerModel) unmarshaller.unmarshal(path.toFile());
        } catch (JAXBException e) {
            model = new ManagerModel();
        }
        return model;
    }
}
