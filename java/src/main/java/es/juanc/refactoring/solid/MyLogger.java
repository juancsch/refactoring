package es.juanc.refactoring.solid;

import es.juanc.refactoring.solid.service.Mailer;
import es.juanc.refactoring.solid.service.Sms;
import es.juanc.refactoring.solid.service.Writer;

public class MyLogger {

	public static final int LOG = 0;
	public static final int WARNING = 1;
	public static final int CRITICAL = 2;

	public void log(int type, String message) {

		switch (type) {
			case LOG:
				logAlert(message);
				break;
			case WARNING:
				warningAlert(message);
				break;
			case CRITICAL:
				criticalAlert(message);
				break;
		}
	}

	private void criticalAlert(String message) {

		Writer log = new Writer();
		log.writeToFile(message);

		Mailer mail = new Mailer();
		mail.sendToSysadmin(message);

		Sms sms = new Sms();
		sms.sendToSysadmin(message);
	}

	private void warningAlert(String message) {

		Writer log = new Writer();
		log.writeToFile(message);

		Mailer mail = new Mailer();
		mail.sendToSysadmin(message);
	}

	private void logAlert(String message) {

		Writer log = new Writer();
		log.writeToFile(message);
	}
}
