package com.kinomora.rockbottom.mods.arboria.world.gen;

import com.kinomora.rockbottom.mods.arboria.tiles.MagicWood.TileMagicWood;
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
        return chunk.getGridY() == 0;
    }

    @Override
    public void generate(IWorld world, IChunk chunk, Random rand) {

        int thisHeight = maxHeight() - rand.nextInt(3);
        int halfHeight = thisHeight / 2;

        if (spawnChance() != 0) {
            if (rand.nextInt(spawnChance()) == 0) {
                int startX = chunk.getX() + rand.nextInt(Constants.CHUNK_SIZE);
                int startY = chunk.getLowestAirUpwards(TileLayer.MAIN, startX, 0);

                if (world.getState(startX, startY - 1).getTile() == GameContent.TILE_GRASS) {
                    for (int y = 0; y <= thisHeight; y++) {
                        if (rand.nextInt(2) == 0) {
                            world.setState(startX, startY + y, getWood().prop(TileMagicWood.HAS_NODE, true));
                        } else  world.setState(startX, startY + y, getWood());
                        if (y >= halfHeight && y < thisHeight * 7/8) {
                            for (int x = -2; x <= 2; x++) {
                                if (x != 0) {
                                    world.setState(startX + x, startY + y, getLeaves());
                                }
                            }
                        } else if (y >= halfHeight * 3 / 2) {
                            for (int x = -1; x <= 1; x++) {
                                if (x != 0) {
                                    world.setState(startX + x, startY + y, getLeaves());
                                }
                            }
                        }
                        if (y == thisHeight) {
                            for (int x = -1; x <= 1; x++) {
                                world.setState(startX+x, startY + y, getLeaves());
                                world.setState(startX + x, startY + y + 1, getLeaves());
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public int getPriority() {
        return 0;
    }

    public abstract int spawnChance();

    public abstract TileState getWood();

    public abstract TileState getLeaves();

    public abstract int maxHeight();

}
