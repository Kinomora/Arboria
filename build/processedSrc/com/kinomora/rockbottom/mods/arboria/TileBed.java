package com.kinomora.rockbottom.mods.arboria;

import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.assets.font.FormattingCode;
import de.ellpeck.rockbottom.api.entity.Entity;
import de.ellpeck.rockbottom.api.entity.player.AbstractEntityPlayer;
import de.ellpeck.rockbottom.api.item.ToolType;
import de.ellpeck.rockbottom.api.tile.Tile;
import de.ellpeck.rockbottom.api.tile.TileBasic;
import de.ellpeck.rockbottom.api.util.BoundBox;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;
import de.ellpeck.rockbottom.api.world.IWorld;
import de.ellpeck.rockbottom.api.world.TileLayer;

/**
 * Created by Kinomora on 7/14/2017.
 */
public class TileBed extends TileBasic {

    private final BoundBox box = new BoundBox(0, 0, 1, 0.5);

    public TileBed(IResourceName name) {
        super(name);
    }

    @Override
    public void onDestroyed(IWorld world, int x, int y, Entity destroyer, TileLayer layer, boolean shouldDrop) {
        if(this.isToolEffective(world, x,y, layer, ToolType.PICKAXE, 1 )){

        }
    }


    @Override
    public boolean onInteractWith(IWorld world, int x, int y, TileLayer layer, double mouseX, double mouseY, AbstractEntityPlayer player) {
        if (world.getWorldInfo().currentWorldTime < 3000 || world.getWorldInfo().currentWorldTime > 9000) {
            world.getWorldInfo().currentWorldTime = 3000;
        } else {
            if (!RockBottomAPI.getNet().isServer())
                RockBottomAPI.getGame().getChatLog().displayMessage(FormattingCode.RED + "You can only sleep at night!");
        }
        return true;
    }

    @Override
    public BoundBox getBoundBox(IWorld world, int x, int y) {
        return box;
    }

    @Override
    public Tile setHardness(float hardness) {
        return this.setHardness(10f);
    }
}
