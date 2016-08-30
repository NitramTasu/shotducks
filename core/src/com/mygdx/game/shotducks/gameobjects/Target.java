package com.mygdx.game.shotducks.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Logger;

import java.util.Random;

import sun.rmi.runtime.Log;
import sun.security.util.Debug;

/**
 * Created by Martin on 10/11/2015.
 */
public class Target extends Enemy {
    private float position;
    private TextureRegion states[] = new TextureRegion[2];

    float minX = 3.0f;
    float maxX = 1000.0f;

    int maxSpeed = 500;
    int minSpeed = 250;
    private int maxY = 3000;
    private int minY = 100;

    private int[] wayPosition;

    public Target(Texture img){
        super();

        Random r = new Random();
        states[0] = new TextureRegion(img,0, 0 ,192, 192);
        states[1] = new TextureRegion(img,0.5f, 0 ,1 , 1);
        this.sprite = new Sprite(img);
        setNewXposition(r);

        defineMovement();
    }

    private void setNewXposition(Random r) {
        position = r.nextFloat()*(maxX-minX)+minX;
    }
    private void setNewYposition(Random r) {
        position = r.nextFloat()*(maxY-minY)+minY;

    }

    public void defineMovement() {
        Random r = new Random();

        this.setSpeed(r.nextInt(maxSpeed)+minSpeed);
        this.setSizeX(10);
        this.setSizeY(10);
        this.chooseDirection(r.nextBoolean());
        int randIndex = r.nextInt(3);
        Gdx.app.log("Index",randIndex+"");
        this.sprite.setX(wayPosition[randIndex]);
        //setNewYposition(r);
    }

    public Target(int x, int y, int speed, int sizeX, int sizeY, boolean direction, Texture img) {
        super(x, y, speed, sizeX, sizeY, img);


        Random r = new Random();

        //Esse calculo é necessário para que a barata não fique em apenas uma linha
        //É um ajuste por utilizar uma formula de movimento em zig zag da barata
        setNewYposition(r);

        //states[0] = new TextureRegion(this.img,0, 0 ,192, 192);
        //states[1] = new TextureRegion(this.img,0.5f, 0 ,1 , 1);

        this.sprite = new Sprite(img);
        this.sprite.setPosition(x, y);

        wayPosition = new int []{10,Gdx.graphics.getHeight()/2,Gdx.graphics.getHeight() - 50 };
        setTime(0);

        chooseDirection(direction);

    }

    @Override
    public void update(Batch batch) {

        if(isOutOfScene()){

            defineMovement();

        }
        super.update(batch);

//        if(isHide()){
//
//            if(getTime() >= 3.0){
//                setHide(false);
//            }
//        }

        Gdx.app.log("PosicaoSprite",this.sprite.getX() + ":" + this.sprite.getY());

        sprite.draw(batch);
        this.sprite.setPosition(this.sprite.getX(),this.sprite.getY() + direction * Gdx.graphics.getDeltaTime() * speed);
        //Gdx.app.log("DeltaTime","Delta: "+ Gdx.graphics.getDeltaTime()*1000 );
    }

    private float calcWave() {

        return getY() + (-(float)Math.cos(getX()/100)*100);
    }

    private boolean isOutOfScene() {

        return (getY()> Gdx.graphics.getHeight()+400) || (getX() > Gdx.graphics.getWidth()+400) || (getY() <=-800) || (getX() <= -400);
    }

    @Override
    public boolean hit(float x, float y){

        if(isTouched(x, y)) {
            Gdx.app.log("Barata", "Tocou!!! " + x + ":" + y);

            sprite.setRegion(img);
            speed = 0;
            return true;
        }

        return false;
    }

    public void goOtherSide(int direction){
        if(direction == 1){
            this.setDirection(1);
            this.sprite.setRotation(this.sprite.getRotation() - 180);
        }else{
            this.setDirection(-1);
            this.sprite.setRotation(this.sprite.getRotation() + 180);
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        batch.draw(img,100,100);
    }


    public void chooseDirection(boolean direction) {
        if(direction){
            appersLeftSide();
        }else{
            appersRightSide();
        }
    }

    private void appersRightSide() {
        this.setDirection(-1);
        //turnLeft();
        //this.setX(Gdx.graphics.getWidth());
    }

    private void appersLeftSide() {
        this.setDirection(1);
        //turnRight();
        //this.setX(-150);
    }
}
