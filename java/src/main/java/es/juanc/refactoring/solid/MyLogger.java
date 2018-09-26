package es.juanc.refactoring.solid;

public class MyLogger {

	public static final int LOG = 0;
	public static final int WARNING = 1;
	public static final int CRITICAL = 2;

	public void log(int type, String message) {

		Alert alert = null;

		switch (type) {
			case LOG:
				alert = new LogAlert();
				break;
			case WARNING:
				alert = new WarningAlert();
				break;
			case CRITICAL:
				alert = new CriticalAlert();
				break;
		}

		alert.send(message);
	}
}
