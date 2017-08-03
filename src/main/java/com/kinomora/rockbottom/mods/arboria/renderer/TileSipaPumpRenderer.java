package com.kinomora.rockbottom.mods.arboria.renderer;

import com.kinomora.rockbottom.mods.arboria.tiles.TileSipaPump;
import de.ellpeck.rockbottom.api.IGameInstance;
import de.ellpeck.rockbottom.api.assets.IAssetManager;
import de.ellpeck.rockbottom.api.item.ItemInstance;
import de.ellpeck.rockbottom.api.render.tile.DefaultTileRenderer;
import de.ellpeck.rockbottom.api.tile.Tile;
import de.ellpeck.rockbottom.api.tile.state.TileState;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;
import de.ellpeck.rockbottom.api.world.IWorld;
import de.ellpeck.rockbottom.api.world.TileLayer;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class TileSipaPumpRenderer extends DefaultTileRenderer {
    public TileSipaPumpRenderer(IResourceName texture) {
        super(texture);
    }

    @Override
    public void render(IGameInstance game, IAssetManager manager, Graphics g, IWorld world, Tile tile, TileState state, int x, int y, TileLayer layer, float renderX, float renderY, float scale, Color[] light) {
        int row;
        if (world.getState(x, y).get(TileSipaPump.IS_RIGHT)) {
            row = 0;
        } else row = 1;

        if (world.getState(x, y).get(TileSipaPump.IS_ON)) {
            manager.getAnimation(this.texture).drawRow(row, renderX, renderY, scale, light, Color.white);
        } else manager.getAnimation(this.texture).drawFrame(row, 0, renderX, renderY, scale, light, Color.white);
    }

    @Override
    public void renderItem(IGameInstance game, IAssetManager manager, Graphics g, Tile tile, ItemInstance instance, float x, float y, float scale, Color filter) {
        manager.getAnimation(this.texture).drawFrame(0, 0, x, y, scale, Color.white);
    }
}
