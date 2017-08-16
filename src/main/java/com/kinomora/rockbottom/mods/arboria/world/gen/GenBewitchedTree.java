package com.kinomora.rockbottom.mods.arboria.world.gen;

import com.kinomora.rockbottom.mods.arboria.init.ArboriaTiles;
import com.kinomora.rockbottom.mods.arboria.tiles.magicwood.TileMagicWood;
import de.ellpeck.rockbottom.api.tile.state.TileState;

public class GenBewitchedTree extends GenTreeFull {

    @Override
    public TileState getWood() {
        return ArboriaTiles.tileMoonlitWood.getDefState().prop(TileMagicWood.IS_NATURAL, true);
    }

    @Override
    public TileState getLeaves() {
        return ArboriaTiles.tileMoonlitLeaves.getDefState().prop(TileMagicWood.IS_NATURAL, true);
    }

    @Override
    public int spawnChance() {
        return 1;
    }

    @Override
    public int getPriority() {
        return 303;
    }

    @Override
    public int maxHeight() {
        return 8;
    }
}
