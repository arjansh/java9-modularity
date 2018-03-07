package jobrunner.runner;

import jobrunner.api.Messenger;
import jobrunner.job.Job;

import java.lang.reflect.Field;
import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
        final Iterable<Messenger> messengers = ServiceLoader.load(Messenger.class);

        messengers.forEach(messenger -> {
            final Job job = new Job();

            injectMessenger(job, messenger);

            job.execute();
        });
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
