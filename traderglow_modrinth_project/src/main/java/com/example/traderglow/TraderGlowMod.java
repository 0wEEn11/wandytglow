package com.example.traderglow;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.entity.passive.WanderingTraderEntity;
import net.minecraft.util.math.Vec3d;

public class TraderGlowMod implements ClientModInitializer {
    public static final String MOD_ID = "traderglow";

    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register((drawContext, tickCounter) -> {
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.world == null || client.player == null) return;

            TextRenderer textRenderer = client.textRenderer;
            Vec3d playerPos = client.player.getPos();

            int row = 0;
            for (net.minecraft.entity.Entity entity : client.world.getEntities()) {
                if (entity instanceof WanderingTraderEntity trader) {
                    double distance = playerPos.distanceTo(trader.getPos());
                    String text = String.format("! WANDERING TRADER [%.1fm] !", distance);
                    int textWidth = textRenderer.getWidth(text);
                    int x = (client.getWindow().getScaledWidth() - textWidth) / 2;
                    int y = 20 + row++ * 12;
                    drawContext.drawTextWithShadow(textRenderer, text, x, y, 0xFFFF5555);
                }
            }
        });
    }
}
