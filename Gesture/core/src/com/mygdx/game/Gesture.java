package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Gesture extends ApplicationAdapter implements GestureDetector.GestureListener, InputProcessor {
	SpriteBatch batch;
	//Texture img;
	Sprite sprite;
	OrthographicCamera camera;
	GestureDetector gestureDetector;
	@Override
	public void create () {
		batch = new SpriteBatch();
		sprite=new Sprite(new Texture(Gdx.files.internal("git.png")));
		sprite.setPosition(-sprite.getWidth()/2,-sprite.getHeight()/2);
		//sprite.setOrigin(0.5f,0.5f);
		sprite.setCenter(0.5f,0.5f);
		//img = new Texture("badlogic.jpg");
		camera=new OrthographicCamera(1280,720);
		camera.update();

		InputMultiplexer multiplexer=new InputMultiplexer();
		gestureDetector=new GestureDetector(this);
		multiplexer.addProcessor(gestureDetector);
		multiplexer.addProcessor(this);

	//	gestureDetector.setLongPressSeconds(0.1f);
		Gdx.input.setInputProcessor(multiplexer);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		sprite.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		if(count>1)
		{
		sprite.setPosition(-sprite.getWidth()/2,-sprite.getHeight()/2);
		sprite.setSize(256f,256f);
		sprite.setRotation(0f);
		}
		else{
		Vector3 touchPos=new Vector3(x,y,0);
		camera.unproject(touchPos);
		sprite.setPosition(touchPos.x,touchPos.y);}

		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		Vector3 touchPos=new Vector3(x,y,0);
		camera.unproject(touchPos);
		if(sprite.getBoundingRectangle().contains(touchPos.x,touchPos.y)) {

			float alpha = sprite.getColor().a;
			if (alpha >= 0.f)
				sprite.setAlpha(alpha - 0.25f);
			else
				sprite.setAlpha(1f);
		}
		return true;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		Vector3 touchPos=new Vector3(x,y,0);
		camera.unproject(touchPos);
		sprite.setPosition(touchPos.x-sprite.getWidth()/2,touchPos.y-sprite.getHeight()/2);

		return true;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		sprite.setSize(distance,distance);
		return true;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
		float deltaX=pointer2.x-pointer1.x;
		float deltaY=pointer2.y-pointer1.y;
		float angle=(float)Math.atan2((double)deltaY,(double)deltaX)* MathUtils.radiansToDegrees;
		angle+=90f;
		if(angle<0)
			angle=360f-(-angle);
		sprite.setRotation(-angle);

		return true;
	}

	@Override
	public void pinchStop() {

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
