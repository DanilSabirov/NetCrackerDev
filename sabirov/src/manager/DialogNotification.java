package manager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import manager.task.Task;
import manager.view.NotificationView;

import java.io.IOException;
import java.util.TimerTask;

public class DialogNotification extends TimerTask implements Notification {
    private NotificationView view;

    private Task task;

    public DialogNotification(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        notifyNow();
    }

    @Override
    public void notifyNow() {
        view = new NotificationView(task);
        view.show();
    }
}
