package com.kinomora.rockbottom.mods.arboria.tileentity;

import de.ellpeck.rockbottom.api.data.set.DataSet;
import de.ellpeck.rockbottom.api.tile.entity.TileEntity;
import de.ellpeck.rockbottom.api.world.IWorld;

/**
 * Created by Kinomora on 7/31/2017.
 */
public class TileEntitySipaTank extends TileEntity {

    public static int currentSipa = 0;

    public TileEntitySipaTank(IWorld world, int x, int y) {
        super(world, x, y);
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
