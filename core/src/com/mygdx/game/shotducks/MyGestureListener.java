package com.mygdx.game.shotducks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Martin on 20/09/2015.
 */
public class MyGestureListener implements GestureDetector.GestureListener {
    SpriteBatch teste;
    TextureRegion text;
    float xPos =50;
    public MyGestureListener(SpriteBatch teste, TextureRegion text){
        this.teste = teste;
        this.text = text;
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        teste.begin();
        xPos += Gdx.graphics.getDeltaTime() * 10;
        teste.draw(text,xPos,y);
        teste.end();
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {

        return false;
    }

    @Override
    public boolean longPress(float x, float y) {

        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {

        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {

        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {

        return false;
    }

    @Override
    public boolean zoom (float originalDistance, float currentDistance){

        return false;
    }

    @Override
    public boolean pinch (Vector2 initialFirstPointer, Vector2 initialSecondPointer, Vector2 firstPointer, Vector2 secondPointer){

        return false;
    }
}
