package net.the2019.skyblock;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;
import net.hypixel.api.HypixelAPI;
import net.hypixel.api.apache.ApacheHttpClient;
import net.hypixel.api.example.ExampleUtil;

import java.util.UUID;

public class NotEnoughSkyblock implements ModInitializer {
	public static HypixelAPI API;
	private UUID playerUUID;

	@Override
	public void onInitialize() {

		String key = System.getProperty("apiKey", "99de5340-7e90-44f2-a974-71ce9ef7901b"); // arbitrary key, replace with your own to test or use the property
		API = new HypixelAPI(new ApacheHttpClient(UUID.fromString(key)));


		// Register the /info command
		ClientCommandManager.DISPATCHER.register(ClientCommandManager.literal("info").executes(context -> {

			return bazaar(String "skyblock/bazaar/seed");
		}));
	}

	public static void bazaar(String args) {
		ExampleUtil.API.getSkyBlockBazaar().whenComplete(ExampleUtil.getTestConsumer());
		ExampleUtil.await();
	}
}