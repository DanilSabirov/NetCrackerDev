package manager;

import manager.model.ManagerModelInterfase;

import java.nio.file.Path;

public interface Saver {
    public void save(Path path, ManagerModelInterfase task);
}
