package com.kinomora.rockbottom.mods.arboria.renderer;

import de.ellpeck.rockbottom.api.IGameInstance;
import de.ellpeck.rockbottom.api.assets.IAssetManager;
import de.ellpeck.rockbottom.api.render.tile.DefaultTileRenderer;
import de.ellpeck.rockbottom.api.tile.Tile;
import de.ellpeck.rockbottom.api.tile.state.TileState;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;
import de.ellpeck.rockbottom.api.world.IWorld;
import de.ellpeck.rockbottom.api.world.TileLayer;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class TileNodeRenderer extends DefaultTileRenderer {
    public TileNodeRenderer(IResourceName texture) {
        super(texture);
    }

    @Override
    public void render(IGameInstance game, IAssetManager manager, Graphics g, IWorld world, Tile tile, TileState state, int x, int y, TileLayer layer, float renderX, float renderY, float scale, Color[] light) {
        manager.getAnimation(this.texture).drawRow(0, renderX, renderY, scale, light, Color.yellow);
    }

    @Override
    public void renderItem(IGameInstance game, IAssetManager manager, Graphics g, Tile tile, int meta, float x, float y, float scale, Color filter) {
        manager.getAnimation(this.texture).drawRow(0, x, y, scale, filter);
    }
}
