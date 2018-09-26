package es.juanc.refactoring.solid;

import es.juanc.refactoring.solid.service.Mailer;
import es.juanc.refactoring.solid.service.Writer;

public class WarningAlert implements Alert {

    private void warningAlert(String message) {

        Writer log = new Writer();
        log.writeToFile(message);

        Mailer mail = new Mailer();
        mail.sendToSysadmin(message);
    }

    @Override
    public void send(String message) {
        warningAlert(message);
    }
}
