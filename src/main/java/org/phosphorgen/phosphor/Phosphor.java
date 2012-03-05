package org.phosphorgen.phosphor;

import org.bukkit.Location;
import org.bukkit.WorldCreator;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;
import org.phosphorgen.phosphor.gen.MainGenerator;

public class Phosphor extends JavaPlugin implements Listener
{
    public void onDisable() {
    }

    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        if (getServer().getWorld("testworld") == null)
            getServer().createWorld(WorldCreator.name("test").generator(new MainGenerator()));
    }

    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        return new MainGenerator();
    }
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        try {
            event.getPlayer().teleport(new Location(getServer().getWorld("test"), 0 , 80, 0));
        } catch (IllegalStateException ignore) {
        }
    }
}

