package com.kinomora.rockbottom.mods.arboria;

import com.kinomora.rockbottom.mods.arboria.init.ArboriaGen;
import com.kinomora.rockbottom.mods.arboria.init.ArboriaRecipes;
import com.kinomora.rockbottom.mods.arboria.init.ArboriaResources;
import com.kinomora.rockbottom.mods.arboria.init.ArboriaTiles;
import de.ellpeck.rockbottom.api.IApiHandler;
import de.ellpeck.rockbottom.api.IGameInstance;
import de.ellpeck.rockbottom.api.event.IEventHandler;
import de.ellpeck.rockbottom.api.mod.IMod;
import org.newdawn.slick.util.Log;

public class Arboria implements IMod {

    private static final String VERSION = "0.0.1";
    private static final String MOD_NAME = "Arboria";

    public static Arboria instance;

    public Arboria() {
        instance = this;
    }

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
        return "A mod by Kinomora & Quarris that adds magic and various other mechanics driven by Sipa power.";
    }

    @Override
    public void preInit(IGameInstance game, IApiHandler apiHandler, IEventHandler eventHandler) {
    }

    @Override
    public void init(IGameInstance game, IApiHandler apiHandler, IEventHandler eventHandler) {
        Log.info("Starting initializing " + MOD_NAME + " v" + VERSION + " for RockBottom.");

    }

    @Override
    public void postInit(IGameInstance game, IApiHandler apiHandler, IEventHandler eventHandler) {
        Log.info("Finished initializing " + MOD_NAME + " v" + VERSION + ".");

        //Register Tiles first
        ArboriaTiles.init();

        //Resources need Tiles registered
        ArboriaResources.init();

        //Recipes need Resources registered
        ArboriaRecipes.init();

        //Generation needs Tiles registered
        ArboriaGen.init();
    }
}
