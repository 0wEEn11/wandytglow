package com.example.joincoords;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class JoinCoords implements DedicatedServerModInitializer {

    @Override
    public void onInitializeServer() {
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            ServerPlayer player = handler.getPlayer();
            String msg = "Player " + player.getUUID() + " joined at coordinates "
                    + player.getBlockX() + ", " + player.getBlockZ();
            server.getPlayerList().broadcastSystemMessage(Component.literal(msg), false);
        });
    }
}
