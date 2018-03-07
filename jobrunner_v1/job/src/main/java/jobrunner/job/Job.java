package jobrunner.job;

import jobrunner.api.Messenger;
import jobrunner.job.internal.JobLogic;

public class Job {
    private Messenger messenger = null;

    public void execute() {
        final JobLogic jobLogic = new JobLogic();
        jobLogic.executeWithMessenger(messenger);
    }
}
