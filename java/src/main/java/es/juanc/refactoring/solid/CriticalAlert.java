package es.juanc.refactoring.solid;

import es.juanc.refactoring.solid.service.Mailer;
import es.juanc.refactoring.solid.service.Sms;
import es.juanc.refactoring.solid.service.Writer;

public class CriticalAlert implements Alert {

    private void criticalAlert(String message) {

        Writer log = new Writer();
        log.writeToFile(message);

        Mailer mail = new Mailer();
        mail.sendToSysadmin(message);

        Sms sms = new Sms();
        sms.sendToSysadmin(message);
    }

    @Override
    public void send(String message) {
        criticalAlert(message);
    }
}
