package es.juanc.refactoring.solid;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyLoggerSpec {

    private PrintStream originalSysOut;
    private ByteArrayOutputStream consoleStream;

    @BeforeEach
    void init() {
        originalSysOut = System.out;
        consoleStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(consoleStream);
        System.setOut(printStream);
    }

    @AfterEach
    void teardown() {
        System.setOut(originalSysOut);
    }

    @Test
    void testSimpleOutput() {

        System.out.println("Hello folks!");
        System.out.println("Hello programmer!");

        assertEquals(
        "Hello folks!\nHello programmer!\n",
         consoleStream.toString()
        );
    }

    @Test
    void logging_message_type_log() {

        MyLogger logger = new MyLogger();

        String message = "esto es una prueba";
        logger.log(MyLogger.LOG, message);

        String expected = "write '"+message+"' to log\n";
        assertEquals(expected, consoleStream.toString());
    }

    @Test
    void logging_message_type_warning() {

        MyLogger logger = new MyLogger();

        String message = "esto es una prueba";
        logger.log(MyLogger.WARNING, message);

        String expected = "write '"+message+"' to log\n";
        expected += "send '"+message+"' by mail\n";
        assertEquals(expected, consoleStream.toString());
    }

    @Test
    void logging_message_type_critical() {

        MyLogger logger = new MyLogger();

        String message = "esto es una prueba";
        logger.log(MyLogger.CRITICAL, message);

        String expected = "write '"+message+"' to log\n";
        expected += "send '"+message+"' by mail\n";
        expected += "send '"+message+"' by sms\n";
        assertEquals(expected, consoleStream.toString());
    }
}
