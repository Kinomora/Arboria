package com.kinomora.rockbottom.mods.arboria.init;

import com.kinomora.rockbottom.mods.arboria.world.gen.GenDaybreakSapling;
import de.ellpeck.rockbottom.api.RockBottomAPI;

public class ArboriaGen {

    public static void init() {

        RockBottomAPI.WORLD_GENERATORS.add(GenDaybreakSapling.class);

    }
}
