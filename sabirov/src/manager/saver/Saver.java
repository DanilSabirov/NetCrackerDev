package manager.saver;

import manager.journal.XMLJournalTasks;

import java.nio.file.Path;

public interface Saver {
    void save(Path path, XMLJournalTasks journal);
}
