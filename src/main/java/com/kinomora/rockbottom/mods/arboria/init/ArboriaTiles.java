package com.kinomora.rockbottom.mods.arboria.init;

import com.kinomora.rockbottom.mods.arboria.Arboria;
import com.kinomora.rockbottom.mods.arboria.tiles.TileBewitchedSapling;
import com.kinomora.rockbottom.mods.arboria.tiles.TileDaybreakSapling;
import com.kinomora.rockbottom.mods.arboria.tiles.TileNightfallSapling;
import com.kinomora.rockbottom.mods.arboria.tiles.TileShadowlessSapling;
import com.kinomora.rockbottom.mods.arboria.tiles.trees.*;
import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.tile.Tile;

public class ArboriaTiles {

    //Saplings
    public static Tile tileDaybreakSapling, tileShadowlessSapling, tileNightfallSapling, tileBewitchedSapling;

    //Wood
    public static Tile tileDuskWood, tileMoonlitWood, tileMorningWood, tileSunnyWood;

    //Boards
    public static Tile tileDuskBoards, tileMoonlitBoards, tileMorningBoards, tileSunnyBoards;

    //Leaves
    public static Tile tileDuskLeaves, tileMoonlitLeaves, tileMorningLeaves, tileSunnyLeaves;

    public static void init() {

        //Saplings
        tileBewitchedSapling = new TileBewitchedSapling(RockBottomAPI.createRes(Arboria.instance, "tileBewitchedSapling")).register();
        tileShadowlessSapling = new TileShadowlessSapling(RockBottomAPI.createRes(Arboria.instance, "tileShadowlessSapling")).register();
        tileNightfallSapling = new TileNightfallSapling(RockBottomAPI.createRes(Arboria.instance, "tileNightfallSapling")).register();
        tileDaybreakSapling = new TileDaybreakSapling(RockBottomAPI.createRes(Arboria.instance, "tileDaybreakSapling")).register();

        //Wood
        tileDuskWood = new TileDuskWood(RockBottomAPI.createRes(Arboria.instance, "tileDuskWood")).register();
        tileMoonlitWood = new TileMoonlitWood(RockBottomAPI.createRes(Arboria.instance, "tileMoonlitWood")).register();
        tileMorningWood = new TileMorningWood(RockBottomAPI.createRes(Arboria.instance, "tileMorningWood")).register();
        tileSunnyWood = new TileSunnyWood(RockBottomAPI.createRes(Arboria.instance, "tileSunnyWood")).register();

        //Boards
        tileDuskBoards = new TileDuskBoards(RockBottomAPI.createRes(Arboria.instance, "tileDuskBoards")).register();
        tileMoonlitBoards = new TileMoonlitBoards(RockBottomAPI.createRes(Arboria.instance, "tileMoonlitBoards")).register();
        tileMorningBoards = new TileMorningBoards(RockBottomAPI.createRes(Arboria.instance, "tileMorningBoards")).register();
        tileSunnyBoards = new TileSunnyBoards(RockBottomAPI.createRes(Arboria.instance, "tileSunnyBoards")).register();

        //Leaves
        tileDuskLeaves = new TileDuskLeaves(RockBottomAPI.createRes(Arboria.instance, "tileDuskLeaves")).register();
        tileMoonlitLeaves = new TileMoonlitLeaves(RockBottomAPI.createRes(Arboria.instance, "tileMoonlitLeaves")).register();
        tileMorningLeaves = new TileMorningLeaves(RockBottomAPI.createRes(Arboria.instance, "tileMorningLeaves")).register();
        tileSunnyLeaves = new TileSunnyLeaves(RockBottomAPI.createRes(Arboria.instance, "tileSunnyLeaves")).register();

    }
}
