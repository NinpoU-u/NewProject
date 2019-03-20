package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Vector;

public class Background {

    class BGPicture{
        private Texture tx;
        private Vector2 pos;

        public BGPicture(Vector2 pos){
            tx = new Texture("fon.png");
            pos = pos;
        }
    }

    private int speed;
    private  BGPicture[] backs;

    public Background(){
        speed = 4;
        backs = new BGPicture[2];
        backs[0] = new BGPicture(new Vector2(0,0));
        backs[1] = new BGPicture(new Vector2(800,0));
    }

    public void render(SpriteBatch batch){
        batch.draw(tx, pos.x, pos.y);
    }

    public void update(){
        pos.x -= speed;
        if (pos.x < -800){
            pos.x = 0;
        }
    }
}
