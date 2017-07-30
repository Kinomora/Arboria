package com.kinomora.rockbottom.mods.arboria.tiles;

import com.kinomora.rockbottom.mods.arboria.Arboria;
import de.ellpeck.rockbottom.api.GameContent;
import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.assets.IAssetManager;
import de.ellpeck.rockbottom.api.entity.Entity;
import de.ellpeck.rockbottom.api.item.ItemInstance;
import de.ellpeck.rockbottom.api.render.tile.ITileRenderer;
import de.ellpeck.rockbottom.api.tile.Tile;
import de.ellpeck.rockbottom.api.tile.TileBasic;
import de.ellpeck.rockbottom.api.tile.state.TileState;
import de.ellpeck.rockbottom.api.util.BoundBox;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;
import de.ellpeck.rockbottom.api.world.IWorld;
import de.ellpeck.rockbottom.api.world.TileLayer;

import java.util.List;

public class TileBewitchedSapling extends TileBasic {
    //Variables
    private static final String tileName = "tileBewitchedSapling";
    private static final IResourceName LOC = RockBottomAPI.createRes(Arboria.instance, "details." + tileName);

    //Constructor
    public TileBewitchedSapling(IResourceName name) {
        super(name);
    }

    @Override
    public void describeItem(IAssetManager manager, ItemInstance instance, List<String> desc, boolean isAdvanced) {
        super.describeItem(manager, instance, desc, isAdvanced);
        desc.addAll(manager.getFont().splitTextToLength(500, 1f, true, manager.localize(LOC)));
    }

    @Override
    public void onAdded(IWorld world, int x, int y, TileLayer layer) {
        super.onAdded(world, x, y, layer);
        world.causeLightUpdate(x, y);
    }

    @Override
    public boolean canPlace(IWorld world, int x, int y, TileLayer layer) {
        Tile getLowerTile = world.getState(x, y-1).getTile();
        return (getLowerTile == GameContent.TILE_DIRT || getLowerTile == GameContent.TILE_GRASS) && super.canPlace(world, x, y, layer);
    }

    @Override
    public boolean canStay(IWorld world, int x, int y, TileLayer layer, int changedX, int changedY, TileLayer changedLayer) {
        Tile getLowerTile = world.getState(x, y-1).getTile();
        return (getLowerTile == GameContent.TILE_DIRT || getLowerTile == GameContent.TILE_GRASS) && super.canStay(world, x, y, layer, changedX, changedY, changedLayer);
    }

    @Override
    public int getLight(IWorld world, int x, int y, TileLayer layer) {

        return 3;
    }

    @Override
    public boolean canPlaceInLayer(TileLayer layer) {
        return layer == TileLayer.MAIN;
    }

    @Override
    public BoundBox getBoundBox(IWorld world, int x, int y) {
        return null;
    }

    @Override
    public boolean isFullTile() {
        return false;
    }
}
