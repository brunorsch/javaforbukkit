package br.dev.brunnofdc.javaforbukkit.comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import br.dev.brunnofdc.javaforbukkit.JavaForBukkit;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;

public class SiteComando implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull final CommandSender sender, @NotNull final Command command,
        @NotNull final String label, final @NotNull String[] args) {

        var exigirPermissao = JavaForBukkit.getPluginConfig().getBoolean("Site.Exigir-Permissao");
        var mensagem = JavaForBukkit.getPluginConfig().getString("Site.Mensagem");

        if(sender instanceof Player player) {
            if (exigirPermissao && !player.hasPermission("javaforbukkit.site")) {
                player.sendMessage("§cVoce não tem permissão para isso!");
                return true;
            }
        }

        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', mensagem));

        return true;
    }
}