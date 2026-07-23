package com.flappygrant.backcore.route;

import com.flappygrant.backcore.util.GameManifests;
import com.pghserver.api.RouteHandler;
import com.pghserver.api.type.NextCallback;
import com.pghserver.api.type.Request;
import com.pghserver.api.type.Response;
import org.jetbrains.annotations.NotNull;

public class RoutePlayRedirects implements RouteHandler {

    @Override
    public void run(@NotNull Request request, @NotNull Response response, @NotNull NextCallback next) {
        var gameId = request.url().path().substring(1);
        if (!GameManifests.has(gameId)) {
            next.run();
            return;
        }

        response.redirect("https://www.flappygrant.com/play.html?g=" + gameId);
    }
}
