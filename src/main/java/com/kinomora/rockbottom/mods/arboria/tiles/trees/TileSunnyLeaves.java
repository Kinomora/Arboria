package com.kinomora.rockbottom.mods.arboria.tiles.trees;

import com.kinomora.rockbottom.mods.arboria.Arboria;
import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.assets.IAssetManager;
import de.ellpeck.rockbottom.api.item.ItemInstance;
import de.ellpeck.rockbottom.api.tile.TileBasic;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;
import de.ellpeck.rockbottom.api.world.IWorld;
import de.ellpeck.rockbottom.api.world.TileLayer;

import java.util.List;

/**
 * Created by Kinomora on 7/30/2017.
 */
public class TileSunnyLeaves  extends TileBasic {

    //Variables
    private static final String tileName = "tileDuskBoards";
    private static final IResourceName LOC = RockBottomAPI.createRes(Arboria.instance, "details." + tileName);

    //Constructor
    public TileSunnyLeaves(IResourceName name) {
        super(name);
    }

    @Override
    public int getLight(IWorld world, int x, int y, TileLayer layer) {
        return 3;
    }

    @Override
    public void describeItem(IAssetManager manager, ItemInstance instance, List<String> desc, boolean isAdvanced) {
        super.describeItem(manager, instance, desc, isAdvanced);
        desc.addAll(manager.getFont().splitTextToLength(500, 1f, true, manager.localize(LOC)));
    }

}