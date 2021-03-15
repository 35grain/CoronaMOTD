package ee.richard.CoronaMOTD;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class CoronaMOTD extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new MOTD(), this);
        this.getCommand("corona").setExecutor(new CommandCorona());
    }

    @Override
    public void onDisable() {

    }
}
