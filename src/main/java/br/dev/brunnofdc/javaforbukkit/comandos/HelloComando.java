package br.dev.brunnofdc.javaforbukkit.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HelloComando implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull final CommandSender sender, @NotNull final Command command,
        @NotNull final String label, final @NotNull String[] args) {

        if (sender instanceof Player player) {
            player.sendMessage("Olá jogador!");
        } else {
            sender.sendMessage("Olá console!");
        }

        return true;
    }
}