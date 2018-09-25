package es.juanc.refactoring.solid.service;

import static java.lang.System.out;

public class Mailer {

	public void sendToSysadmin (String message) {
		out.println("send '"+message+"' by mail");
	}
}
