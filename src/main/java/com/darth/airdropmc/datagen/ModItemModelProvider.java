package com.darth.airdropmc.datagen;

import com.darth.airdropmc.AirDropMc;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider{

	public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, AirDropMc.MOD_ID, existingFileHelper);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void registerModels() {
		// TODO Auto-generated method stub
		
	}

}
