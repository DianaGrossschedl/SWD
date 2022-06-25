package at.compus02.swd.ss2022.game;

import at.compus02.swd.ss2022.game.factories.FactoryCreateTile;
import at.compus02.swd.ss2022.game.gameobjects.*;
import at.compus02.swd.ss2022.game.gameobjects.moveables.Dog;
import at.compus02.swd.ss2022.game.gameobjects.moveables.Flea;
import at.compus02.swd.ss2022.game.input.GameInput;
import at.compus02.swd.ss2022.game.observer.MovementObserver;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import java.util.ArrayList;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
	private SpriteBatch batch;

	private ExtendViewport viewport = new ExtendViewport(480.0f, 480.0f, 480.0f, 480.0f);
	private GameInput gameInput = new GameInput();

	private Array<GameObject> gameObjects = new Array<>();

	private final float updatesPerSecond = 60;
	private final float logicFrameTime = 1 / updatesPerSecond;
	private float deltaAccumulator = 0;
	private BitmapFont font;



	@Override
	public void create() {
		batch = new SpriteBatch();
		FactoryCreateTile tileFactory = new FactoryCreateTile();

		tileFactory.calculateBackground(gameObjects);
		/*for (int i = 0; i < 16; i++) {
			tileFactory.drawOneElement("Water",gameObjects, 3, i);
		}*/

		tileFactory.drawOneElement("Stone",gameObjects,1,1);
		tileFactory.drawOneElement("Stone",gameObjects,14,3);
		tileFactory.drawOneElement("Bush",gameObjects,10,1);
		tileFactory.drawElements("Water", gameObjects);

		Dog bingo = new Dog();

		Flea[] fleas = gameInput.getFleas();

		for (int i = 0; i < fleas.length; i++) {
			fleas[i] = new Flea();

			int x = (int)(-240 +  Math.random() * 240);
			int y = (int)(-240 + Math.random() * 240);

			x = x - (x % 35);
			y = y - (y % 35);

			//int x = 100;
			//int y = 100;

			fleas[i].setPosition(x,y);


		}


		//Flea flea1 = new Flea();

		MovementObserver cgo = new MovementObserver(gameInput);

		gameObjects.add(bingo);


		//gameObjects.add(flea1);
		gameInput.getDog(bingo);

		//gameInput.getFleas();

		for (int i = 0; i < fleas.length; i++) {
			gameObjects.add(fleas[i]);
			gameInput.getFlea(fleas[i]);
		}

		//gameInput.getFlea(flea1);
		gameInput.registerObserver(cgo);
		gameInput.run();



		font = new BitmapFont();
		font.setColor(Color.WHITE);
		Gdx.input.setInputProcessor(this.gameInput);
	}

	private void act(float delta) {
		for(GameObject gameObject : gameObjects) {
			gameObject.act(delta);
		}
	}

	private void draw() {
		batch.setProjectionMatrix(viewport.getCamera().combined);
		batch.begin();
		for(GameObject gameObject : gameObjects) {
			gameObject.draw(batch);
		}
		font.draw(batch, "Hello Game", -220, -220);
		batch.end();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		float delta = Gdx.graphics.getDeltaTime();
		deltaAccumulator += delta;
		while(deltaAccumulator > logicFrameTime) {
			deltaAccumulator -= logicFrameTime;
			act(logicFrameTime);
		}
		draw();
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

	@Override
	public void resize(int width, int height){
		viewport.update(width,height);
	}
}