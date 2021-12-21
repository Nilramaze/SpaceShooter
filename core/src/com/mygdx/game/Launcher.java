package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.

public class Launcher {

    public static void  main(String[]args)
    {
        Game spaceShooter = new SpaceGame();
        LwjglApplication launcher = new LwjglApplication ( spaceShooter, " Spaceship Adventure", 800,600);

    }
}
