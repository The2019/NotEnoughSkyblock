package net.the2019.skyblock;

import net.fabricmc.api.ModInitializer;
import net.hypixel.api.HypixelAPI;
import net.hypixel.api.apache.ApacheHttpClient;
import net.minecraft.client.MinecraftClient;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NotEnoughSkyblock implements ModInitializer {
	public static HypixelAPI API;
	private UUID playerUUID;

	public static MinecraftClient mc = MinecraftClient.getInstance();

	public static final List<Pattern> COMMISSIONS = Stream.of(
					"(?:Titanium|Mithril|Hard Stone) Miner",
					"(?:Ice Walker|Goblin|Goblin Raid|Automaton|Sludge|Team Treasurite Member|Yog|Boss Corleone|Thyst) Slayer",
					"(?:Lava Springs|Cliffside Veins|Rampart's Quarry|Upper Mines|Royal Mines) Mithril",
					"(?:Lava Springs|Cliffside Veins|Rampart's Quarry|Upper Mines|Royal Mines) Titanium",
					"Goblin Raid",
					"(?:Powder Ghast|Star Sentry) Puncher",
					"(?<!Lucky )Raffle",
					"Lucky Raffle",
					"2x Mithril Powder Collector",
					"(?:Ruby|Amber|Sapphire|Jade|Amethyst|Topaz) Gemstone Collector",
					"(?:Amber|Sapphire|Jade|Amethyst|Topaz) Crystal Hunter",
					"Chest Looter"
			).map(s -> Pattern.compile("^.*(" + s + "): (\\d+\\.?\\d*%|DONE)"))
			.collect(Collectors.toList());

	public static List<Commission> commissionList = new ArrayList<>();


	@Override
	public void onInitialize() {



		String key = System.getProperty("apiKey", "99de5340-7e90-44f2-a974-71ce9ef7901b"); // arbitrary key, replace with your own to test or use the property
		API = new HypixelAPI(new ApacheHttpClient(UUID.fromString(key)));


		mc.getNetworkHandler().getPlayerList().forEach(playerListEntry -> {
			if(playerListEntry != null){
				for (Pattern pattern : COMMISSIONS){
					Matcher matcher = pattern.matcher(playerListEntry.getDisplayName().getString());
					if (matcher.find()) {
						commissionList.add(new Commission(matcher.group(1), matcher.group(2)));
					}

				}
			}
		});
	}
	public static class Commission{
		String commission;
		String progression;

		public Commission(String commission, String progression){
			this.commission = commission;
			this.progression = progression;
		}
	}
}