package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class UserShip extends BaseActor{


    public UserShip() {
        super();


        Rectangle shipRectangle = new Rectangle();
        shipRectangle.x = 800 / 2 - 64 / 2;
        shipRectangle.y = 20;
        shipRectangle.width = 64;
        shipRectangle.height = 64;

        super.setActorRectangle(shipRectangle);


        loadTexture();
    }


    public void shoot()
    {


        Laser laser = new Laser(this.getActorRectangle().x, this.getActorRectangle().y);

    }


    public boolean overlaps (BaseActor other){

        Rectangle rect1 = this.getActorRectangle();
        Rectangle rect2 = other.getActorRectangle();


        if(rect1.overlaps(rect2)) {
            {
                return true;
            }
        } else {
            {
                return false;
            }
        }

    }



}
