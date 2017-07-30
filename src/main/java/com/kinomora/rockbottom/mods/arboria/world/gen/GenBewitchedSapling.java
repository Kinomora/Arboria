package com.kinomora.rockbottom.mods.arboria.world.gen;

import com.kinomora.rockbottom.mods.arboria.init.ArboriaTiles;
import de.ellpeck.rockbottom.api.tile.state.TileState;

public class GenBewitchedSapling extends GenSapling {
    @Override
    public int spawnChance() {
        return 5;
    }

    @Override
    public TileState getSapling() {
        return ArboriaTiles.tileBewitchedSapling.getDefState();
    }


}
