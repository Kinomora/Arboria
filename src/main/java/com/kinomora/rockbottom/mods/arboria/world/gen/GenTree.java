package com.kinomora.rockbottom.mods.arboria.world.gen;

import de.ellpeck.rockbottom.api.world.IChunk;
import de.ellpeck.rockbottom.api.world.IWorld;
import de.ellpeck.rockbottom.api.world.gen.IWorldGenerator;

import java.util.Random;

public class GenTree implements IWorldGenerator {

    @Override
    public boolean shouldGenerate(IWorld world, IChunk chunk, Random rand) {
        return false;
    }

    @Override
    public void generate(IWorld world, IChunk chunk, Random rand) {

    }

    @Override
    public int getPriority() {
        return 0;
    }
}
