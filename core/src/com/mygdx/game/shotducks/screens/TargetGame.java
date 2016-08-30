package com.mygdx.game.shotducks.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.shotducks.Assets;
import com.mygdx.game.shotducks.Drop;
import com.mygdx.game.shotducks.gameobjects.BackButton;
import com.mygdx.game.shotducks.gameobjects.Target;
import com.mygdx.game.shotducks.gameobjects.Score;
import com.mygdx.game.shotducks.gameobjects.TimeCount;
//import com.mygdx.game.shotducks.ui.GameOver;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Martin on 20/09/2015.
 */
public class TargetGame implements Screen, InputProcessor {


    GestureDetector gestureListener;
    Sprite sprite;
    Target enemy1;

    ArrayList<Target> targets;
    ArrayList<Target> mesaArray;

    Drop game;
    int quantTargets = 5;
    Actor barataAtor;
    Score score;
    BackButton backButton;

    TimeCount timeCount;

    ShapeRenderer divisao1 = new ShapeRenderer();
    ShapeRenderer divisao2 = new ShapeRenderer();
    ShapeRenderer painelControle = new ShapeRenderer();
    //GameOver gameOver;

    public TargetGame(final Drop game){


        timeCount = new TimeCount();

        this.game = game;

        score = new Score();

        Gdx.input.setInputProcessor(gestureListener);

        targets = new ArrayList<Target>();

        Random r = new Random();

        for(int i = 0; i < quantTargets;i++){

            //enemy1 = getTarget();
            enemy1 = new Target(0,1000, 400, 10, 10, false, Assets.targetTexture);
            targets.add(enemy1);

        }

    }

    private void createButton() {
        TextureRegion states[] = new TextureRegion[2];
        states[0] = new TextureRegion(Assets.backButton,0,0, 200, 200);
        states[1] = new TextureRegion(Assets.backButton,0.5f,0f, 1f, 1f);
        backButton = new BackButton(25, 100, 200, 200,states[1],states[0]);
    }

    private Target getTarget() {
        //new Target(r.nextInt(100-50)+50, r.nextInt(100-90)+90, r.nextInt(10-5)+5, 10, 10, r.nextBoolean(), Assets.targetTexture);
        //new Target(r.nextInt(2000),r.nextInt(1000),r.nextInt(10)+5,10,10,r.nextBoolean(),Assets.targetTexture);
        return new Target(Assets.targetTexture);

    }

    @Override
    public void show() {

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void render(float delta){


        //limitFrameRate(60);


        Gdx.gl.glClearColor(1, 1, 1, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        divisao1.begin(ShapeRenderer.ShapeType.Filled);
        divisao1.setColor(1,0,0,1);
        divisao1.rect(Gdx.graphics.getHeight()/2,0,100,Gdx.graphics.getWidth());
        divisao1.end();

        divisao2.begin(ShapeRenderer.ShapeType.Filled);
        divisao2.setColor(1,0,0,1);
        divisao2.rect(Gdx.graphics.getWidth()/2+100,0,100,Gdx.graphics.getWidth());
        divisao2.end();

        painelControle.begin(ShapeRenderer.ShapeType.Filled);
        painelControle.setColor(0,1,0,1);
        painelControle.rect(100, 0 ,500, Gdx.graphics.getHeight());
        painelControle.end();

        game.spriteBatch.begin();

        //game.spriteBatch.draw(Assets.background, 0, 0);

        //score.drawScore(game.spriteBatch);

        //backButton.draw(game.spriteBatch);

        //timeCount.draw(game.spriteBatch);

        //if(timeCount.getTime() <=0){
            //gameOver.update();
        //}else{
            drawAllTargets();
        //}

        game.spriteBatch.end();


    }

    private void limitFrameRate(int frameRate) {
        try {
            Thread.sleep((long)(1000/frameRate- Gdx.graphics.getDeltaTime()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void drawAllTargets() {
        for(Target enemy : targets){
            enemy.update(game.spriteBatch);
        }
    }


    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

        score.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        boolean isHit = false;
        for(Target target: targets){
            //Gdx.app.log("Touch","Clicou: "+screenX+" : "+screenY);
            //Gdx.app.log("Touch","Altura "+screenX+" : "+Gdx.app.getGraphics().getHeight());
            isHit = target.hit(screenX, Gdx.app.getGraphics().getHeight() - screenY);

            if(isHit){
                if(!target.isDead()){
                    score.hitPoit(100);
                    target.setIsDead(true);
                    quantTargets--;
                }
            }

        }

        //backButton.isTouchedDown(screenX, Gdx.app.getGraphics().getHeight() - screenY);

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        //backButton.isTouchedUp(screenX, Gdx.app.getGraphics().getHeight()-screenY);
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
    public static float getCursorToModelX(int screenX, int cursorX)
    {
        return ((float)cursorX);
    }

    public static float getCursorToModelY(int screenY, int cursorY)
    {
        return ((float)(screenY - cursorY)) ;
    }

}


