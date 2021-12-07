package com.example;

import java.io.File;

public interface Publisher {

    void addListener(String operation, EventListener listener);

    void removeListener(String operation, EventListener listener);

    void notify(String operation, File file);
}
