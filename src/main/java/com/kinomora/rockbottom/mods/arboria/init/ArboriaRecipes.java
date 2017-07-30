package com.kinomora.rockbottom.mods.arboria.init;

import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.construction.BasicRecipe;
import de.ellpeck.rockbottom.api.item.ItemInstance;

public class ArboriaRecipes {

    public static void init(){

        //Planks from Wood
        RockBottomAPI.MANUAL_CONSTRUCTION_RECIPES.add(new BasicRecipe(new ItemInstance(ArboriaTiles.tileDuskBoards, 5) , new ItemInstance(ArboriaTiles.tileDuskWood)));
        RockBottomAPI.MANUAL_CONSTRUCTION_RECIPES.add(new BasicRecipe(new ItemInstance(ArboriaTiles.tileMorningBoards, 5) , new ItemInstance(ArboriaTiles.tileMorningWood)));
        RockBottomAPI.MANUAL_CONSTRUCTION_RECIPES.add(new BasicRecipe(new ItemInstance(ArboriaTiles.tileSunnyBoards, 5) , new ItemInstance(ArboriaTiles.tileSunnyWood)));
        RockBottomAPI.MANUAL_CONSTRUCTION_RECIPES.add(new BasicRecipe(new ItemInstance(ArboriaTiles.tileMoonlitBoards, 5) , new ItemInstance(ArboriaTiles.tileMoonlitWood)));
    }
}
