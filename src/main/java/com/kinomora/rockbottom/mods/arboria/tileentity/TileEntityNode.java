package com.kinomora.rockbottom.mods.arboria.tileentity;

import de.ellpeck.rockbottom.api.data.set.DataSet;
import de.ellpeck.rockbottom.api.tile.entity.TileEntity;
import de.ellpeck.rockbottom.api.util.Util;
import de.ellpeck.rockbottom.api.world.IWorld;


public class TileEntityNode extends TileEntity {

    private static final float maxSipa = 70;
    private static float currentSipa = 0;

    public TileEntityNode(IWorld world, int x, int y) {
        super(world, x, y);
        currentSipa = Util.RANDOM.nextInt(61) + 10;
    }

    public int getCurrentSipa(){
        return (int)currentSipa;
    }

    public int getMaxSipa(){
        return (int)maxSipa;
    }

    public float getSipaPercentage(){
        return currentSipa/maxSipa;
    }

    public boolean addSipa(int amount){
        if(currentSipa + amount <= maxSipa){
            currentSipa += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean removeSipa(int amount){
        if(currentSipa - amount >= 0){
            currentSipa -= amount;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void save(DataSet set, boolean forSync) {
        super.save(set, forSync);
        set.addInt("currentSipa", getCurrentSipa());
    }

    @Override
    public void load(DataSet set, boolean forSync) {
        super.load(set, forSync);
        this.currentSipa = set.getInt("currentSipa");
    }
}
