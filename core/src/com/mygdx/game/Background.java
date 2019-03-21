package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public class Background {

    //Для того чтобы не создовать 4 поля (для каждой картинки по 2), создадим иннер класс, в который поместим поля текстуры и вектора, а так же создадим конструктор
    //в котором проинициализируем координаты. В параметрах конструктора с помощью вектора, считываем изначальные параметры позиции. (Для первой картинки у нас параметры (0,0)
    // для воторой (1920,0)
    class BGPicture{
        //Создаем 2 поля для картинки и позиции.
        private Texture tx;
        private Vector2 pos;

        public BGPicture(Vector2 pos){
            //инициализация картинки(текстуры) + позицию вектора
            tx = new Texture("fon.png");
            this.pos = pos;
        }
    }

    private int speed;
    private BGPicture[] backs;

    //Создаем массив, помещаем 2 картинки, задаем с помощь. вектора их координаты.
    public Background(){
        speed = 3;
        backs = new BGPicture[2];
        backs[0] = new BGPicture(new Vector2(0,0));
        backs[1] = new BGPicture(new Vector2(1920,0));
    }

    //Отрисовываем их поочереди с помощью рендер
    public void render(SpriteBatch batch){
        for (int i = 0; i < backs.length; i++) {
            batch.draw(backs[i].tx, backs[i].pos.x, backs[i].pos.y);
        }
    }

    public void update(){
        for (int i = 0; i < backs.length; i++) {
            //у каждой картинки меняем позицию на величену прописаную в speed
            backs[i].pos.x -= speed;
        }
        //Если позиция первой картинки -1920(ушла за экран), то позиция второй картинки 1920, то есть на месте первой.
        if(backs[0].pos.x < -1920){
            backs[0].pos.x = 0;
            backs[1].pos.x = 1920;
        }
    }
}
