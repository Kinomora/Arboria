package com.kinomora.rockbottom.mods.arboria.world.gen;

import com.kinomora.rockbottom.mods.arboria.tiles.MagicWood.TileMagicWood;
import de.ellpeck.rockbottom.api.Constants;
import de.ellpeck.rockbottom.api.GameContent;
import de.ellpeck.rockbottom.api.tile.state.TileState;
import de.ellpeck.rockbottom.api.util.Util;
import de.ellpeck.rockbottom.api.world.IChunk;
import de.ellpeck.rockbottom.api.world.IWorld;
import de.ellpeck.rockbottom.api.world.TileLayer;
import de.ellpeck.rockbottom.api.world.gen.IWorldGenerator;
import org.newdawn.slick.util.Log;

import java.util.Random;

public abstract class GenTreeFull implements IWorldGenerator {

    @Override
    public boolean shouldGenerate(IWorld world, IChunk chunk, Random rand) {
        return chunk.getGridY() == 0;
    }

    @Override
    public void generate(IWorld world, IChunk chunk, Random rand) {

        int thisHeight = maxHeight() - rand.nextInt(3);
        int halfHeight = thisHeight / 2;
        int crownRad = halfHeight - rand.nextInt(2);
        int startX = chunk.getX() + crownRad + 1 + rand.nextInt(Constants.CHUNK_SIZE - 2 * crownRad - 1);
        int startY = chunk.getLowestAirUpwards(TileLayer.MAIN, startX, 0);
        boolean spawn = true;

        //Log.info("radius is " + crownRad);

        for (int checkY = startY; checkY <= startY + thisHeight + crownRad + 1; checkY++) {
            for (int checkX = startX - crownRad - 1; checkX <= startX + crownRad + 1; checkX++) {
                Log.info("Checking coordinates: " + checkX + ", " + checkY + " contains tile " + world.getState(TileLayer.MAIN, checkX, checkY).getTile().getName());
                if (world.getState(TileLayer.MAIN, checkX, checkY).getTile() == GameContent.TILE_LOG || world.getState(TileLayer.MAIN, checkX, checkY).getTile().getName() == GameContent.TILE_LEAVES.getName()) {
                    spawn = false;
                    Log.info("Found " + world.getState(TileLayer.MAIN, checkX, checkY).getTile().getName() + " at " + checkX + ", " + checkY);
                }
            }
        }
        if (spawn) {
            if (spawnChance() != 0) {
                if (rand.nextInt(spawnChance()) == 0) {
                    if (world.getState(startX, startY - 1).getTile() == GameContent.TILE_GRASS) {
                        for (int y = 0; y <= thisHeight; y++) {
                            if (rand.nextInt(2) == 0) {
                                world.setState(startX, startY + y, getWood().prop(TileMagicWood.HAS_NODE, true));
                            } else world.setState(startX, startY + y, getWood());
                        }
                        for (int t = 0; t < 360; t++) {
                            double a = Math.PI * ((double) t / 180);
                            double crownX = crownRad * Math.cos(a);
                            double crownY = crownRad * Math.sin(a);

                            if (crownY > 0) {
                                for (int y = 0; y <= Util.floor(crownY); y++) {
                                    if (crownX > 0) {
                                        for (int x = 0; x <= Util.floor(crownX); x++) {
                                            if (!(world.getState(startX + x, startY + thisHeight + y).getTile() instanceof TileMagicWood)) {
                                                world.setState(startX + x, startY + thisHeight + y, getLeaves());
                                            }
                                        }
                                    } else {
                                        for (int x = Util.ceil(crownX); x <= 0; x++) {
                                            if (!(world.getState(startX + x, startY + thisHeight + y).getTile() instanceof TileMagicWood)) {
                                                world.setState(startX + x, startY + thisHeight + y, getLeaves());
                                            }
                                        }
                                    }
                                }
                            } else {
                                for (int y = Util.ceil(crownY); y <= 0; y++) {
                                    if (crownX > 0) {
                                        for (int x = 0; x <= Util.floor(crownX); x++) {
                                            if (!(world.getState(startX + x, startY + thisHeight + y).getTile() instanceof TileMagicWood)) {
                                                world.setState(startX + x, startY + thisHeight + y, getLeaves());
                                            }
                                        }
                                    } else {
                                        for (int x = Util.ceil(crownX); x <= 0; x++) {
                                            if (!(world.getState(startX + x, startY + thisHeight + y).getTile() instanceof TileMagicWood)) {
                                                world.setState(startX + x, startY + thisHeight + y, getLeaves());
                                            }
                                        }
                                    }
                                }
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
