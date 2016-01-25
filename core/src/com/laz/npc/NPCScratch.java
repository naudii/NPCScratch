package com.laz.npc;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class NPCScratch extends Game {
    SpriteBatch batch;
    Stage stage;
    Image img;
    ImageButton.ImageButtonStyle imgButtonStyle;
    ImageButton imgButton;
    TextureAtlas atlasTest;
    Skin skin;

    @Override
    public void create() {
        atlasTest = new TextureAtlas("npc.pack");
        skin = new Skin(atlasTest);

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        batch = new SpriteBatch();
        imgButtonStyle = new ImageButton.ImageButtonStyle();
        imgButtonStyle.up = skin.getDrawable("CygnusAsleep");
       imgButtonStyle.over = skin.getDrawable("CygnusAwake");

        imgButton = new ImageButton(imgButtonStyle);
        imgButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
               System.out.println("test");
            }
        });

        stage.addActor(imgButton);

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }
}