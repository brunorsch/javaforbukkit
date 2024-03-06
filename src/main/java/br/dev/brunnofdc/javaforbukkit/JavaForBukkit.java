package br.dev.brunnofdc.javaforbukkit;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import br.dev.brunnofdc.javaforbukkit.comandos.HelloComando;
import br.dev.brunnofdc.javaforbukkit.comandos.SiteComando;

public final class JavaForBukkit extends JavaPlugin {
    private static FileConfiguration config;

    @Override
    public void onEnable() {
        getLogger().info("Plugin inicializado");

        saveDefaultConfig();

        config = getConfig();

        getCommand("hello").setExecutor(new HelloComando());
        getCommand("site").setExecutor(new SiteComando());
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin finalizado!");
    }

    public static FileConfiguration getPluginConfig() {
        return config;
    }
}