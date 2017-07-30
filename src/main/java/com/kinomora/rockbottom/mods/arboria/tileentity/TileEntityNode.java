package com.kinomora.rockbottom.mods.arboria.tileentity;

import de.ellpeck.rockbottom.api.tile.entity.TileEntity;
import de.ellpeck.rockbottom.api.util.Util;
import de.ellpeck.rockbottom.api.world.IWorld;


public class TileEntityNode extends TileEntity {

    public int minSipa = 30;
    public int maxSipa;

    public TileEntityNode(IWorld world, int x, int y) {
        super(world, x, y);
    }

    public int sipaRandomizer() {
        return Util.RANDOM.nextInt(40);
    }




}
