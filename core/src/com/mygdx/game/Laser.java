package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Laser extends BaseActor{

    private Rectangle laserRectangle;

    public Laser(float x, float y)
    {
        super();

        Rectangle laserRectangle = new Rectangle();
        laserRectangle.x = x;
        laserRectangle.y = y;
        laserRectangle.width = 4;
        laserRectangle.height = 12;

        loadTexture();

        addAction(Actions.delay(1));
        addAction( Actions.after( Actions.fadeOut(0.5f)));
        addAction( Actions.after( Actions.removeActor()));


    }

    public void moveFriendly(){

        laserRectangle.x = laserRectangle.x;
        laserRectangle.y += 600 * Gdx.graphics.getDeltaTime();



    }


    public void moveEnemy(){

        laserRectangle.x = laserRectangle.x;
        laserRectangle.y -= 600 * Gdx.graphics.getDeltaTime();



    }


}



