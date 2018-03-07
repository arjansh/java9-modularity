package jobrunner.runner;

import jobrunner.api.Messenger;
import jobrunner.job.Job;
import jobrunner.job.internal.JobLogic;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        final Job job = new Job();

        Messenger arnoldSchwarzenegger = new Messenger() {
            @Override
            public String getMessage() {
                return "I'll be back!";
            }
        };

        injectMessenger(job, arnoldSchwarzenegger);

        job.execute();

        // Also do it using a shortcut :)
        new JobLogic().executeWithMessenger(arnoldSchwarzenegger);
    }

    private static void injectMessenger(Job job, Messenger messenger) {
        try {
            final Field messengerField = Job.class.getDeclaredField("messenger");

            messengerField.setAccessible(true);

            messengerField.set(job, messenger);

            messengerField.setAccessible(false);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
