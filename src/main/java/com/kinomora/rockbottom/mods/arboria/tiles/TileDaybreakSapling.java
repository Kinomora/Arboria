package com.kinomora.rockbottom.mods.arboria.tiles;

import com.kinomora.rockbottom.mods.arboria.Arboria;
import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.assets.IAssetManager;
import de.ellpeck.rockbottom.api.entity.Entity;
import de.ellpeck.rockbottom.api.item.ItemInstance;
import de.ellpeck.rockbottom.api.render.tile.ITileRenderer;
import de.ellpeck.rockbottom.api.tile.TileBasic;
import de.ellpeck.rockbottom.api.util.BoundBox;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;
import de.ellpeck.rockbottom.api.world.IWorld;
import de.ellpeck.rockbottom.api.world.TileLayer;

import java.util.List;

/**
 * Created by Kinomora on 7/13/2017.
 */
public class TileDaybreakSapling extends TileBasic {
    //Variables
    private static final String tileName = "tileDaybreakSapling";
    private static final IResourceName LOC = RockBottomAPI.createRes(Arboria.instance, "details." + tileName);

    //Constructor
    public TileDaybreakSapling(IResourceName name) {
        super(name);
    }

    public int getLight(IWorld world, int x, int y, TileLayer layer) {
        return 3;
    }

    public void onDestroyed(IWorld world, int x, int y, Entity destroyer, TileLayer layer, boolean forceDrop) {
        super.onDestroyed(world, x, y, destroyer, layer, forceDrop);
    }

    public BoundBox getBoundBox(IWorld world, int x, int y) {
        return null;
    }

    @Override
    public void describeItem(IAssetManager manager, ItemInstance instance, List<String> desc, boolean isAdvanced) {
        super.describeItem(manager, instance, desc, isAdvanced);
        desc.addAll(manager.getFont().splitTextToLength(500, 1f, true, manager.localize(LOC)));
    }

    @Override
    protected ITileRenderer createRenderer(IResourceName name) {
        return super.createRenderer(name);
    }

    @Override
    public boolean isFullTile() {
        return false;
    }
}
