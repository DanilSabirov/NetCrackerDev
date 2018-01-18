package manager.journal.saver;

import manager.journal.XMLJournalTasks;

import java.nio.file.Path;

/**
 * This interface defines a functions journal saver.
 */

public interface Saver {
    /**
     * Saves journal in XML format.
     * @param path Path to journal.
     * @param journal Journal that be saved.
     */
    void save(Path path, XMLJournalTasks journal);
}
