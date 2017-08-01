package com.kinomora.rockbottom.mods.arboria.tiles;

import com.kinomora.rockbottom.mods.arboria.Arboria;
import com.kinomora.rockbottom.mods.arboria.init.ArboriaTiles;
import com.kinomora.rockbottom.mods.arboria.tileentity.TileEntitySipaTank;
import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.assets.IAssetManager;
import de.ellpeck.rockbottom.api.entity.player.AbstractEntityPlayer;
import de.ellpeck.rockbottom.api.item.ItemInstance;
import de.ellpeck.rockbottom.api.tile.TileBasic;
import de.ellpeck.rockbottom.api.tile.entity.TileEntity;
import de.ellpeck.rockbottom.api.util.BoundBox;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;
import de.ellpeck.rockbottom.api.world.IWorld;
import de.ellpeck.rockbottom.api.world.TileLayer;
import org.newdawn.slick.util.Log;

import java.util.List;

/**
 * Created by Kinomora on 7/31/2017.
 */
public class TileSipaTank extends TileBasic {

    //Variables
    private static final String tileName = "tileSipaTank";
    private static final IResourceName LOC = RockBottomAPI.createRes(Arboria.instance, "details." + tileName);

    public TileSipaTank(IResourceName name) {
        super(name);

    }

    @Override
    public boolean canPlace(IWorld world, int x, int y, TileLayer layer) {
        if (world.getState(x , y + 1).getTile() == ArboriaTiles.tileSipaPump){
            return super.canPlace(world, x, y, layer);
        } else {
            return false;
        }
    }

    @Override
    public boolean onInteractWith(IWorld world, int x, int y, TileLayer layer, double mouseX, double mouseY, AbstractEntityPlayer player) {
        TileEntitySipaTank tank = world.getTileEntity(x,y,TileEntitySipaTank.class);
        Log.debug("Current sipa level: " + tank.currentSipa);
        return true;
    }

    @Override
    public boolean canPlaceInLayer(TileLayer layer) {
        return layer == TileLayer.MAIN;
    }

    @Override
    public boolean isFullTile() {
        return false;
    }

    @Override
    public BoundBox getBoundBox(IWorld world, int x, int y) {
        return null;
    }

    @Override
    public boolean canProvideTileEntity() {
        return true;
    }

    @Override
    public TileEntity provideTileEntity(IWorld world, int x, int y) {
        return new TileEntitySipaTank(world, x, y);
    }

    @Override
    public void describeItem(IAssetManager manager, ItemInstance instance, List<String> desc, boolean isAdvanced) {
        super.describeItem(manager, instance, desc, isAdvanced);
        desc.addAll(manager.getFont().splitTextToLength(500, 1f, true, manager.localize(LOC)));
    }
}