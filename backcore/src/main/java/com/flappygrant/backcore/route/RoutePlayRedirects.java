package com.flappygrant.backcore.route;

import com.pghserver.api.PghAPI;
import com.pghserver.api.RouteHandler;
import com.pghserver.api.type.NextCallback;
import com.pghserver.api.type.Request;
import com.pghserver.api.type.Response;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Files;

public class RoutePlayRedirects implements RouteHandler {
    private final PghAPI server;

    public RoutePlayRedirects(PghAPI server) {
        this.server = server;
    }

    @Override
    public void run(@NotNull Request request, @NotNull Response response, @NotNull NextCallback next) {
        var gameId = request.url().path().substring(1);
        var manifest = server.directory().resolve("static").resolve(gameId + ".json");
        if (!Files.exists(manifest) || !Files.isRegularFile(manifest)) {
            next.run();
            return;
        }

        response.redirect("https://www.flappygrant.com/play.html?g=" + gameId);
    }
}
