package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Timer;

public class Music2 extends ApplicationAdapter {
//	SpriteBatch batch;
//	Texture img;
	Music song1,song2;
	@Override
	public void create () {
//		batch = new SpriteBatch();
//		img = new Texture("badlogic.jpg");
		song1=Gdx.audio.newMusic(Gdx.files.internal("dekhte-dekhte.mp3"));
		song2=Gdx.audio.newMusic(Gdx.files.internal("Dheeme-Dheeme2.mp3"));
		song1.play();
		//song2.play();
		song1.setOnCompletionListener(new Music.OnCompletionListener() {
			@Override
			public void onCompletion(Music music) {
				song2.play();
			}
		});
//		Timer.schedule(new Timer.Task() {
//			@Override
//			public void run() {
//				if(song1.isPlaying())
//					if(song1.getPosition() >= 10f)
//						song1.setVolume(song1.getVolume() - 0.2f);
//			}
//		},10,1,4);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();
	}
	
	@Override
	public void dispose () {
		song1.dispose();
		song2.dispose();
	}
}
