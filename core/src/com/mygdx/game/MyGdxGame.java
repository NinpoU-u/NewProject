package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
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

	public static final String TITLE = "NeverMore";
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
		bird.render(batch);
		obstacles.render(batch);
		batch.end();
	}

	//нужен для обновления обьектов в системе координат, с каждой прорисовкой,
	// необходимо изменять положения обьектов, которые заданны.
	public void update(){
		bg.update();
		bird.update();
		obstacles.update();
	}

	//метод, который очишает ресурсы, после закрытия программы
	@Override
	public void dispose () {
		batch.dispose();

	}
}
