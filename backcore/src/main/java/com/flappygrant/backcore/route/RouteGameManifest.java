package com.flappygrant.backcore.route;

import com.flappygrant.backcore.util.GameManifests;
import com.pghserver.api.RouteHandler;
import com.pghserver.api.type.NextCallback;
import com.pghserver.api.type.Request;
import com.pghserver.api.type.Response;
import com.pghserver.api.type.ResponseStatus;
import org.jetbrains.annotations.NotNull;

public class RouteGameManifest implements RouteHandler {

    @Override
    public void run(@NotNull Request request, @NotNull Response response, @NotNull NextCallback next) {
        var gameId = request.url().path().substring(1).split("\\.json", 2)[0];
        if (!GameManifests.has(gameId)) {
            response.status(ResponseStatus.NOT_FOUND);
            next.run();
            return;
        }

        response.status(ResponseStatus.OK);
        response.header("Access-Control-Allow-Origin", "*");
        response.header("Access-Control-Allow-Methods", "GET");
        response.contentType("application/json");
        response.body(GameManifests.get(gameId).toString());
    }
}
