package com.kinomora.rockbottom.mods.arboria.tiles.magicwood;

import com.kinomora.rockbottom.mods.arboria.renderer.TileMagicWoodRenderer;
import com.kinomora.rockbottom.mods.arboria.tileentity.TileEntityNode;
import de.ellpeck.rockbottom.api.entity.player.AbstractEntityPlayer;
import de.ellpeck.rockbottom.api.render.tile.ITileRenderer;
import de.ellpeck.rockbottom.api.tile.TileBasic;
import de.ellpeck.rockbottom.api.tile.entity.TileEntity;
import de.ellpeck.rockbottom.api.tile.state.BoolProp;
import de.ellpeck.rockbottom.api.util.BoundBox;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;
import de.ellpeck.rockbottom.api.world.IWorld;
import de.ellpeck.rockbottom.api.world.TileLayer;
import org.newdawn.slick.util.Log;

public class TileMagicWood extends TileBasic {

    public static final BoolProp IS_NATURAL = new BoolProp("isNatural", false);
    public static final BoolProp HAS_NODE = new BoolProp("hasNode", false);

    public TileMagicWood(IResourceName name) {
        super(name);
        this.addProps(IS_NATURAL, HAS_NODE);
    }

    @Override
    public BoundBox getBoundBox(IWorld world, int x, int y) {
        return world.getState(x, y).get(IS_NATURAL) ? null : DEFAULT_BOUNDS;
    }

    @Override
    public boolean canProvideTileEntity() {
        return true;
    }

    @Override
    public TileEntity provideTileEntity(IWorld world, int x, int y) {
        return world.getState(x,y).get(HAS_NODE) ? new TileEntityNode(world,x,y) : null;
    }

    @Override
    public boolean onInteractWith(IWorld world, int x, int y, TileLayer layer, double mouseX, double mouseY, AbstractEntityPlayer player) {
        TileEntityNode node = world.getTileEntity(x,y,TileEntityNode.class);
        if(node != null)
            Log.info("Current sipa level: " + node.getCurrentSipa());
        return true;
    }

    @Override
    protected ITileRenderer createRenderer(IResourceName name) {
        return new TileMagicWoodRenderer(name);
    }
}
