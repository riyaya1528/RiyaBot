package net.riyaya.Utils;

import java.util.Date;

public class Logger {
    private final static Date dateObj = new Date();

    public static void info(String log) {
        System.out.println("[" + getDate() + "] [Info] "  + log);
    }

    public static void warn(String log) {
        System.out.println("[" + getDate() + "] [" + "\u001b[00;31m" + "Warn" + "\u001b[00m" + "] " + log);
    }

    private static String getDate() {
        return dateObj.getHours() + ":" + dateObj.getMinutes() + ":" + dateObj.getSeconds();
    }
}
