module modularity.job {
    requires modularity.api;

    exports jobrunner.job;

    opens jobrunner.job;
}