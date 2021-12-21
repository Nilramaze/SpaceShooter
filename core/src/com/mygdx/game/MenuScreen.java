package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.compression.lzma.Base;

public class MenuScreen extends BaseScreen{


    @Override
    public void initialize() {
        BaseActor space = new BaseActor(0,0,mainStage);
       //Todo
        space.loadTexture();
        space.setSize(800,600);

        BaseActor title = new BaseActor(0,0, mainStage);
        //Todo
        title.loadTexture();
        title.centerAtPosition(400,300);

        BaseActor start = new BaseActor(0,0,mainStage);
        //Todo
        start.loadTexture();
        start.centerAtPosition(400,300);
        start.moveBy(0, -100);
    }

    @Override
    public void update(float dt) {

        if(Gdx.input.isKeyPressed(Input.Keys.SPACE))
            SpaceGame.setActiveScreen( new LevelScreen());


    }
}
