package org.example;

import java.util.Scanner;

public class Console {
    private static final Scanner scanner = new Scanner(System.in);
    public static void clear() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception ex) {
            System.err.println("Console error: " + ex.getMessage());
        }
    }

    public static void waitFor(final int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException intEX) {
            intEX.getStackTrace();
        }
    }

    public static String write() {
        return scanner.next();
    }

    public static String write(String value) {
        System.out.print(value);
        return scanner.next();
    }
}
