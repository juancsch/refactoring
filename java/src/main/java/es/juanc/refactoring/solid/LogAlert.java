package es.juanc.refactoring.solid;

import es.juanc.refactoring.solid.service.Writer;

public class LogAlert implements Alert {

    private void logAlert(String message) {

        Writer log = new Writer();
        log.writeToFile(message);
    }

    @Override
    public void send(String message) {
        logAlert(message);
    }
}
