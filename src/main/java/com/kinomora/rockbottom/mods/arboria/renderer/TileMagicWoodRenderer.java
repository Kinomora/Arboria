package com.kinomora.rockbottom.mods.arboria.renderer;

import com.kinomora.rockbottom.mods.arboria.init.ArboriaTiles;
import com.kinomora.rockbottom.mods.arboria.tiles.MagicWood.TileMagicWood;
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

public class TileMagicWoodRenderer extends DefaultTileRenderer {
    public TileMagicWoodRenderer(IResourceName texture) {
        super(texture);
    }

    @Override
    public void render(IGameInstance game, IAssetManager manager, Graphics g, IWorld world, Tile tile, TileState state, int x, int y, TileLayer layer, float renderX, float renderY, float scale, Color[] light) {
        IResourceName tileNode = ArboriaTiles.tileNode.getName().addPrefix("tiles.");

        super.render(game, manager, g, world, tile, state, x, y, layer, renderX, renderY, scale, light);

        if (world.getState(layer, x, y).get(TileMagicWood.HAS_NODE)) {
            manager.getAnimation(tileNode).drawRow(0, renderX, renderY, scale, light, TileNodeRenderer.NODE);
        }
    }
}
