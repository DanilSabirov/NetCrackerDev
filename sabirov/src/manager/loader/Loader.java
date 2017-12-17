package manager.loader;

import manager.journal.XMLJournalTasks;

import java.nio.file.Path;

public interface Loader {
    XMLJournalTasks load(Path path);
}
