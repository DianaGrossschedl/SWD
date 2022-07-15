package at.compus02.swd.ss2022.game;

import at.compus02.swd.ss2022.game.behavior.RightLeftBehavior;
import at.compus02.swd.ss2022.game.behavior.UpDownBehavior;
import at.compus02.swd.ss2022.game.factories.FactoryCreateEnemy;
import at.compus02.swd.ss2022.game.factories.FactoryCreatePlayer;
import at.compus02.swd.ss2022.game.factories.FactoryCreateTile;
import at.compus02.swd.ss2022.game.gameobjects.*;
import at.compus02.swd.ss2022.game.gameobjects.moveables.Dog;
import at.compus02.swd.ss2022.game.gameobjects.moveables.Flea;
import at.compus02.swd.ss2022.game.input.GameInput;
import at.compus02.swd.ss2022.game.observer.PositionObserver;
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

	private final float updatesPerSecond = 4; // original value == 60
	private final float logicFrameTime = 1 / updatesPerSecond;
	private float deltaAccumulator = 0;
	private BitmapFont font;



	@Override
	public void create() {
		batch = new SpriteBatch();
		FactoryCreateTile tileFactory = new FactoryCreateTile();
		FactoryCreatePlayer playerFactory = new FactoryCreatePlayer();
		FactoryCreateEnemy enemyFactory = new FactoryCreateEnemy();

		tileFactory.calculateBackground(gameObjects);
		/*for (int i = 0; i < 16; i++) {
			tileFactory.drawOneElement("Water",gameObjects,3,i);
		}*/
		tileFactory.drawElements("Water",gameObjects);

		//Dog bingo = new Dog();
		Dog bingo = Dog.getInstance();
		PositionObserver dogObserver = new PositionObserver();

		gameInput.takeGameObjects(gameObjects);
		gameObjects.add(bingo);
		gameInput.takeDog(bingo);
		gameInput.registerObserver(dogObserver);
		gameInput.run();

		Flea[] fleaList = gameInput.getFleaList();

		for (int i = 0; i <fleaList.length ; i++) {
			fleaList[i] = new Flea();
			gameObjects.add(fleaList[i]);

			int x = (int)(-240 +  Math.random() * 240);
			int y = (int)(-240 + Math.random() * 240);

			x = x - (x % 30);
			y = y - (y % 30);

			fleaList[i].setPosition(x,y);

			//enemyFactory.drawOneElement(fleaList[i],gameObjects,x,y );

			if (i%2 == 0){
				fleaList[i].setBehavior(new UpDownBehavior(dogObserver));
			} else{
				fleaList[i].setBehavior(new RightLeftBehavior(dogObserver));
			}


		}

		/*Flea flea1 = new Flea();
		enemyFactory.drawOneElement(flea1, gameObjects,5, 7);
		flea1.setBehavior(new UpDownBehavior(dogObserver));
		gameInput.takeFlea(flea1);

		Flea flea2 = new Flea();
		enemyFactory.drawOneElement(flea2, gameObjects, 10, 10);
		flea2.setBehavior(new RightLeftBehavior(dogObserver));
		gameInput.takeFlea(flea2);

		*/


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
		font.draw(batch, "points: " + gameInput.getPoints(), -220, -220);
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