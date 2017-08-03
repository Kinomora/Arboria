package com.kinomora.rockbottom.mods.arboria.init;

import com.kinomora.rockbottom.mods.arboria.Arboria;
import com.kinomora.rockbottom.mods.arboria.tiles.MagicWood.*;
import com.kinomora.rockbottom.mods.arboria.tiles.TileCrystalizer;
import com.kinomora.rockbottom.mods.arboria.tiles.TileNode;
import com.kinomora.rockbottom.mods.arboria.tiles.TileSipaPump;
import com.kinomora.rockbottom.mods.arboria.tiles.TileSipaTank;
import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.tile.Tile;
import de.ellpeck.rockbottom.api.tile.TileBasic;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;

public class ArboriaTiles {

    //Tree Stuff
    public static Tile tileDaybreakSapling, tileShadowlessSapling, tileNightfallSapling, tileBewitchedSapling;
    public static Tile tileDuskWood, tileMoonlitWood, tileMorningWood, tileSunnyWood;
    public static Tile tileDuskBoards, tileMoonlitBoards, tileMorningBoards, tileSunnyBoards;
    public static Tile tileDuskLeaves, tileMoonlitLeaves, tileMorningLeaves, tileSunnyLeaves;

    //Magic stuff
    public static Tile tileNode;
    public static Tile tileSipaTank;
    public static Tile tileSipaPump;
    public static Tile tileCrystalizer;

    public static void init() {

        //Saplings
        tileBewitchedSapling = new TileBewitchedSapling(shortReg("tileBewitchedSapling")).register().setForceDrop();
        tileShadowlessSapling = new TileShadowlessSapling(shortReg("tileShadowlessSapling")).register().setForceDrop();
        tileNightfallSapling = new TileNightfallSapling(shortReg("tileNightfallSapling")).register().setForceDrop();
        tileDaybreakSapling = new TileDaybreakSapling(shortReg("tileDaybreakSapling")).register().setForceDrop();

        //Wood
        tileDuskWood = new TileDuskWood(shortReg("tileDuskWood")).register().setForceDrop();
        tileMoonlitWood = new TileMoonlitWood(shortReg("tileMoonlitWood")).register().setForceDrop();
        tileMorningWood = new TileMorningWood(shortReg("tileMorningWood")).register().setForceDrop();
        tileSunnyWood = new TileSunnyWood(shortReg("tileSunnyWood")).register().setForceDrop();

        //Boards
        tileDuskBoards = new TileBasic(shortReg("tileDuskBoards")).register().setForceDrop();
        tileMoonlitBoards = new TileBasic(shortReg("tileMoonlitBoards")).register().setForceDrop();
        tileMorningBoards = new TileBasic(shortReg("tileMorningBoards")).register().setForceDrop();
        tileSunnyBoards = new TileBasic(shortReg("tileSunnyBoards")).register().setForceDrop();

        //Leaves
        tileDuskLeaves = new TileMagicLeaves(shortReg("tileDuskLeaves")).register();
        tileMoonlitLeaves = new TileMagicLeaves(shortReg("tileMoonlitLeaves")).register();
        tileMorningLeaves = new TileMagicLeaves(shortReg("tileMorningLeaves")).register();
        tileSunnyLeaves = new TileMagicLeaves(shortReg("tileSunnyLeaves")).register();

        //Magic
        tileNode = new TileNode(shortReg("tileNode")).register();
        tileSipaTank = new TileSipaTank(shortReg("tileSipaTank")).register().setForceDrop();
        tileSipaPump = new TileSipaPump(shortReg("tileSipaPump")).register().setForceDrop();
        tileCrystalizer = new TileCrystalizer(shortReg("tileCrystalizer")).register().setForceDrop();
    }

    private static IResourceName shortReg(String tile){
        return RockBottomAPI.createRes(Arboria.instance, tile);
    }
}
