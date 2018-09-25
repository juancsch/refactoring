package es.juanc.refactoring.solid;

import es.juanc.refactoring.solid.service.Mailer;
import es.juanc.refactoring.solid.service.Sms;
import es.juanc.refactoring.solid.service.Writer;

public class MyLogger {

	public static final int LOG = 0;
	public static final int WARNING = 1;
	public static final int CRITICAL = 2;

	private Writer log;
	private Mailer mail;
	private Sms sms;

	public void log (int type, String message) {

		switch (type) {
			case LOG:
				log = new Writer();
				log.writeToFile(message);
				break;
			case WARNING:
				log = new Writer();
				log.writeToFile(message);
				mail = new Mailer();
				mail.sendToSysadmin(message);
				break;
			case CRITICAL:
				log = new Writer();
				log.writeToFile(message);
				mail = new Mailer();
				mail.sendToSysadmin(message);
				sms = new Sms();
				sms.sendToSysadmin(message);
				break;
		}
	}
}
