package com.kinomora.rockbottom.mods.arboria.world.gen;

import com.kinomora.rockbottom.mods.arboria.init.ArboriaTiles;
import de.ellpeck.rockbottom.api.tile.state.TileState;

public class GenDaybreakSapling extends GenSapling {
    @Override
    public TileState getSapling() {
        return ArboriaTiles.tileDaybreakSapling.getDefState();
    }
}
