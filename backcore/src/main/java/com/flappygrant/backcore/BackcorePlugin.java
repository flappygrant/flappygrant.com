package com.flappygrant.backcore;

import com.flappygrant.backcore.route.RouteGameManifest;
import com.flappygrant.backcore.route.RoutePlayRedirects;
import com.flappygrant.backcore.util.GameManifests;
import com.google.gson.Gson;
import com.pghserver.api.PghAPI;
import com.pghserver.api.PghLogger;
import com.pghserver.api.PghPlugin;

public class BackcorePlugin implements PghPlugin {
    public static final Gson gson = new Gson();

    @Override
    public void onEnable(PghAPI server, PghLogger logger) {
        GameManifests.reload(server, logger);
        server.route("/.*", new RoutePlayRedirects());
        server.route("/[^/]+\\.json", new RouteGameManifest());
    }

    @Override
    public void onDisable(PghAPI server, PghLogger logger) {
    }
}
