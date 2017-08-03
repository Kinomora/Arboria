package com.kinomora.rockbottom.mods.arboria.init;

import com.kinomora.rockbottom.mods.arboria.world.gen.*;
import de.ellpeck.rockbottom.api.RockBottomAPI;

public class ArboriaGen {
    public static void init() {
        RockBottomAPI.WORLD_GENERATORS.add(GenDaybreakSapling.class);
        RockBottomAPI.WORLD_GENERATORS.add(GenNightfallSapling.class);
        RockBottomAPI.WORLD_GENERATORS.add(GenBewitchedSapling.class);
        RockBottomAPI.WORLD_GENERATORS.add(GenShadowlessSapling.class);
        RockBottomAPI.WORLD_GENERATORS.add(GenNode.class);
        RockBottomAPI.WORLD_GENERATORS.add(TestGenTree.class);
    }
}
