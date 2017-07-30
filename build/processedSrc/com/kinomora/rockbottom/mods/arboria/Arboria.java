package com.kinomora.rockbottom.mods.arboria;

import de.ellpeck.rockbottom.api.IApiHandler;
import de.ellpeck.rockbottom.api.IGameInstance;
import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.event.IEventHandler;
import de.ellpeck.rockbottom.api.mod.IMod;
import de.ellpeck.rockbottom.api.tile.Tile;
import org.newdawn.slick.util.Log;

public class Arboria implements IMod {

    public static final String VERSION = "0.0.1";
    public static final String MOD_NAME = "Arboria";

    public static Arboria instance;

    //Tiles (blocks)
    public static Tile tileDaybreakSapling;
    public static Tile tileShadowlessSapling;
    public static Tile tileNightfallSapling;
    public static Tile tileBewitchedSapling;
    public static Tile tileBed;

    //Items
    //public static Item itemSapling;

    //Other

    public Arboria() { instance = this; }

    @Override
    public String getDisplayName() {
        return MOD_NAME;
    }

    @Override
    public String getId() {
        return MOD_NAME.toLowerCase();
    }

    @Override
    public String getVersion() {
        return VERSION;
    }

    @Override
    public String getResourceLocation() {
        return "/assets/" + MOD_NAME;
    }

    @Override
    public String getDescription() {
        return "A mod by Kinomora that adds magic and various other mechanics driven by Sipa power.";
    }

    @Override
    public void preInit(IGameInstance game, IApiHandler apiHandler, IEventHandler eventHandler) {
    }

    @Override
    public void init(IGameInstance game, IApiHandler apiHandler, IEventHandler eventHandler) {
        Log.info("Starting initializing " + MOD_NAME + " v" + VERSION + " for RockBottom.");

        //Initialize tiles (blocks)
        tileBewitchedSapling = new TileBewitchedSapling(RockBottomAPI.createRes(this, "tileBewitchedSapling")).register();
        tileShadowlessSapling = new TileShadowlessSapling(RockBottomAPI.createRes(this, "tileShadowlessSapling")).register();
        tileNightfallSapling = new TileNightfallSapling(RockBottomAPI.createRes(this, "tileNightfallSapling")).register();
        tileDaybreakSapling = new TileDaybreakSapling(RockBottomAPI.createRes(this, "tileDaybreakSapling")).register();
        tileBed = new TileBed(RockBottomAPI.createRes(this,"TileBed")).register();

        //Initialize items
        //itemPowerLineUnused = new ItemPowerLineUnused(RockBottomAPI.createRes(this,"itemPowerLineUnused")).register();

        //Add sipa tanks
    }

    @Override
    public void postInit(IGameInstance game, IApiHandler apiHandler, IEventHandler eventHandler) {
        Log.info("Finished initializing " + MOD_NAME + " v" + VERSION + ".");
    }
}
