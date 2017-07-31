package com.kinomora.rockbottom.mods.arboria.world.gen;

import com.kinomora.rockbottom.mods.arboria.init.ArboriaTiles;
import de.ellpeck.rockbottom.api.Constants;
import de.ellpeck.rockbottom.api.world.IChunk;
import de.ellpeck.rockbottom.api.world.IWorld;
import de.ellpeck.rockbottom.api.world.TileLayer;
import de.ellpeck.rockbottom.api.world.gen.IWorldGenerator;

import java.util.Random;

public class GenNode implements IWorldGenerator {
    @Override
    public boolean shouldGenerate(IWorld world, IChunk chunk, Random rand) {
        return chunk.getGridY() >= 0;
    }

    @Override
    public void generate(IWorld world, IChunk chunk, Random rand) {
        if (rand.nextInt(20) == 0) {
            int x = chunk.getX() + rand.nextInt(Constants.CHUNK_SIZE);
            int y = chunk.getY() + rand.nextInt(Constants.CHUNK_SIZE);
            if (world.getState(TileLayer.MAIN, x, y).getTile().isAir()) {
                world.setState(x, y, ArboriaTiles.tileNode.getDefState());
            }
        }
    }

    @Override
    public int getPriority() {
        return 200;
    }
}
