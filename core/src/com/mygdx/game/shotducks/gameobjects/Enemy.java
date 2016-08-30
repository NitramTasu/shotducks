package com.mygdx.game.shotducks.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Martin on 09/11/2015.
 */
public class Enemy extends Actor {

    protected int speed;
    protected int sizeX;
    protected int sizeY;
    protected Sprite sprite;
    protected Texture img;
    protected int direction;
    private boolean hide;
    private float time;
    private boolean isDead;

    public Enemy(int x, int y, int speed, int sizeX, int sizeY,Texture img) {
        sprite = new Sprite(img);
        sprite.setPosition(getX(), getY());

        this.setX(x);
        this.setY(y);
        this.setSpeed(speed);
        this.setSizeX(sizeX);
        this.setSizeY(sizeY);
        this.img = img;
        this.setHide(false);
        this.setIsDead(false);

    }

    public Enemy(){
    }

    public void turnLeft() {
        this.sprite.setRotation(0.0f);
        this.sprite.setRotation(this.sprite.getRotation() + 90);
    }

    public void turnRight() {
        this.sprite.setRotation(0.0f);
        this.sprite.setRotation(this.sprite.getRotation()-90);
    }

    public float getX() {
        return this.sprite.getX();
    }

    public void setX(float x) {
        this.sprite.setX(x);
    }

    public float getY() {
        return this.sprite.getY();
    }

    public void setY(float y) {
        this.sprite.setY(y);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setPosition(float x, float y){
        this.sprite.setPosition(x, y);
    }

    public boolean isHide() {
        return hide;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }



    public boolean isTouched(float x, float y){

        if(this.getSprite().getBoundingRectangle().contains(x, y)){
            return true;
        }
        return false;
    }

    public boolean hit(float x, float y){
        if(isTouched(x, y)) {
            Gdx.app.log("Barata","Tocou!!! "+x+":"+y);

            speed = 0;

            return true;
        }

        return false;
    }

    public void update(Batch batch){

        sprite.draw(batch);
        //this.sprite.setPosition(this.sprite.getX() + direction * speed, this.sprite.getY());
    }


    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setIsDead(boolean isDead) {
        this.isDead = isDead;
    }
}
