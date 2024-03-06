package br.dev.brunnofdc.javaforbukkit;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class JavaForBukkit extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Plugin inicializado");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin finalizado!");
    }

    @Override
    public boolean onCommand(@NotNull final CommandSender sender, @NotNull final Command command,
        @NotNull final String label,
        final @NotNull String[] args) {

        if (label.equalsIgnoreCase("hello")) {
            if (sender instanceof Player player) {
                player.sendMessage("Olá jogador!");
            } else {
                sender.sendMessage("Olá console!");
            }
        }

        return true;
    }
}