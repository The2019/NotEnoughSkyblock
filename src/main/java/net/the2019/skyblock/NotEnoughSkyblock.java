package net.the2019.skyblock;

import net.fabricmc.api.ModInitializer;
import net.hypixel.api.HypixelAPI;
import net.minecraft.client.MinecraftClient;

import java.util.UUID;

public class NotEnoughSkyblock implements ModInitializer {
	public static HypixelAPI API;
	private UUID playerUUID;

	public static MinecraftClient mc = MinecraftClient.getInstance();

	@Override
	public void onInitialize() {

		mc.getNetworkHandler().getPlayerList().forEach(playerListEntry -> {
			if(playerListEntry != null){
					player
			}
		});
	}
}