package com.flappygrant.backcore.util;

import com.pghserver.api.PghAPI;
import com.pghserver.api.PghLogger;

import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class GameManifests {
    private static final Map<String, GameManifest> manifests = new HashMap<>();

    public static boolean has(String id) {
        return manifests.containsKey(id);
    }

    public static GameManifest get(String id) {
        return manifests.get(id);
    }

    public static void reload(PghAPI server, PghLogger logger) throws RuntimeException {
        var directory = server.directory().resolve("gamedata");
        if (!Files.exists(directory)) try {
            Files.createDirectories(directory);
            return;
        } catch (IOException ex) {
            logger.fatal("Could not create gamedata directory!", ex);
            throw new RuntimeException(ex);
        }

        manifests.clear();
        try (var files = Files.list(directory).filter(p -> p.getFileName().toString().endsWith(".json"))) {
            for (var file : files.toList()) {
                var id = file.getFileName().toString().substring(0, file.getFileName().toString().lastIndexOf("."));
                try {
                    var manifest = GameManifest.fromString(Files.readString(file));
                    manifests.put(id, manifest);
                } catch (IOException ex) {
                    logger.warn("Could not read gamedata of", id + "!", ex);
                }
            }
        } catch (IOException ex) {
            logger.fatal("Could not list gamedata directory!", ex);
            throw new RuntimeException(ex);
        }
    }
}
