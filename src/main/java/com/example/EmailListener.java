package com.example;

import java.io.File;

public class EmailListener implements EventListener {
    private String address;

    public EmailListener(String address) {
        this.address = address;
    }

    @Override
    public void update(String operation, File file) {
        System.out.println("\nEmail to: " + address +
                "\tOperation '" + operation + "' has been performed on the file '" + file.getAbsolutePath() + "'");
    }
}
