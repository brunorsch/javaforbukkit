package br.dev.brunnofdc.javaforbukkit.listener;

import static net.kyori.adventure.text.Component.EQUALS;
import static net.kyori.adventure.text.Component.EQUALS_IDENTITY;
import static net.kyori.adventure.text.format.TextColor.fromCSSHexString;
import static net.kyori.adventure.text.format.TextDecoration.ITALIC;
import static org.bukkit.block.sign.Side.FRONT;

import org.bukkit.Bukkit;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;

public class PlacaInteracaoLixeiraListener implements Listener {
    private static final String TAG_CABECALHO = "[lixeira]";
    private static final String CABECALHO_PLACA_ESTILIZADA = "[Lixeira]";
    private static final TextColor COR_CABECALHO = fromCSSHexString("#8c04db");

    @EventHandler
    public void onCriarPlaca(SignChangeEvent event) {
        Component cabecalho = event.line(0);

        if(cabecalho != null && PlainTextComponentSerializer.plainText()
            .serialize(cabecalho)
            .equalsIgnoreCase(TAG_CABECALHO)) {
            event.line(0, Component.text(CABECALHO_PLACA_ESTILIZADA)
                .color(COR_CABECALHO));
            event.line(1, Component.text("Clique para abrir!")
                .decorate(ITALIC));
        }
    }

    @EventHandler
    public void onPlayerClick(PlayerInteractEvent event) {
        var bloco = event.getClickedBlock();

        if(bloco != null && bloco.getState() instanceof Sign sign) {
            var side = sign.getSide(FRONT);

            final Component componenteCabecalho = side.line(0);
            final Component componenteEsperado = Component.text(CABECALHO_PLACA_ESTILIZADA)
                .color(COR_CABECALHO);

            if(componenteCabecalho.contains(componenteEsperado, EQUALS)) {
                Inventory inventory = Bukkit.createInventory(null, 54, Component.text("Lixeira"));

                event.getPlayer().openInventory(inventory);
                event.setCancelled(true);
            }
        }
    }
}