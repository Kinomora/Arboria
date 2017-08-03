package com.kinomora.rockbottom.mods.arboria.renderer;

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

public class TileNodeRenderer extends DefaultTileRenderer {

    public static final Color NODE = new Color(1.0f, 1.0f, 1.0f, 0.75f);
    public static final Color DULL = Color.transparent;

    public TileNodeRenderer(IResourceName texture) {
        super(texture);
    }

    public static boolean isNearby(IGameInstance game, int nodeX, int nodeY) {
        if (Math.abs(game.getInteractionManager().getMousedTileX()) - Math.abs(nodeX) < 3 && Math.abs(game.getInteractionManager().getMousedTileY()) - Math.abs(nodeY) < 3) {
            if(Math.abs(game.getInteractionManager().getMousedTileX()) - Math.abs(nodeX) > 3 && Math.abs(game.getInteractionManager().getMousedTileY()) - Math.abs(nodeY) > 3){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public void render(IGameInstance game, IAssetManager manager, Graphics g, IWorld world, Tile tile, TileState state, int x, int y, TileLayer layer, float renderX, float renderY, float scale, Color[] light) {
        if (isNearby(game, x, y)) {
            manager.getAnimation(this.texture).drawRow(0, renderX, renderY, scale, light, NODE);
        } else {
            manager.getAnimation(this.texture).drawRow(0, renderX, renderY, scale, light, DULL);
        }
    }

    @Override
    public void renderItem(IGameInstance game, IAssetManager manager, Graphics g, Tile tile, ItemInstance instance, float x, float y, float scale, Color filter) {
        manager.getAnimation(this.texture).drawRow(0, x, y, scale, filter);
    }
}
