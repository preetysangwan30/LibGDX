package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Timer;

public class SoundEffect extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Sound sound;
	@Override
	public void create () {
//		batch = new SpriteBatch();
//		img = new Texture("badlogic.jpg");
		sound=Gdx.audio.newSound(Gdx.files.internal("bus_door.wav"));
		//sound.play();
		//sound.dispose();
		//long id=sound.play();
		//sound.setVolume(id,1.0f);
		//sound.setPitch(id,0.2f);
//		sound.setPan(id,1f,1f);  //only right
//		sound.setPan(id,1f,1f);   //only left
		//sound.play(1.0f,1.0f,1.0f); //AllInOne i.e vol,pitch and pan
		final long ourSoundId=sound.loop(1.0f,1.0f,1.0f);
		sound.loop(1.0f,1.0f,1.0f);
//		Timer.schedule(new Timer.Task(){
//			@Override
//			public void run(){
//				sound.pause();
//			}
//		},10);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();
	}
	
	@Override
	public void dispose () {
//		batch.dispose();
//		img.dispose();
	}
}
