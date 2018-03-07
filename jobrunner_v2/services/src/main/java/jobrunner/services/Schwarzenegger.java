package jobrunner.services;

import jobrunner.api.Messenger;

public class Schwarzenegger implements Messenger {
    @Override
    public String getMessage() {
        return "I'll be back!";
    }
}
