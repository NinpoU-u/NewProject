package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	//Область отрисовки обьектов
	SpriteBatch batch;
	//Картинка фона
	Background bg;
	Bird bird;
	Obstacles obstacles;
	boolean gameOver;
	Texture restartTexture;

	//Запускается единожды, загружаються в память все необходимые элементы,
	// подготовительные действия, первичный расчет логики, математики
	@Override
	public void create () {
		//SpriteBatch это класс, который предостовляет текстуру и координаты для рисования текстур
		//Создается батч, с помощью конструктора
		batch = new SpriteBatch();
		bg = new Background();
		bird = new Bird();
		obstacles = new Obstacles();
		gameOver = false;
		restartTexture = new Texture("restart.png");

	}

	//Рендер это метод, который вызывается 60 раз в секунду,
	@Override
	public void render () {
		update();
		//glClearColor отрисовывает(заливает) фон RGB + alpha прозрачность
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		bg.render(batch);
		obstacles.render(batch);
		if (!gameOver){
			bird.render(batch);
		}else {
			batch.draw(restartTexture, 125, 400);
		}
		batch.end();
	}

	//нужен для обновления обьектов в системе координат, с каждой прорисовкой,
	// необходимо изменять положения обьектов, которые заданны.
	public void update(){
		bg.update();
		bird.update();
		obstacles.update();
		for (int i = 0; i < Obstacles.obs.length; i++) {
			if(bird.position.x > Obstacles.obs[i].position.x && bird.position.x < Obstacles.obs[i].position.x+50){
				if(!Obstacles.obs[i].emptySpace.contains(bird.position)){
					gameOver = true;
				}
			}
		}
		if(bird.position.y <0 || bird.position.y > 600){
			gameOver = true;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.ENTER) && gameOver){
			//пересоздаем обьекты
			recreate();
		}
	}

	//метод, который очишает ресурсы, после закрытия программы
	@Override
	public void dispose () {
		batch.dispose();
	}

	public void recreate(){
		bird.recreate();
		obstacles.recreate();
		gameOver = false;
	}
}
