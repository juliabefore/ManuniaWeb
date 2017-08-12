package com.miskevich.manuniaweb.utils;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class DirectoryScanner {

    private Path directory = Paths.get("src/main/webapp");

    public String scanDirectoryForNewWars() {
        String warFileName = "";
        try {
            WatchService watcher = directory.getFileSystem().newWatchService();
            directory.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);

            WatchKey watchKey = watcher.take();
            List<WatchEvent<?>> events = watchKey.pollEvents();
            for (WatchEvent event : events) {
                if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                    warFileName = event.context().toString();
                    System.out.println("Found new war file: " + warFileName);
                }
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return warFileName;
    }
}
