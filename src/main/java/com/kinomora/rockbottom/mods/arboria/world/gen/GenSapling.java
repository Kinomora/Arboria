package com.kinomora.rockbottom.mods.arboria.world.gen;

import de.ellpeck.rockbottom.api.Constants;
import de.ellpeck.rockbottom.api.GameContent;
import de.ellpeck.rockbottom.api.tile.state.TileState;
import de.ellpeck.rockbottom.api.world.IChunk;
import de.ellpeck.rockbottom.api.world.IWorld;
import de.ellpeck.rockbottom.api.world.TileLayer;
import de.ellpeck.rockbottom.api.world.gen.IWorldGenerator;
import org.newdawn.slick.util.Log;

import java.util.Random;

public abstract class GenSapling implements IWorldGenerator {
    @Override
    public boolean shouldGenerate(IWorld world, IChunk chunk, Random rand) {
        return chunk.getGridY() == 0;
    }

    @Override
    public void generate(IWorld world, IChunk chunk, Random rand) {

        boolean spawned = false;
        while (!spawned) {
            int x = chunk.getX() + rand.nextInt(Constants.CHUNK_SIZE - 1) - 1;
            int y = 0;
            while (world.getState(TileLayer.MAIN, x, y).getTile() != GameContent.TILE_GRASS && y < 10) {
                y++;
            }
            if (world.getState(TileLayer.MAIN, x, y).getTile() == GameContent.TILE_GRASS) {
                world.setState(x, y + 1, getSapling());
                spawned = true;
            }
        }
    }


    @Override
    public int getPriority() {
        return 0;
    }

    public abstract TileState getSapling();

}
