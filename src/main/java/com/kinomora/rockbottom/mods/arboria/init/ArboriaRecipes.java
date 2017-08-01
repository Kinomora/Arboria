package com.kinomora.rockbottom.mods.arboria.init;

import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.construction.BasicRecipe;
import de.ellpeck.rockbottom.api.construction.resource.ResUseInfo;
import de.ellpeck.rockbottom.api.item.ItemInstance;

public class ArboriaRecipes {

    public static void init(){

        //Planks from Wood
        RockBottomAPI.MANUAL_CONSTRUCTION_RECIPES.add(new BasicRecipe(new ItemInstance(ArboriaTiles.tileDuskBoards, 5) , new ResUseInfo(ArboriaResources.DUSK_LOG)));
        RockBottomAPI.MANUAL_CONSTRUCTION_RECIPES.add(new BasicRecipe(new ItemInstance(ArboriaTiles.tileMorningBoards, 5) , new ResUseInfo(ArboriaResources.MORNING_LOG)));
        RockBottomAPI.MANUAL_CONSTRUCTION_RECIPES.add(new BasicRecipe(new ItemInstance(ArboriaTiles.tileSunnyBoards, 5) , new ResUseInfo(ArboriaResources.SUNNY_LOG)));
        RockBottomAPI.MANUAL_CONSTRUCTION_RECIPES.add(new BasicRecipe(new ItemInstance(ArboriaTiles.tileMoonlitBoards, 5) , new ResUseInfo(ArboriaResources.MOONLIT_LOG)));
    }
}
