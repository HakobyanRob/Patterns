package com.example;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EventManager implements Publisher {
    Map<String, Set<EventListener>> operationForListeners;

    public EventManager(String... operations) {
        operationForListeners = new HashMap<>();
        for (String operation : operations) {
            this.operationForListeners.put(operation, new HashSet<>());
        }
    }

    @Override
    public void addListener(String operation, EventListener listener) {
        if (operationForListeners == null) {
            operationForListeners = new HashMap<>();
        }
        if (operationForListeners.containsKey(operation)) {
            operationForListeners.get(operation).add(listener);
        } else {
            Set<EventListener> list = new HashSet<>();
            list.add(listener);
            operationForListeners.put(operation, list);
        }
    }

    @Override
    public void removeListener(String operation, EventListener listener) {
        if (operationForListeners != null && !operationForListeners.isEmpty()) {
            if (operationForListeners.containsKey(operation)) {
                operationForListeners.get(operation).remove(listener);
            }
        }
    }

    @Override
    public void notify(String operation, File file) {
        if (operationForListeners != null
                && !operationForListeners.isEmpty()
                && operationForListeners.containsKey(operation)) {
            operationForListeners.get(operation).forEach(l -> l.update(operation, file));
        }
    }
}
