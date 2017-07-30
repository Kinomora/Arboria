package com.kinomora.rockbottom.mods.arboria.tiles;

import com.kinomora.rockbottom.mods.arboria.renderer.TileNodeRenderer;
import com.kinomora.rockbottom.mods.arboria.tileentity.TileEntityNode;
import de.ellpeck.rockbottom.api.render.tile.ITileRenderer;
import de.ellpeck.rockbottom.api.tile.TileBasic;
import de.ellpeck.rockbottom.api.tile.entity.TileEntity;
import de.ellpeck.rockbottom.api.util.BoundBox;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;
import de.ellpeck.rockbottom.api.world.IWorld;
import de.ellpeck.rockbottom.api.world.TileLayer;

public class TileNode extends TileBasic {



    public TileNode(IResourceName name) {
        super(name);
    }

    @Override
    public int getLight(IWorld world, int x, int y, TileLayer layer) {
        return 20;
    }

    @Override
    public boolean canPlace(IWorld world, int x, int y, TileLayer layer) {
        return world.getState(x, y).getTile().isAir();
    }

    @Override
    public boolean canPlaceInLayer(TileLayer layer) {
        return layer == TileLayer.MAIN;
    }

    @Override
    public void onAdded(IWorld world, int x, int y, TileLayer layer) {
        super.onAdded(world, x, y, layer);
        world.causeLightUpdate(x, y);
    }

    @Override
    public BoundBox getBoundBox(IWorld world, int x, int y) {
        return null;
    }

    @Override
    public boolean isFullTile() {
        return false;
    }

    @Override
    public boolean canProvideTileEntity() {
        return true;
    }

    @Override
    public TileEntity provideTileEntity(IWorld world, int x, int y) {
        return new TileEntityNode(world, x, y);
    }

    @Override
    protected ITileRenderer createRenderer(IResourceName name) {
        return new TileNodeRenderer(name);
    }
}
