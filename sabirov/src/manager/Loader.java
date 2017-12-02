package manager;

import manager.model.ManagerModelInterfase;

import java.nio.file.Path;

public interface Loader {
    ManagerModelInterfase load(Path path);
}
