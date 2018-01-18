package manager;

import manager.task.Task;
import manager.view.NotificationView;

import java.util.TimerTask;

/**
 *Notification dialog box.
 */

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
