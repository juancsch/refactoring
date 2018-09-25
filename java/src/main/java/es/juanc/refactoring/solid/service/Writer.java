package es.juanc.refactoring.solid.service;

import static java.lang.System.out;

public class Writer {

	public void writeToFile (String message) {
		out.println("write '"+message+"' to log");
	}
}
