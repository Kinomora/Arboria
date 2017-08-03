package com.kinomora.rockbottom.mods.arboria.world.gen;

import com.kinomora.rockbottom.mods.arboria.init.ArboriaTiles;
import com.kinomora.rockbottom.mods.arboria.tiles.MagicWood.TileMagicWood;
import de.ellpeck.rockbottom.api.tile.state.TileState;

public class TestGenTree extends GenTree {

    @Override
    public int getPriority() {
        return 1000;
    }

    @Override
    public int spawnChance() {
        return 1;
    }

    @Override
    public TileState getWood() {
        return ArboriaTiles.tileMorningWood.getDefState().prop(TileMagicWood.IS_NATURAL, true);
    }

    @Override
    public TileState getLeaves() {
        return ArboriaTiles.tileMorningLeaves.getDefState().prop(TileMagicWood.IS_NATURAL, true);
    }

    @Override
    public int maxHeight() {
        return 10;
    }
}
