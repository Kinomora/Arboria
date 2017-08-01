package com.kinomora.rockbottom.mods.arboria.world.gen;

import de.ellpeck.rockbottom.api.Constants;
import de.ellpeck.rockbottom.api.GameContent;
import de.ellpeck.rockbottom.api.tile.state.TileState;
import de.ellpeck.rockbottom.api.world.IChunk;
import de.ellpeck.rockbottom.api.world.IWorld;
import de.ellpeck.rockbottom.api.world.TileLayer;
import de.ellpeck.rockbottom.api.world.gen.IWorldGenerator;

import java.util.Random;

public abstract class GenTree implements IWorldGenerator {

    @Override
    public boolean shouldGenerate(IWorld world, IChunk chunk, Random rand) {
        return false;
    }

    @Override
    public void generate(IWorld world, IChunk chunk, Random rand) {

        if (spawnChance() != 0) {
            if (rand.nextInt(spawnChance()) == 0) {
                int x = chunk.getX() + rand.nextInt(Constants.CHUNK_SIZE);
                int y = chunk.getLowestAirUpwards(TileLayer.MAIN, x, 0);
                if (world.getState(x, y - 1).getTile() == GameContent.TILE_GRASS) {




                }
            }
        }



    }

    @Override
    public int getPriority() {
        return 200;
    }

    public abstract int spawnChance();

    public abstract TileState getWood();

    public abstract TileState getLeaves();

    public abstract int maxHeight();

}
