package com.kinomora.rockbottom.mods.arboria.renderer;

import com.kinomora.rockbottom.mods.arboria.tileentity.TileEntitySipaTank;
import de.ellpeck.rockbottom.api.IGameInstance;
import de.ellpeck.rockbottom.api.assets.IAssetManager;
import de.ellpeck.rockbottom.api.assets.tex.Texture;
import de.ellpeck.rockbottom.api.data.set.DataSet;
import de.ellpeck.rockbottom.api.item.ItemInstance;
import de.ellpeck.rockbottom.api.render.tile.DefaultTileRenderer;
import de.ellpeck.rockbottom.api.tile.Tile;
import de.ellpeck.rockbottom.api.tile.state.TileState;
import de.ellpeck.rockbottom.api.util.Util;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;
import de.ellpeck.rockbottom.api.world.IWorld;
import de.ellpeck.rockbottom.api.world.TileLayer;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.util.Log;

public class TileSipaTankRenderer extends DefaultTileRenderer {


    public TileSipaTankRenderer(IResourceName texture) {
        super(texture);
    }


    @Override
    public void render(IGameInstance game, IAssetManager manager, Graphics g, IWorld world, Tile tile, TileState state, int x, int y, TileLayer layer, float renderX, float renderY, float scale, Color[] light) {
        //Render Tank
        manager.getTexture(this.texture).drawWithLight(renderX, renderY, scale, scale, light);

        //Render Sipa in Tank
        IResourceName sipa = this.texture.addSuffix(".sipa");
        Texture tex = manager.getTexture(sipa);

        float sipaPerc = world.getTileEntity(x, y, TileEntitySipaTank.class).getSipaPercentage();

        float p = 1 / 12f;
        int pixelRender = Util.ceil(sipaPerc * 10);

        float startRenderX = renderX + scale * 2 * p;
        float endRenderX = renderX + scale * 10 * p;

        float endRenderY = renderY + scale * 11 * p;
        float startRenderY = renderY + scale * (11 - pixelRender) * p;

        manager.getTexture(sipa).drawWithLight(startRenderX, startRenderY, endRenderX, endRenderY, 0, 10 - pixelRender, tex.getWidth(), tex.getHeight(), light, Color.white);
    }

    @Override
    public void renderItem(IGameInstance game, IAssetManager manager, Graphics g, Tile tile, ItemInstance instance, float x, float y, float scale, Color filter) {
        manager.getTexture(this.texture).draw(x, y, scale, scale, filter);
        IResourceName sipa = this.texture.addSuffix(".sipa");
        Texture tex = manager.getTexture(sipa);

        float sipaPerc = 0;
        int sipaAmount;
        DataSet data = instance.getAdditionalData();
        if (data != null) {
            sipaAmount = data.getInt("sipa");
            sipaPerc = sipaAmount / 8000f;
            Log.debug("Sipa is: " + sipaAmount + "..." + sipaPerc);
        }

        float p = 1 / 12f;
        int pixelRender = (int) (sipaPerc * 10);

        float startRenderX = x + scale * 2 * p;
        float endRenderX = x + scale * 10 * p;

        float endRenderY = y + scale * 11 * p;
        float startRenderY = y + scale * (11 - pixelRender) * p;

        manager.getTexture(sipa).draw(startRenderX, startRenderY, endRenderX, endRenderY, 0, 10 - pixelRender, tex.getWidth(), tex.getHeight(), filter);
    }
}
