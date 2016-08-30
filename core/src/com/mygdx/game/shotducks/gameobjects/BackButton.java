package com.mygdx.game.shotducks.gameobjects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.shotducks.ui.SimpleButton;

/**
 * Created by Martin on 04/02/2016.
 */
public class BackButton extends SimpleButton {
    private TextureRegion states[];


    public BackButton(int x, int y, int width, int height, TextureRegion buttonUp, TextureRegion buttonDown) {
        super(x, y, width, height, buttonUp, buttonDown);
    }
}
