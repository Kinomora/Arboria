package com.kinomora.rockbottom.mods.arboria.init;

import com.kinomora.rockbottom.mods.arboria.Arboria;
import com.kinomora.rockbottom.mods.arboria.tiles.*;
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

    public static Tile tileNode;

    //Sipa stuff
    public static Tile tileSipaTank;
    public static Tile tileSipaPump;

    public static void init() {

        //Saplings
        tileBewitchedSapling = new TileBewitchedSapling(RockBottomAPI.createRes(Arboria.instance, "tileBewitchedSapling")).register().setForceDrop();
        tileShadowlessSapling = new TileShadowlessSapling(RockBottomAPI.createRes(Arboria.instance, "tileShadowlessSapling")).register().setForceDrop();
        tileNightfallSapling = new TileNightfallSapling(RockBottomAPI.createRes(Arboria.instance, "tileNightfallSapling")).register().setForceDrop();
        tileDaybreakSapling = new TileDaybreakSapling(RockBottomAPI.createRes(Arboria.instance, "tileDaybreakSapling")).register().setForceDrop();

        //Wood
        tileDuskWood = new TileDuskWood(RockBottomAPI.createRes(Arboria.instance, "tileDuskWood")).register().setForceDrop();
        tileMoonlitWood = new TileMoonlitWood(RockBottomAPI.createRes(Arboria.instance, "tileMoonlitWood")).register().setForceDrop();
        tileMorningWood = new TileMorningWood(RockBottomAPI.createRes(Arboria.instance, "tileMorningWood")).register().setForceDrop();
        tileSunnyWood = new TileSunnyWood(RockBottomAPI.createRes(Arboria.instance, "tileSunnyWood")).register().setForceDrop();

        //Boards
        tileDuskBoards = new TileBasic(RockBottomAPI.createRes(Arboria.instance, "tileDuskBoards")).register().setForceDrop();
        tileMoonlitBoards = new TileBasic(RockBottomAPI.createRes(Arboria.instance, "tileMoonlitBoards")).register().setForceDrop();
        tileMorningBoards = new TileBasic(RockBottomAPI.createRes(Arboria.instance, "tileMorningBoards")).register().setForceDrop();
        tileSunnyBoards = new TileBasic(RockBottomAPI.createRes(Arboria.instance, "tileSunnyBoards")).register().setForceDrop();

        //Leaves
        tileDuskLeaves = new TileBasic(RockBottomAPI.createRes(Arboria.instance, "tileDuskLeaves")).register();
        tileMoonlitLeaves = new TileBasic(RockBottomAPI.createRes(Arboria.instance, "tileMoonlitLeaves")).register();
        tileMorningLeaves = new TileBasic(RockBottomAPI.createRes(Arboria.instance, "tileMorningLeaves")).register();
        tileSunnyLeaves = new TileBasic(RockBottomAPI.createRes(Arboria.instance, "tileSunnyLeaves")).register();

        tileNode = new TileNode(RockBottomAPI.createRes(Arboria.instance, "tileNode")).register();
        tileSipaTank = new TileSipaTank(RockBottomAPI.createRes(Arboria.instance, "tileSipaTank")).register();
        tileSipaPump = new TileSipaPump(RockBottomAPI.createRes(Arboria.instance, "tileSipaPump")).register();
    }
}
