package com.darth.airdropmc.config;

import java.util.ArrayList;
import java.util.List;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class AirDropMcCommonConfigs {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ConfigValue<List<? extends String>> MOBFORSPAWN;
	public static final ConfigValue<List<? extends Integer>> AMOUNTTOSPAWN;
	public static final ConfigValue<Integer> TIMEBETWEENAIRDROPS;
	public static final ConfigValue<Integer> TIMETOWAITAFTERTHESPAWNOFTHEAIRDROP;
	public static final ConfigValue<Integer> AIRDROPSPAWNRANGE;
	
	static {
		BUILDER.push("Configs for airdropmc mod");
		MOBFORSPAWN=BUILDER.comment("specify the normal entities ").defineList("mobsThatShouldBeSpawned when an airdrop arrives", (List<String>)new ArrayList<String>(), (Object t) -> t instanceof String);
		AMOUNTTOSPAWN=BUILDER.comment("the amount to spawn for each mob").defineList("AmountPerMob", (List<Integer>)new ArrayList<Integer>(), (Object t)-> t instanceof Integer);
		TIMETOWAITAFTERTHESPAWNOFTHEAIRDROP = BUILDER.comment("how much time(seconds) we should wait after the public announcement of the airdrop to spawn it ").define("waittime", 30);
		TIMEBETWEENAIRDROPS = BUILDER.comment("time(seconds) between airdrops 3600=1h").define("TimeBetweenAirdrops",600);
		AIRDROPSPAWNRANGE= BUILDER.comment("range around spawn where the airdrop can spawn").define("AirDropSpawnRange", 2500);
		SPEC=BUILDER.build();
	}
	
}
