package com.kinomora.rockbottom.mods.arboria.init;

import com.kinomora.rockbottom.mods.arboria.Arboria;
import com.kinomora.rockbottom.mods.arboria.tiles.TileBewitchedSapling;
import com.kinomora.rockbottom.mods.arboria.tiles.TileDaybreakSapling;
import com.kinomora.rockbottom.mods.arboria.tiles.TileNightfallSapling;
import com.kinomora.rockbottom.mods.arboria.tiles.TileShadowlessSapling;
import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.tile.Tile;
import de.ellpeck.rockbottom.api.tile.TileBasic;

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
        tileBewitchedSapling = new TileBewitchedSapling(RockBottomAPI.createRes(Arboria.instance, "tileBewitchedSapling")).register().setForceDrop();
        tileShadowlessSapling = new TileShadowlessSapling(RockBottomAPI.createRes(Arboria.instance, "tileShadowlessSapling")).register().setForceDrop();
        tileNightfallSapling = new TileNightfallSapling(RockBottomAPI.createRes(Arboria.instance, "tileNightfallSapling")).register().setForceDrop();
        tileDaybreakSapling = new TileDaybreakSapling(RockBottomAPI.createRes(Arboria.instance, "tileDaybreakSapling")).register().setForceDrop();

        //Wood
        tileDuskWood = new TileBasic(RockBottomAPI.createRes(Arboria.instance, "tileDuskWood")).register();
        tileMoonlitWood = new TileBasic(RockBottomAPI.createRes(Arboria.instance, "tileMoonlitWood")).register();
        tileMorningWood = new TileBasic(RockBottomAPI.createRes(Arboria.instance, "tileMorningWood")).register();
        tileSunnyWood = new TileBasic(RockBottomAPI.createRes(Arboria.instance, "tileSunnyWood")).register();

        //Boards
        tileDuskBoards = new TileBasic(RockBottomAPI.createRes(Arboria.instance, "tileDuskBoards")).register();
        tileMoonlitBoards = new TileBasic(RockBottomAPI.createRes(Arboria.instance, "tileMoonlitBoards")).register();
        tileMorningBoards = new TileBasic(RockBottomAPI.createRes(Arboria.instance, "tileMorningBoards")).register();
        tileSunnyBoards = new TileBasic(RockBottomAPI.createRes(Arboria.instance, "tileSunnyBoards")).register();

        //Leaves
        tileDuskLeaves = new TileBasic(RockBottomAPI.createRes(Arboria.instance, "tileDuskLeaves")).register();
        tileMoonlitLeaves = new TileBasic(RockBottomAPI.createRes(Arboria.instance, "tileMoonlitLeaves")).register();
        tileMorningLeaves = new TileBasic(RockBottomAPI.createRes(Arboria.instance, "tileMorningLeaves")).register();
        tileSunnyLeaves = new TileBasic(RockBottomAPI.createRes(Arboria.instance, "tileSunnyLeaves")).register();
    }
}
