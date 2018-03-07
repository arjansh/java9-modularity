package jobrunner.job.internal;

import jobrunner.api.Messenger;

public class JobLogic {
    public void executeWithMessenger(Messenger messenger) {
        if (messenger == null) {
            System.out.println("No message.");
        } else {
            System.out.println("The message is: " + messenger.getMessage());
        }
    }
}
