package es.juanc.refactoring.solid;

public class MyLogger {

	public static final int LOG = 0;
	public static final int WARNING = 1;
	public static final int CRITICAL = 2;

	public void log(int type, String message) {

		switch (type) {
			case LOG:
				new LogAlert().logAlert(message);
				break;
			case WARNING:
				new WarningAlert().warningAlert(message);
				break;
			case CRITICAL:
				new CriticalAlert().criticalAlert(message);
				break;
		}
	}
}
