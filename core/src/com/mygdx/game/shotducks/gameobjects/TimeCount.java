package com.mygdx.game.shotducks.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Martin on 04/02/2016.
 */
public class TimeCount extends BitmapFont {

    private int time = 3;
    int count = 0;

    public TimeCount(){

        this.getData().setScale(5);
        this.setColor(Color.BLUE);
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void draw(SpriteBatch spriteBatch){

        if(count >= 60 && time > 0){
            count = 0;
            time -= 1;
        }

        count++;

        this.draw(spriteBatch, formatTime(), 25, Gdx.app.getGraphics().getHeight() - 200);
    }

    public String formatTime(){
        int h = time/60;
        int m = time%60;

        String formatedTime = String.format("%02d:%02d", h, m);

        return formatedTime;
    }
}
