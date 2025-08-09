package com.darth.airdropmc.datagen;

import com.darth.airdropmc.AirDropMc;
import com.darth.airdropmc.blocks.ModBlocks;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider{

	public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
		super(output, AirDropMc.MOD_ID, exFileHelper);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void registerStatesAndModels() {
		AirDropMc.LOGGER.debug("registring models");
		simpleBlock(ModBlocks.WEAPONS_CREATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/weapons_create")));
	}
	
	@SuppressWarnings("unused")
	private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
		simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
	}

}
