package com.kinomora.rockbottom.mods.arboria.tiles;

import com.kinomora.rockbottom.mods.arboria.Arboria;
import com.kinomora.rockbottom.mods.arboria.renderer.TileSipaTankRenderer;
import com.kinomora.rockbottom.mods.arboria.tileentity.TileEntitySipaTank;
import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.assets.IAssetManager;
import de.ellpeck.rockbottom.api.data.set.DataSet;
import de.ellpeck.rockbottom.api.entity.Entity;
import de.ellpeck.rockbottom.api.entity.player.AbstractEntityPlayer;
import de.ellpeck.rockbottom.api.item.ItemInstance;
import de.ellpeck.rockbottom.api.item.ItemTile;
import de.ellpeck.rockbottom.api.render.tile.ITileRenderer;
import de.ellpeck.rockbottom.api.tile.TileBasic;
import de.ellpeck.rockbottom.api.tile.entity.TileEntity;
import de.ellpeck.rockbottom.api.util.BoundBox;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;
import de.ellpeck.rockbottom.api.world.IWorld;
import de.ellpeck.rockbottom.api.world.TileLayer;
import org.newdawn.slick.Input;
import org.newdawn.slick.util.Log;

import java.util.Collections;
import java.util.List;

public class TileSipaTank extends TileBasic {

    //Variables
    private static final String tileName = "tileSipaTank";
    private static final IResourceName LOC = RockBottomAPI.createRes(Arboria.instance, "details." + tileName);

    public TileSipaTank(IResourceName name) {
        super(name);
    }

    @Override
    public boolean onInteractWith(IWorld world, int x, int y, TileLayer layer, double mouseX, double mouseY, AbstractEntityPlayer player) {
        if (RockBottomAPI.getGame().getInput().isKeyDown(Input.KEY_LCONTROL)) {
            world.getTileEntity(x, y, TileEntitySipaTank.class).removeSipa(1000);
        } else if (RockBottomAPI.getGame().getInput().isKeyDown(Input.KEY_RCONTROL)) {
            world.getTileEntity(x, y, TileEntitySipaTank.class).addSipa(1000);
        }
        Log.debug("Current sipa in tank is: " + world.getTileEntity(x, y, TileEntitySipaTank.class).getCurrentSipa());
        return true;
    }

    @Override
    protected ItemTile createItemTile() {
        return new ItemTile(this.name) {
            @Override
            public boolean isDataSensitive(ItemInstance instance) {
                return true;
            }
        };
    }

    @Override
    public boolean canPlace(IWorld world, int x, int y, TileLayer layer) {
        return world.getState(x, y - 1).getTile().isFullTile() && super.canPlace(world, x, y, layer);
    }

    @Override
    public boolean canStay(IWorld world, int x, int y, TileLayer layer, int changedX, int changedY, TileLayer changedLayer) {
        return world.getState(x, y - 1).getTile().isFullTile() && super.canStay(world, x, y, layer, changedX, changedY, changedLayer);
    }

    @Override
    public List<ItemInstance> getDrops(IWorld world, int x, int y, TileLayer layer, Entity destroyer) {
        ItemInstance instance = new ItemInstance(this);
        DataSet data = new DataSet();
        TileEntitySipaTank tile = world.getTileEntity(x, y, TileEntitySipaTank.class);
        if (tile != null) {
            data.addInt("sipa", tile.getCurrentSipa());
            data.addInt("maxSipa", tile.getMaxSipa());
        }
        instance.setAdditionalData(data);
        return Collections.singletonList(instance);
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
    public boolean canProvideTileEntity() {
        return true;
    }

    @Override
    protected ITileRenderer createRenderer(IResourceName name) {
        return new TileSipaTankRenderer(name);
    }

    @Override
    public void doPlace(IWorld world, int x, int y, TileLayer layer, ItemInstance instance, AbstractEntityPlayer placer) {
        super.doPlace(world, x, y, layer, instance, placer);
        DataSet data = instance.getAdditionalData();
        if (data != null) {
            TileEntitySipaTank tile = world.getTileEntity(x, y, TileEntitySipaTank.class);
            if (tile != null) {
                tile.addSipa(data.getInt("sipa"));
            }
        }
    }

    @Override
    public TileEntity provideTileEntity(IWorld world, int x, int y) {
        return new TileEntitySipaTank(world, x, y);
    }

    @Override
    public void describeItem(IAssetManager manager, ItemInstance instance, List<String> desc, boolean isAdvanced) {
        super.describeItem(manager, instance, desc, isAdvanced);
        desc.addAll(manager.getFont().splitTextToLength(500, 1f, true, manager.localize(LOC)));
    }
}