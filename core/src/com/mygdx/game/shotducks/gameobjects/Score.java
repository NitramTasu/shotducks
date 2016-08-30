package com.mygdx.game.shotducks.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Martin on 04/02/2016.
 */
public class Score extends BitmapFont{

    private int score;
    private String scoreName;


    public Score(){
        score = 0;
        scoreName = "Pontos: ";
        this.setColor(Color.BLACK);
        this.getData().setScale(3);

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void hitPoit(int point){
        this.score += point;
    }

    public void drawScore(SpriteBatch spriteBatch) {
        this.draw(spriteBatch, scoreName + score, 25, Gdx.app.getGraphics().getHeight()-100);
    }
}
