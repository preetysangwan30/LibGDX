package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Timer;

import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Scene2D_UI extends ApplicationAdapter implements InputProcessor {
//	SpriteBatch batch;
//	Texture img;
	private Stage stage;
	private Skin skin;
	private Table table;

	private TextButton startbutton;
	private TextButton quitbutton;

	private SpriteBatch batch;
	private Sprite sprite;

	@Override
	public void create () {
//		batch = new SpriteBatch();
//		img = new Texture("badlogic.jpg");
		skin=new Skin(Gdx.files.internal("uiskin.json"));
		stage=new Stage(new ScreenViewport());
		table =new Table();
		table.setWidth(stage.getWidth());
		table.align(Align.center|Align.top);
		table.setPosition(0,Gdx.graphics.getHeight());

		startbutton =new TextButton("New Game",skin);
		quitbutton =new TextButton("Quit Game",skin);

		startbutton.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.log("Clicked","Yes you did");
			}
		});

		table.padTop(30);
		table.add(startbutton).padBottom(30);
		table.row();
		table.add(quitbutton);

		stage.addActor(table);
		batch=new SpriteBatch();
		sprite=new Sprite(new Texture(Gdx.files.internal("badlogic.jpg")));
		sprite.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
//		final TextButton button=new TextButton("Click Me",skin,"default");
//		button.setWidth(200);
//		button.setHeight(50);
//		final Dialog dialog=new Dialog("Click Message",skin);
//
//		button.addListener(new ClickListener(){
//			@Override
//			public void clicked(InputEvent event, float x, float y) {
//				//super.clicked(event, x, y);
//				dialog.show(stage);
//				Timer.schedule(new Timer.Task(){
//					@Override
//					public void run() {
//						dialog.hide();
//					}
//				},5);
//			}
//		});
//		stage.addActor(button);
		InputMultiplexer im=new InputMultiplexer(stage,this);
		Gdx.input.setInputProcessor(im);
	}

	@Override
	public void render () {
	//	Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		sprite.draw(batch);
		batch.end();

		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();
	}
	
	@Override
	public void dispose () {
//		batch.dispose();
//		img.dispose();
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
		sprite.setFlip(!sprite.isFlipX(),sprite.isFlipY());
		return true;
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
