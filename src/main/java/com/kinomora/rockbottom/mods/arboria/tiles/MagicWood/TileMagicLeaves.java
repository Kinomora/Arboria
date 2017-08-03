package com.kinomora.rockbottom.mods.arboria.tiles.MagicWood;

import de.ellpeck.rockbottom.api.tile.TileBasic;
import de.ellpeck.rockbottom.api.tile.state.BoolProp;
import de.ellpeck.rockbottom.api.util.BoundBox;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;
import de.ellpeck.rockbottom.api.world.IWorld;

public class TileMagicLeaves extends TileBasic {

    public static final BoolProp IS_NATURAL = new BoolProp("isNatural", false);

    public TileMagicLeaves(IResourceName name) {
        super(name);
        this.addProps(IS_NATURAL);
    }

    @Override
    public BoundBox getBoundBox(IWorld world, int x, int y) {
        return world.getState(x, y).get(IS_NATURAL) ? null : DEFAULT_BOUNDS;
    }
}
