module modularity.services {
    requires modularity.api;

    provides jobrunner.api.Messenger with jobrunner.services.Schwarzenegger, jobrunner.services.Stallone;
}