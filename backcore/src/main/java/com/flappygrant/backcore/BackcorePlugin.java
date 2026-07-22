package com.flappygrant.backcore;

import com.flappygrant.backcore.route.RoutePlayRedirects;
import com.google.gson.Gson;
import com.pghserver.api.PghAPI;
import com.pghserver.api.PghLogger;
import com.pghserver.api.PghPlugin;

public class BackcorePlugin implements PghPlugin {
    public static final Gson gson = new Gson();

    @Override
    public void onEnable(PghAPI server, PghLogger logger) {
        server.route("/.*", new RoutePlayRedirects(server));
    }

    @Override
    public void onDisable(PghAPI server, PghLogger logger) {
    }
}
