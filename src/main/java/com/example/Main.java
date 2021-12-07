package com.example;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        LoggingListener logListener1 = new LoggingListener(new File("/example/path/log.txt"));
        LoggingListener logListener2 = new LoggingListener(new File("/path/to/file/log.txt"));
        editor.events.addListener("open", logListener1);
        editor.events.addListener("open", logListener2);
        editor.events.addListener("save", logListener2);

        EmailListener emailListener = new EmailListener("example@mail.com");
        editor.events.addListener("save", emailListener);

        editor.openFile("/absolute/path/file.txt");
        try {
            editor.saveFile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
