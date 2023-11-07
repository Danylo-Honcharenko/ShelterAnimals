package org.example;

import org.example.services.StateStorageService;

public class AutoSave implements Runnable {
    private final StateStorageService storage;

    public AutoSave(StateStorageService storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            storage.save();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
