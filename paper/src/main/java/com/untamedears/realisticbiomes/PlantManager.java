package com.untamedears.realisticbiomes;

import com.untamedears.realisticbiomes.model.Plant;
import com.untamedears.realisticbiomes.model.RBChunkCache;
import org.bukkit.Location;
import org.bukkit.block.Block;
import vg.civcraft.mc.civmodcore.world.locations.chunkmeta.api.BlockBasedChunkMetaView;
import vg.civcraft.mc.civmodcore.world.locations.chunkmeta.block.table.TableBasedDataObject;
import vg.civcraft.mc.civmodcore.world.locations.chunkmeta.block.table.TableStorageEngine;

public class PlantManager {

	private BlockBasedChunkMetaView<RBChunkCache, TableBasedDataObject, TableStorageEngine<Plant>> chunkMetaData;

	PlantManager(BlockBasedChunkMetaView<RBChunkCache, TableBasedDataObject, TableStorageEngine<Plant>> chunkMetaData) {
		this.chunkMetaData = chunkMetaData;
	}

	public void deletePlant(Plant plant) {
		chunkMetaData.remove(plant);
	}

	public Plant getPlant(Block block) {
		return getPlant(block.getLocation());
	}

	public Plant getPlant(Location location) {
		return (Plant) chunkMetaData.get(location);
	}

	public void putPlant(Plant plant) {
		chunkMetaData.put(plant);
	}

	void shutDown() {
		chunkMetaData.disable();
	}

}
