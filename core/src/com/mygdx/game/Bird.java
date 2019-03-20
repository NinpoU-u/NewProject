package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bird {
    Texture img;
    Vector2 position;


    public Bird(){
        img = new Texture("bird.png");
        position = new Vector2(100, 250);
    }
    public void render(SpriteBatch batch){
        batch.draw(img, position.x, position.y);
    }

    public void update(){

    }
}

