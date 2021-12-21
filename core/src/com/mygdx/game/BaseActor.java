package com.mygdx.  game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

import java.awt.*;

public class BaseActor extends Actor {

   private Texture ActorImg;

   private Rectangle actorRectangle;

   private float x;
   private float y;
   private Stage mainStage;

    private float acceleration;
    private float speed;
    private float maxSpeed;
    private float deceleration;



    public BaseActor()
    {
        super();
    }

    public BaseActor(float x, float y, Stage mainStage) {
    }


    public void loadTexture()
    {

        ActorImg = new Texture("");


    }
    public void setDeceleration(float deceleration) {
        this.deceleration = deceleration;
    }

    public float getDeceleration() {
        return deceleration;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public float getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(float acceleration) {
        this.acceleration = acceleration;
    }



    public Rectangle getActorRectangle() {
        return actorRectangle;
    }

    public Rectangle getRectangle()
    {
        return this.actorRectangle;
    }


    public void setActorRectangle(Rectangle actorRectangle) {
        this.actorRectangle = actorRectangle;
    }

    public void setActorRectangleX(float x,float y)
    {
        actorRectangle.x += x;
        actorRectangle.y += y;

    }

    public void centerAtPosition(float x, float y) {

        this.x = x;
        this.y = y;

    }
}
