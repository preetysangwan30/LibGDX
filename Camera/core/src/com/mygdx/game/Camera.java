package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.*;

public class Camera extends ApplicationAdapter implements InputProcessor{
	SpriteBatch batch;
	//Texture img;
	Sprite sprite;
	Viewport viewport;
	OrthographicCamera camera;
	final float GAME_WORLD_WIDTH=100;
	final float GAME_WORLD_HEIGHT=50;

	@Override
	public void create () {
	batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		sprite=new Sprite(new Texture(Gdx.files.internal("preety.png")));
		sprite.setPosition(0,0);
		sprite.setSize(GAME_WORLD_WIDTH,GAME_WORLD_HEIGHT);
		float aspectRatio=(float)Gdx.graphics.getHeight()/(float)Gdx.graphics.getWidth();
		//camera=new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
	    //camera=new OrthographicCamera(GAME_WORLD_HEIGHT*aspectRatio,GAME_WORLD_HEIGHT);
		camera=new OrthographicCamera();
		//viewport=new FitViewport(GAME_WORLD_WIDTH*aspectRatio,GAME_WORLD_HEIGHT,camera);
		//viewport=new FillViewport(GAME_WORLD_WIDTH*aspectRatio,GAME_WORLD_HEIGHT,camera);
		viewport=new StretchViewport(GAME_WORLD_WIDTH*aspectRatio,GAME_WORLD_HEIGHT,camera);
		//viewport=new ExtendViewport(GAME_WORLD_WIDTH*aspectRatio,GAME_WORLD_HEIGHT,camera);
		//viewport=new ScreenViewport(camera);//(GAME_WORLD_WIDTH*aspectRatio,GAME_WORLD_HEIGHT,camera);
		viewport.apply();
		//camera.translate(camera.viewportWidth/2,camera.viewportHeight/2);
		camera.position.set(GAME_WORLD_WIDTH/2,GAME_WORLD_HEIGHT/2,0);
        Gdx.input.setInputProcessor(this);
	}

	@Override
	public void resize(int width,int height){
		viewport.update(width,height);
		camera.position.set(GAME_WORLD_WIDTH/2,GAME_WORLD_HEIGHT/2,0);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		batch.begin();
		batch.setProjectionMatrix(camera.combined);
		sprite.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		//batch.dispose();
		sprite.getTexture().dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		if(keycode== Input.Keys.LEFT)
			camera.translate(-1f,0f);
		if(keycode== Input.Keys.RIGHT)
			camera.translate(1f,0f);

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
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
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
}
