package com.kinomora.rockbottom.mods.arboria.tiles;

import com.kinomora.rockbottom.mods.arboria.Arboria;
import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.assets.IAssetManager;
import de.ellpeck.rockbottom.api.item.ItemInstance;
import de.ellpeck.rockbottom.api.tile.MultiTile;
import de.ellpeck.rockbottom.api.util.BoundBox;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;
import de.ellpeck.rockbottom.api.world.IWorld;

import java.util.List;

/**
 * Created by Kinomora on 8/3/2017.
 */
public class TileCrystalizer extends MultiTile {

    private static final String tileName = "tileCrystalizer";
    private static final IResourceName LOC = RockBottomAPI.createRes(Arboria.instance,"details." + tileName);
    private final BoundBox box = new BoundBox(0, 0, 1, 16 / 12d);

    public TileCrystalizer(IResourceName name) {
        super(name);
    }

    @Override
    protected boolean[][] makeStructure() {
        return new boolean[][]{
            {true},
            {true}
        };
    }

    @Override
    public int getWidth() {
        return 1;
    }

    @Override
    public int getHeight() {
        return 2;
    }

    @Override
    public int getMainX() {
        return 0;
    }

    @Override
    public int getMainY() {
        return 0;
    }

    @Override
    public boolean isFullTile() {
        return false;
    }

    @Override
    public BoundBox getBoundBox(IWorld world, int x, int y) {
        return box;
    }

    @Override
    public void describeItem(IAssetManager manager, ItemInstance instance, List<String> desc, boolean isAdvanced) {
        super.describeItem(manager, instance, desc, isAdvanced);
        desc.addAll(manager.getFont().splitTextToLength(500,1f,true, manager.localize(LOC)));
    }
}
