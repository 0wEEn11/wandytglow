package com.example.traderglow;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientEntityEvents;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.npc.WanderingTrader;

import java.util.HashSet;
import java.util.Set;

public class TraderGlowMod implements ClientModInitializer {
    public static final String MOD_ID = "traderglow";

    private static final Set<WanderingTrader> TRADERS = new HashSet<>();

    @Override
    public void onInitializeClient() {
        ClientEntityEvents.ENTITY_LOAD.register((entity, level) -> {
            if (entity instanceof WanderingTrader trader) TRADERS.add(trader);
        });
        ClientEntityEvents.ENTITY_UNLOAD.register((entity, level) -> {
            if (entity instanceof WanderingTrader trader) TRADERS.remove(trader);
        });

        HudElementRegistry.attachElementBefore(
                VanillaHudElements.CHAT,
                Identifier.fromNamespaceAndPath(MOD_ID, "trader_hud"),
                (graphics, tickCounter) -> {
                    Minecraft mc = Minecraft.getInstance();
                    if (mc.level == null || mc.player == null) return;

                    int row = 0;
                    for (WanderingTrader trader : TRADERS) {
                        float distance = mc.player.distanceTo(trader);
                        String text = String.format("! WANDERING TRADER [%.1fm] !", distance);
                        int x = (mc.getWindow().getGuiScaledWidth() - mc.font.width(text)) / 2;
                        int y = 20 + row++ * 12;
                        graphics.text(mc.font, text, x, y, 0xFFFF5555);
                    }
                });
    }
}
