package com.kinomora.rockbottom.mods.arboria.tiles;

import com.kinomora.rockbottom.mods.arboria.init.ArboriaTiles;
import com.kinomora.rockbottom.mods.arboria.renderer.TileSipaPumpRenderer;
import de.ellpeck.rockbottom.api.render.tile.ITileRenderer;
import de.ellpeck.rockbottom.api.tile.TileBasic;
import de.ellpeck.rockbottom.api.util.BoundBox;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;
import de.ellpeck.rockbottom.api.world.IWorld;
import de.ellpeck.rockbottom.api.world.TileLayer;

/**
 * Created by Kinomora on 7/31/2017.
 */
public class TileSipaPump extends TileBasic {

    public TileSipaPump(IResourceName name) {
        super(name);
    }

    @Override
    public boolean canPlace(IWorld world, int x, int y, TileLayer layer) {
        if (world.getState(x - 1, y).getTile() == ArboriaTiles.tileDuskWood || world.getState(x - 1, y).getTile() == ArboriaTiles.tileMorningWood || world.getState(x - 1, y).getTile() == ArboriaTiles.tileSunnyWood || world.getState(x - 1, y).getTile() == ArboriaTiles.tileMoonlitWood) {
            return super.canPlace(world, x, y, layer);
        //} else if (world.getState(x + 1, y).getTile() == ArboriaTiles.tileDuskWood || world.getState(x + 1, y).getTile() == ArboriaTiles.tileMorningWood || world.getState(x + 1, y).getTile() == ArboriaTiles.tileSunnyWood || world.getState(x + 1, y).getTile() == ArboriaTiles.tileMoonlitWood) {
        //    return super.canPlace(world, x, y, layer);
        } else {
            return false;
        }
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
    public boolean canPlaceInLayer(TileLayer layer) {
        return layer == TileLayer.MAIN;
    }

    @Override
    protected ITileRenderer createRenderer(IResourceName name) {
        return new TileSipaPumpRenderer(name);
    }
}
