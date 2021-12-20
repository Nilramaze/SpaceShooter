package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;

public class SpaceGame extends ApplicationAdapter {

	private SpriteBatch batch;
	private Texture shipImg;
	private Texture spaceBackground;
	private boolean lvlComplete;
	private Array<Laser> shipLasers;
	private Array<Laser> enemyLaser;





	private Array<EnemyShip>enemyShips;

	private Music spaceMusic;

	private OrthographicCamera camera;

	private Array<Meteor> meteors;

	private long lastEnemyShipSpawned;


	private long lastMeteorSpawned;

	private UserShip userShip;




	@Override
	public void create () {
		batch = new SpriteBatch();

		userShip = new UserShip();

		spaceBackground = new Texture("");

		spaceMusic = Gdx.audio.newMusic(Gdx.files.internal(""));

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);


		meteors = new Array<Meteor>();
		spawnMeteor();

		spaceMusic.setLooping(true);
		spaceMusic.play();


		lvlComplete = false;

			render();
	}

	@Override
	public void render () {

		ScreenUtils.clear(0, 0, 0.2f, 1);

		camera.update();

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(shipImg, userShip.getActorRectangle().x, userShip.getActorRectangle().y);
		batch.end();

		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			userShip.setActorRectangleX(userShip.getActorRectangle().x -200 * Gdx.graphics.getDeltaTime(), 20);
		}

		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			userShip.setActorRectangleX(userShip.getActorRectangle().x +200 * Gdx.graphics.getDeltaTime(), 20);
		}

		if(Gdx.input.isKeyPressed((Input.Keys.SPACE))) userShip.shoot();


		if(userShip.getActorRectangle().x < 0) userShip.setActorRectangleX(0,20);
		if(userShip.getActorRectangle().x > 800 - 64) userShip.setActorRectangleX(800 - 64, 2);



		for (Laser laser : shipLasers){

			laser.moveFriendly();
		}

		for (Laser laser : enemyLaser){

			laser.moveEnemy();
		}


		if(TimeUtils.nanoTime() - lastEnemyShipSpawned > 1000000000) spawnMeteor();


		if(TimeUtils.nanoTime() - lastMeteorSpawned > 1000000000) spawnEnemy();


		for(EnemyShip enemyShip : enemyShips){

			if(TimeUtils.nanoTime() - enemyShip.lastShotFired > 10000000) spawnEnemyLaser(enemyShip);


		}






		//Todo Winning condiion

		for(Meteor meteor : meteors){

			if(userShip.overlaps(meteor)){

			}


		}

		for(Laser laser : enemyLaser){

			if(userShip.overlaps(laser)){

			}


		}

		for(Laser laser : shipLasers){
			for(Meteor meteor : meteors) {


				if (meteor.overlaps(laser)) {

				}
			}
			for(EnemyShip enemyShip : enemyShips){


				if ( enemyShip.overlaps(laser)) {

				}

			}
		}



		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		ScreenUtils.clear(1, 0, 0, 1);




	}

	public void spawnEnemyLaser(EnemyShip enemyShip){


		Laser laser = new Laser(enemyShip.getActorRectangle().x+32, enemyShip.getActorRectangle().y);

		enemyLaser.add(laser);


	}


	private void spawnEnemyShip() {

		float x = MathUtils.random(0, 800-64);
		float y = 480-64;
		EnemyShip enemyShip = new EnemyShip(x,y);

		enemyShips.add(enemyShip);
		lastEnemyShipSpawned = TimeUtils.nanoTime();
	}


	private void spawnMeteor() {

		float x = MathUtils.random(0, 800-64);
		float y = 480-64;
		Meteor meteor = new Meteor(x,y);

		meteors.add(meteor);
		lastMeteorSpawned = TimeUtils.nanoTime();
	}

	
	@Override
	public void dispose () {
		batch.dispose();
		shipImg.dispose();
	}
}
