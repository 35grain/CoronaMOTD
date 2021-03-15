package ee.richard.CoronaMOTD;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import java.io.IOException;

public class MOTD implements Listener {
    @EventHandler
    public void onServerListPingEvent(ServerListPingEvent event) throws IOException {
        event.setMotd(ParseJSON.dailyCases());
    }
}
