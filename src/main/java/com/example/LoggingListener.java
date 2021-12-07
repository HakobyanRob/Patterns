package com.example;

import java.io.File;

public class LoggingListener implements EventListener {
    private File log;

    public LoggingListener(File file) {
        this.log = file;
    }

    @Override
    public void update(String operation, File file) {
        System.out.println("\nLogging in: '" + log +
                "'\tOperation '" + operation + "' has been performed on the file '" + file.getAbsolutePath() + "'");
    }
}
