package com.kinomora.rockbottom.mods.arboria.tiles;

import com.kinomora.rockbottom.mods.arboria.renderer.TileSipaPumpRenderer;
import com.kinomora.rockbottom.mods.arboria.tileentity.TileEntitySipaTank;
import com.kinomora.rockbottom.mods.arboria.tiles.MagicWood.TileMagicWood;
import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.entity.player.AbstractEntityPlayer;
import de.ellpeck.rockbottom.api.item.ItemInstance;
import de.ellpeck.rockbottom.api.render.tile.ITileRenderer;
import de.ellpeck.rockbottom.api.tile.TileBasic;
import de.ellpeck.rockbottom.api.tile.state.BoolProp;
import de.ellpeck.rockbottom.api.tile.state.TileState;
import de.ellpeck.rockbottom.api.util.BoundBox;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;
import de.ellpeck.rockbottom.api.world.IWorld;
import de.ellpeck.rockbottom.api.world.TileLayer;
import org.newdawn.slick.Input;
import org.newdawn.slick.util.Log;

public class TileSipaPump extends TileBasic {

    public static final BoolProp IS_RIGHT = new BoolProp("isRight", true);

    public TileSipaPump(IResourceName name) {
        super(name);
        this.addProps(IS_RIGHT);
    }

    @Override
    public TileState getPlacementState(IWorld world, int x, int y, TileLayer layer, ItemInstance instance, AbstractEntityPlayer placer) {
        return this.getDefState().prop(IS_RIGHT, world.getState(x-1, y).getTile() instanceof TileMagicWood);
    }
    @Override
    public boolean canPlace(IWorld world, int x, int y, TileLayer layer) {
        TileState getLeft = world.getState(x-1, y);
        TileState getRight = world.getState(x+1, y);
        return (getLeft.getTile() instanceof TileMagicWood && getLeft.get(TileMagicWood.HAS_NODE)) || (getRight.getTile() instanceof TileMagicWood && getRight.get(TileMagicWood.HAS_NODE)) && super.canPlace(world, x, y, layer);
    }

    @Override
    public boolean onInteractWith(IWorld world, int x, int y, TileLayer layer, double mouseX, double mouseY, AbstractEntityPlayer player) {
        if(RockBottomAPI.getGame().getInput().isKeyDown(Input.KEY_LCONTROL)){
            world.getTileEntity(x,y, TileEntitySipaTank.class).removeSipa(100);
        } else {
            world.getTileEntity(x,y, TileEntitySipaTank.class).addSipa(100);
        }
        Log.debug("Current sipa in tank is: " + world.getTileEntity(x,y, TileEntitySipaTank.class).getCurrentSipa());
        return super.onInteractWith(world, x, y, layer, mouseX, mouseY, player);
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
    protected ITileRenderer createRenderer(IResourceName name) {
        return new TileSipaPumpRenderer(name);
    }
}
