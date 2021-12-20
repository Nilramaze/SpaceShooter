package com.mygdx.game;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.TimeUtils;

public class EnemyShip extends BaseActor {


    float lastShotFired = TimeUtils.nanoTime();



    public EnemyShip(float x, float y) {
        super();


        Rectangle shipRectangle = new Rectangle();
        shipRectangle.x = 800 / 2 - 64 / 2;
        shipRectangle.y = 460;
        shipRectangle.width = 64;
        shipRectangle.height = 64;

        super.setActorRectangle(shipRectangle);
    }

    public boolean overlaps(BaseActor other) {

        Rectangle rect1 = this.getActorRectangle();
        Rectangle rect2 = other.getActorRectangle();


        if (rect1.overlaps(rect2)) {
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


