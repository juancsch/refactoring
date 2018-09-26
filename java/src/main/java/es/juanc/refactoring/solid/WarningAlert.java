package es.juanc.refactoring.solid;

import es.juanc.refactoring.solid.service.Mailer;
import es.juanc.refactoring.solid.service.Writer;

public class WarningAlert {

    public void warningAlert(String message) {

        Writer log = new Writer();
        log.writeToFile(message);

        Mailer mail = new Mailer();
        mail.sendToSysadmin(message);
    }
}