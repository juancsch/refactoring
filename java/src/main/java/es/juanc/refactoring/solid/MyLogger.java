package es.juanc.refactoring.solid;

import java.util.EnumMap;
import java.util.Map;

public class MyLogger {

	public enum AlertType {
        LOG, WARNING, CRITICAL
    }

	private Map<AlertType, Alert> alerts = new EnumMap<>(AlertType.class);

	public void log(AlertType type, String message) {

		alertBy(type).send(message);
	}

	public void registerAlert(AlertType type, Alert alert) {
		alerts.put(type, alert);
	}

	private Alert alertBy(AlertType type) {
		return alerts.get(type);
	}
}
