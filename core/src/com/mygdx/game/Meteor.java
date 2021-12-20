package com.mygdx.game;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class Meteor extends BaseActor {


    public Meteor(float x, float y) {
        super();


        Rectangle meteorRectangle = new Rectangle();
        meteorRectangle.x = 800 / 2 - 64 / 2;
        meteorRectangle.y = 20;
        meteorRectangle.width = 64;
        meteorRectangle.height = 64;

        super.setActorRectangle(meteorRectangle);


        loadTexture();

        float random = MathUtils.random(30);


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
