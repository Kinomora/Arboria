package com.kinomora.rockbottom.mods.arboria.tiles;

import com.kinomora.rockbottom.mods.arboria.renderer.TileMagicWoodRenderer;
import de.ellpeck.rockbottom.api.render.tile.ITileRenderer;
import de.ellpeck.rockbottom.api.tile.TileBasic;
import de.ellpeck.rockbottom.api.tile.state.BoolProp;
import de.ellpeck.rockbottom.api.util.BoundBox;
import de.ellpeck.rockbottom.api.util.Util;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;
import de.ellpeck.rockbottom.api.world.IWorld;
import de.ellpeck.rockbottom.api.world.TileLayer;

public class TileMagicWood extends TileBasic {

    public static final BoolProp IS_NATURAL = new BoolProp("isNarutal", false);
    public static final BoolProp HAS_NODE = new BoolProp("hasNode", false);

    public TileMagicWood(IResourceName name) {
        super(name);
        this.addProps(IS_NATURAL, HAS_NODE);
    }

    @Override
    public void onAdded(IWorld world, int x, int y, TileLayer layer) {
        if (Util.RANDOM.nextInt(3) == 1) {
            world.setState(layer, x, y, this.getDefState().prop(HAS_NODE, true));
        }
        super.onAdded(world, x, y, layer);
    }

    @Override
    public BoundBox getBoundBox(IWorld world, int x, int y) {
        return world.getState(x, y).get(IS_NATURAL) ? null : DEFAULT_BOUNDS;
    }

    @Override
    protected ITileRenderer createRenderer(IResourceName name) {
        return new TileMagicWoodRenderer(name);
    }
}
