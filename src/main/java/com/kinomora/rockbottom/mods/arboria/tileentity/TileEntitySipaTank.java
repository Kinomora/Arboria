package com.kinomora.rockbottom.mods.arboria.tileentity;

import com.kinomora.rockbottom.mods.arboria.tiles.MagicWood.TileMagicWood;
import de.ellpeck.rockbottom.api.IGameInstance;
import de.ellpeck.rockbottom.api.data.set.DataSet;
import de.ellpeck.rockbottom.api.tile.entity.TileEntity;
import de.ellpeck.rockbottom.api.tile.state.TileState;
import de.ellpeck.rockbottom.api.world.IWorld;
import org.newdawn.slick.util.Log;

public class TileEntitySipaTank extends TileEntity {

    private static final int MAX_SIPA_RATE_PER_SECOND = 1;
    private static final float MAX_SIPA = 8000;
    public float currentSipa = 0;

    public TileEntitySipaTank(IWorld world, int x, int y) {
        super(world, x, y);
    }

    //This runs every tick and checks to see if sipa can be drawn from the node
    @Override
    public void update(IGameInstance game) {
        super.update(game);
        if (world.getWorldInfo().currentWorldTime % 400 == 0) {
            doSipaCheck();
        }
    }

    private void doSipaCheck() {
        TileState upLeft = world.getState(x - 1, y + 1);
        TileState upRight = world.getState(x + 1, y + 1);
        TileEntityNode nodeUpLeft = world.getTileEntity(x - 1, y + 1, TileEntityNode.class);
        TileEntityNode nodeUpRight = world.getTileEntity(x + 1, y + 1, TileEntityNode.class);
        if (checkDiagonalNode(upLeft, upRight, nodeUpLeft, nodeUpRight) == 1) {
            nodeUpLeft.removeSipa(MAX_SIPA_RATE_PER_SECOND);
            this.addSipa(MAX_SIPA_RATE_PER_SECOND);
        } else if (checkDiagonalNode(upLeft, upRight, nodeUpLeft, nodeUpRight) == 2) {
            nodeUpRight.removeSipa(MAX_SIPA_RATE_PER_SECOND);
            this.addSipa(MAX_SIPA_RATE_PER_SECOND);
        } else {

        }
    }

    private int checkDiagonalNode(TileState upLeft, TileState upRight, TileEntityNode nodeUpLeft, TileEntityNode nodeUpRight) {
        //UP RIGHT
        if (upLeft.getTile() instanceof TileMagicWood && upLeft.get(TileMagicWood.HAS_NODE)) {
            Log.info("Tile at " + (x - 1) + ", " + (y + 1) + " has a node with " + nodeUpLeft.getCurrentSipa() + " sipa.");
            return 1;
        }
        //UP LEFT
        else if (upRight.getTile() instanceof TileMagicWood && upRight.get(TileMagicWood.HAS_NODE)) {
            Log.info("Tile at " + (x + 1) + ", " + (y + 1) + " has a node with " + nodeUpRight.getCurrentSipa() + " sipa.");
            return 2;
        } else {
            return 0;
        }
    }

    public int getCurrentSipa() {
        return (int) currentSipa;
    }

    public int getMaxSipa() {
        return (int) MAX_SIPA;
    }

    public float getSipaPercentage() {
        return currentSipa / MAX_SIPA;
    }

    public boolean addSipa(int amount) {
        if (currentSipa + amount <= MAX_SIPA) {
            currentSipa += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean removeSipa(int amount) {
        if (currentSipa - amount >= 0) {
            currentSipa -= amount;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void save(DataSet set, boolean forSync) {
        super.save(set, forSync);
        set.addInt("currentSipa", this.getCurrentSipa());
    }

    @Override
    public void load(DataSet set, boolean forSync) {
        super.load(set, forSync);
        this.currentSipa = set.getInt("currentSipa");
    }
}
