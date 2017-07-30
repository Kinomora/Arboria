package com.kinomora.rockbottom.mods.arboria.init;

import com.kinomora.rockbottom.mods.arboria.Arboria;
import com.kinomora.rockbottom.mods.arboria.tiles.TileBewitchedSapling;
import com.kinomora.rockbottom.mods.arboria.tiles.TileDaybreakSapling;
import com.kinomora.rockbottom.mods.arboria.tiles.TileNightfallSapling;
import com.kinomora.rockbottom.mods.arboria.tiles.TileShadowlessSapling;
import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.tile.Tile;

public class ArboriaTiles {

    public static Tile tileDaybreakSapling;
    public static Tile tileShadowlessSapling;
    public static Tile tileNightfallSapling;
    public static Tile tileBewitchedSapling;

    public static void init() {

        tileBewitchedSapling = new TileBewitchedSapling(RockBottomAPI.createRes(Arboria.instance, "tileBewitchedSapling")).register();
        tileShadowlessSapling = new TileShadowlessSapling(RockBottomAPI.createRes(Arboria.instance, "tileShadowlessSapling")).register();
        tileNightfallSapling = new TileNightfallSapling(RockBottomAPI.createRes(Arboria.instance, "tileNightfallSapling")).register();
        tileDaybreakSapling = new TileDaybreakSapling(RockBottomAPI.createRes(Arboria.instance, "tileDaybreakSapling")).register();

    }
}
