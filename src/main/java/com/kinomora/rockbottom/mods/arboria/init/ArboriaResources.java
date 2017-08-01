package com.kinomora.rockbottom.mods.arboria.init;

import de.ellpeck.rockbottom.api.GameContent;
import de.ellpeck.rockbottom.api.construction.resource.ResInfo;
import de.ellpeck.rockbottom.api.construction.resource.ResourceRegistry;

/**
 * Created by Kinomora on 8/1/2017.
 */
public class ArboriaResources {

    //Init Items


    //Init Tiles
    public static final String MOONLIT_LOG = "moonlit_log";
    public static final String MORNING_LOG = "morning_log";
    public static final String SUNNY_LOG = "sunny_log";
    public static final String DUSK_LOG = "dusk_log";
    public static final String MOONLIT_BOARDS = "moonlit_boards";
    public static final String MORNING_BOARDS = "morning_boards";
    public static final String SUNNY_BOARDS = "sunny_boards";
    public static final String DUSK_BOARDS = "dusk_boards";

    //Init Other


    public static void init() {
        /*** Register Items ***/


        /*** Register Tiles ***/
        //Saplings
        ResourceRegistry.addResources("SAPLING", new ResInfo(GameContent.TILE_SAPLING));
        ResourceRegistry.addResources("SAPLING", new ResInfo(ArboriaTiles.tileBewitchedSapling));
        ResourceRegistry.addResources("SAPLING", new ResInfo(ArboriaTiles.tileDaybreakSapling));
        ResourceRegistry.addResources("SAPLING", new ResInfo(ArboriaTiles.tileNightfallSapling));
        ResourceRegistry.addResources("SAPLING", new ResInfo(ArboriaTiles.tileShadowlessSapling));

        //Logs
        ResourceRegistry.addResources("WOOD_LOG", new ResInfo(ArboriaTiles.tileDuskWood));
        ResourceRegistry.addResources(DUSK_LOG, new ResInfo(ArboriaTiles.tileDuskWood));
        ResourceRegistry.addResources("WOOD_LOG", new ResInfo(ArboriaTiles.tileMoonlitWood));
        ResourceRegistry.addResources(MOONLIT_LOG, new ResInfo(ArboriaTiles.tileMoonlitWood));
        ResourceRegistry.addResources("WOOD_LOG", new ResInfo(ArboriaTiles.tileMorningWood));
        ResourceRegistry.addResources(MORNING_LOG, new ResInfo(ArboriaTiles.tileMorningWood));
        ResourceRegistry.addResources("WOOD_LOG", new ResInfo(ArboriaTiles.tileSunnyWood));
        ResourceRegistry.addResources(SUNNY_LOG, new ResInfo(ArboriaTiles.tileSunnyWood));

        //Boards
        ResourceRegistry.addResources("WOOD_BOARDS", new ResInfo(ArboriaTiles.tileDuskBoards));
        ResourceRegistry.addResources(DUSK_BOARDS, new ResInfo(ArboriaTiles.tileDuskBoards));
        ResourceRegistry.addResources("WOOD_BOARDS", new ResInfo(ArboriaTiles.tileMoonlitBoards));
        ResourceRegistry.addResources(MOONLIT_BOARDS, new ResInfo(ArboriaTiles.tileMoonlitBoards));
        ResourceRegistry.addResources("WOOD_BOARDS", new ResInfo(ArboriaTiles.tileMorningBoards));
        ResourceRegistry.addResources(MORNING_BOARDS, new ResInfo(ArboriaTiles.tileMorningBoards));
        ResourceRegistry.addResources("WOOD_BOARDS", new ResInfo(ArboriaTiles.tileSunnyBoards));
        ResourceRegistry.addResources(SUNNY_BOARDS, new ResInfo(ArboriaTiles.tileSunnyBoards));


        /*** Register Other ***/

    }
}
