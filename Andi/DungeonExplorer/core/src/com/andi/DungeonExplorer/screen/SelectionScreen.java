package com.andi.DungeonExplorer.screen;

import com.andi.DungeonExplorer.model.actor.PlayerActor;
import com.andi.DungeonExplorer.model.world.editor.Index;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.google.gwt.event.dom.client.ClickEvent;

/**
 * Created by brytonhayes on 11/26/17.
 */

public class SelectionScreen implements Disposable {

    public Stage stage;
    private Viewport viewport;

    final SelectBox<String> selectBox;

    private Skin skin;

    private String[] items;
    private Index index;

    public SelectionScreen(SpriteBatch sb, Index i){
        this.index = i;

        viewport = new ScreenViewport();
        stage = new Stage(viewport, sb);

        items = new String[7];
        items[0] = "Flowers";
        items[1] = "Tree";
        items[2] = "Dungeon Wall";
        items[3] = "Purple Wall";
        items[4] = "Ice";
        items[5] = "Grass";
        items[6] = "Dungeon Floor";




        skin = new Skin(Gdx.files.internal("uiskin.json"));
        selectBox = new SelectBox<String>(skin);

        selectBox.setItems(items);
        selectBox.setSelected(items[0]);
        index.selection = selectBox.getSelected();

        Table table = new Table();
        table.setFillParent(true);
        table.setPosition(Gdx.graphics.getWidth()/2-100, Gdx.graphics.getHeight()/2-50);

        table.add(selectBox);
        stage.addActor(table);

        Gdx.input.setInputProcessor(stage);

        selectBox.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                index.selection = selectBox.getSelected();
            }
        });

    }


    @Override
    public void dispose() {
        stage.dispose();
    }
}
