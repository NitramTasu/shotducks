package com.mygdx.game.shotducks;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Martin on 11/11/2015.
 */
public class Drop extends Game {

    public SpriteBatch spriteBatch;
    public BitmapFont font;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
        font = new BitmapFont();
        font.getData().setScale(3);

        Assets.load();

        //this.setScreen(new com.mygdx.game.shotducks.screens.MenuMainScreen(this));
        this.setScreen(new com.mygdx.game.shotducks.screens.TargetGame(this));
    }

    public void render() {
        super.render(); //important!
    }

    public void dispose() {
        spriteBatch.dispose();
        font.dispose();
    }
}
