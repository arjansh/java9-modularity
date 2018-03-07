package jobrunner.services;

import jobrunner.api.Messenger;

public class Stallone implements Messenger {
    @Override
    public String getMessage() {
        return "They drew first blood!";
    }
}
