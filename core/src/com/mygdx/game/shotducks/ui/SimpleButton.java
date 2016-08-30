package com.mygdx.game.shotducks.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;


/**
 * Created by Martin on 04/02/2016.
 */
public class SimpleButton {

    private int x, y;
    private int width, height;

    TextureRegion buttonUp;
    TextureRegion buttonDown;

    private Rectangle bounds;

    private boolean isPressed;

    public SimpleButton(int x, int y, int width, int height, TextureRegion buttonUp, TextureRegion buttonDown) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.buttonUp = buttonUp;
        this.buttonDown = buttonDown;
        this.bounds = new Rectangle(x, y, width, height);
    }

    public boolean isClicked(int screenX, int screenY){
        return bounds.contains(screenX, screenY);
    }

    public void draw(SpriteBatch spriteBatch){

        if(isPressed){
            spriteBatch.draw(buttonDown, x, y, width, height);
        }else{
            spriteBatch.draw(buttonUp, x, y, width, height);
        }

    }

    public boolean isTouchedDown(int screenX, int screenY){
        if(bounds.contains(screenX, screenY)){
            isPressed = true;
            Gdx.app.log("Botão", "Clicando no botao de back");
        }
        //isPressed = false;
        return isPressed;
    }

    public boolean isTouchedUp(int screenX, int screenY){
        if(bounds.contains(screenX, screenY)){
            isPressed = false;
            Gdx.app.log("Botão", "Soltou o botão back");

        }
        return isPressed;

    }

}
