package es.juanc.refactoring.solid.service;

import static java.lang.System.out;

public class Sms {

	public void sendToSysadmin (String message) {
		out.println("send '"+message+"' by sms");
	}
}
