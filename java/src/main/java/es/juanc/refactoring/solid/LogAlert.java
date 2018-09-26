package es.juanc.refactoring.solid;

import es.juanc.refactoring.solid.service.Writer;

public class LogAlert {

    public void logAlert(String message) {

        Writer log = new Writer();
        log.writeToFile(message);
    }
}
