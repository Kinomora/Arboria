package com.kinomora.rockbottom.mods.arboria.tileentity;

import de.ellpeck.rockbottom.api.data.set.DataSet;
import de.ellpeck.rockbottom.api.tile.entity.TileEntity;
import de.ellpeck.rockbottom.api.util.Util;
import de.ellpeck.rockbottom.api.world.IWorld;


public class TileEntityNode extends TileEntity {

    public int currentSipa = 0;

    public TileEntityNode(IWorld world, int x, int y) {
        super(world, x, y);
        currentSipa = Util.RANDOM.nextInt(31) + 40;
    }

    @Override
    public void save(DataSet set, boolean forSync) {
        super.save(set, forSync);
        set.addInt("currentSipa", this.currentSipa);
    }

    @Override
    public void load(DataSet set, boolean forSync) {
        super.load(set, forSync);
        this.currentSipa = set.getInt("currentSipa");
    }
}
