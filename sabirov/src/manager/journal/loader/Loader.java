package manager.journal.loader;

import manager.journal.JournalTasks;

import java.nio.file.Path;

/**
 * This interface defines a functions journal loader.
 */

public interface Loader {
    /**
     * Loads a task journal.
     * @param path
     * @return  a task journal.
     */
    JournalTasks load(Path path);
}
