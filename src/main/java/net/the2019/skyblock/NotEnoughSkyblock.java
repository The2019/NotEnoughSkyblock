package net.the2019.skyblock;

import net.fabricmc.api.ModInitializer;
import net.hypixel.api.HypixelAPI;
import net.hypixel.api.apache.ApacheHttpClient;
import net.minecraft.client.MinecraftClient;

import java.util.UUID;

public class NotEnoughSkyblock implements ModInitializer {
	public static HypixelAPI API;
	private UUID playerUUID;

	public static MinecraftClient mc = MinecraftClient.getInstance();

	@Override
	public void onInitialize() {

		String key = System.getProperty("apiKey", "99de5340-7e90-44f2-a974-71ce9ef7901b"); // arbitrary key, replace with your own to test or use the property
		API = new HypixelAPI(new ApacheHttpClient(UUID.fromString(key)));


	}
}