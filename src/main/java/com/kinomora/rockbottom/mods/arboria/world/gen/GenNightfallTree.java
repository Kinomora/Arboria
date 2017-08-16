package com.kinomora.rockbottom.mods.arboria.world.gen;

import com.kinomora.rockbottom.mods.arboria.init.ArboriaTiles;
import com.kinomora.rockbottom.mods.arboria.tiles.magicwood.TileMagicWood;
import de.ellpeck.rockbottom.api.tile.state.TileState;

public class GenNightfallTree extends GenTreeCrescent {
    @Override
    public int spawnChance() {
        return 1;
    }

    @Override
    public TileState getWood() {
        return ArboriaTiles.tileDuskWood.getDefState().prop(TileMagicWood.IS_NATURAL, true);
    }

    @Override
    public TileState getLeaves() {
        return ArboriaTiles.tileDuskLeaves.getDefState().prop(TileMagicWood.IS_NATURAL, true);
    }

    @Override
    public int maxHeight() {
        return 10;
    }

    @Override
    public int getPriority() {
        return 302;
    }
}
