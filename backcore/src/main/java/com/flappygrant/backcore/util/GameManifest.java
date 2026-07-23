package com.flappygrant.backcore.util;

import com.flappygrant.backcore.BackcorePlugin;

public class GameManifest {
    private String title;
    private String description;
    private String source;

    public String title() {
        return title;
    }

    public String description() {
        return description;
    }

    public String source() {
        return source;
    }

    @Override
    public String toString() {
        return BackcorePlugin.gson.toJson(this);
    }

    public static GameManifest fromString(String string) {
        return BackcorePlugin.gson.fromJson(string, GameManifest.class);
    }
}
