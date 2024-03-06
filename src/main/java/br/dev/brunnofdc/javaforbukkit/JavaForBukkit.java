package br.dev.brunnofdc.javaforbukkit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import br.dev.brunnofdc.javaforbukkit.comandos.HelloComando;
import br.dev.brunnofdc.javaforbukkit.comandos.SiteComando;

public final class JavaForBukkit extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Plugin inicializado");

        getCommand("hello").setExecutor(new HelloComando());
        getCommand("site").setExecutor(new SiteComando());
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin finalizado!");
    }
}