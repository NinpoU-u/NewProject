package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Vector;

public class Background {
    private Texture tx;
    private Vector2 pos;

    public Background(){
        tx = new Texture("fon.png");
        pos = new Vector2(0,0);
    }
    public void render(SpriteBatch batch){
        batch.draw(tx, pos.x, pos.y);
    }
}
