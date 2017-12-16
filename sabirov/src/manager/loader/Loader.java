package manager.loader;

import manager.journal.XMLJournalTasks;

import java.nio.file.Path;

public interface Loader {
    public XMLJournalTasks load(Path path);
}
