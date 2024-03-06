package br.dev.brunnofdc.javaforbukkit.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SiteComando implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull final CommandSender sender, @NotNull final Command command,
        @NotNull final String label, final @NotNull String[] args) {

        if(sender instanceof Player player) {
            if (!player.hasPermission("javaforbukkit.site")) {
                player.sendMessage("§cVoce não tem permissão para isso!");
                return true;
            }
        }

        sender.sendMessage("§aSite do nosso servidor: §ewww.brunnofdc.dev.br");

        return true;
    }
}