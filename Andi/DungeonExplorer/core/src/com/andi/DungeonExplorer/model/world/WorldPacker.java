package com.andi.DungeonExplorer.model.world;

import com.andi.DungeonExplorer.Settings;
import com.andi.DungeonExplorer.model.TERRAIN;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by brytonhayes on 11/27/17.
 *
 * Packs a world into csv files for tiles, objects, and actors
 *
 *
 */

public class WorldPacker {

    private World world;

    private AssetManager assetManager;

    int[][] tileArr;
    int[][] objArr;
    int[][] actorArr;

    public WorldPacker(World world){
        this.world = world;
        this.assetManager = world.getAssetManager();
        tileArr = new int[world.getWidth()][world.getHeight()];
        objArr = new int[world.getWidth()][world.getHeight()];
        actorArr = new int[world.getWidth()][world.getHeight()];

        //initialize arrays
        for (int i = 0; i < world.getMap().getWidth(); i++) {
            for (int j = 0; j < world.getMap().getHeight(); j++) {
                tileArr[i][j] = -1;
                objArr[i][j] = -1;
                actorArr[i][j] = -1;

            }
        }



    }

    public void packTiles(){
        for (int i = 0; i < world.getMap().getWidth(); i++) {
            for (int j = 0; j < world.getMap().getHeight(); j++) {
                int type = 0;
                if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.GRASS_0) {
                    type = 0;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.GRASS_1) {
                    type = 1;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.GRASS_2) {
                    type = 2;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.INDOOR_TILES) {
                    type = 3;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.INDOOR_TILES_BLOOD) {
                    type = 4;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.INDOOR_WALL_LEFT_BOTTOM) {
                    type = 5;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.INDOOR_WALL_LEFT_MIDDLE) {
                    type = 6;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.INDOOR_WALL_LEFT_TOP) {
                    type = 7;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.INDOOR_WALL_MIDDLE_TOP) {
                    type = 8;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.INDOOR_WALL_MIDDLE_MIDDLE) {
                    type = 9;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.INDOOR_WALL_MIDDLE_BOTTOM) {
                    type = 10;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.INDOOR_WALL_RIGHT_TOP) {
                    type = 11;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.INDOOR_WALL_RIGHT_MIDDLE) {
                    type = 12;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.INDOOR_WALL_RIGHT_BOTTOM) {
                    type = 13;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.DUNG_WALL_LEFT_BOTTOM) {
                    type = 14;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.DUNG_WALL_LEFT_MIDDLE) {
                    type = 15;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.DUNG_WALL_LEFT_TOP) {
                    type = 16;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.DUNG_WALL_MIDDLE_TOP) {
                    type = 17;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.DUNG_WALL_MIDDLE_MIDDLE) {
                    type = 18;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.DUNG_WALL_MIDDLE_BOTTOM) {
                    type = 19;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.DUNG_WALL_RIGHT_TOP) {
                    type = 20;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.DUNG_WALL_RIGHT_MIDDLE) {
                    type = 21;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.DUNG_WALL_RIGHT_BOTTOM) {
                    type = 22;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.ds_WALL_LEFT_BOTTOM) {
                    type = 23;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.ds_WALL_LEFT_MIDDLE) {
                    type = 24;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.ds_WALL_LEFT_TOP) {
                    type = 25;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.ds_WALL_MIDDLE_TOP) {
                    type = 26;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.ds_WALL_MIDDLE_MIDDLE) {
                    type = 27;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.ds_WALL_MIDDLE_BOTTOM) {
                    type = 28;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.ds_WALL_RIGHT_TOP) {
                    type = 29;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.ds_WALL_RIGHT_MIDDLE) {
                    type = 30;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.ds_WALL_RIGHT_BOTTOM) {
                    type = 31;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.lava_WALL_LEFT_BOTTOM) {
                    type = 32;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.lava_WALL_LEFT_MIDDLE) {
                    type = 33;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.lava_WALL_LEFT_TOP) {
                    type = 34;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.lava_WALL_MIDDLE_TOP) {
                    type = 35;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.lava_WALL_MIDDLE_BOTTOM) {
                    type = 36;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.lava_WALL_RIGHT_TOP) {
                    type = 37;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.lava_WALL_RIGHT_MIDDLE) {
                    type = 38;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.lava_WALL_RIGHT_BOTTOM) {
                    type = 39;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.lava_WALL_MIDDLE_MIDDLE) {
                    type = 40;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.TELEPORTER) {
                    type = 41;
                }else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.ice) {
                    type = 42;
                } else if(world.getMap().getTile(i, j).getTerrain()==TERRAIN.DIRT_PATH_MIDDLE){
                    type = 43;
                } else if(world.getMap().getTile(i, j).getTerrain()==TERRAIN.SNOW_WALL_BOTTOM){
                    type = 44;
                } else if(world.getMap().getTile(i, j).getTerrain()==TERRAIN.SNOW_WALL_LEFT){
                    type = 45;
                } else if(world.getMap().getTile(i, j).getTerrain()==TERRAIN.SNOW_WALL_RIGHT){
                    type = 46;
                } else if(world.getMap().getTile(i, j).getTerrain()==TERRAIN.SNOW_WALL_TOP){
                    type = 47;
                } else if(world.getMap().getTile(i, j).getTerrain()==TERRAIN.SNOW_TILE){
                    type = 48;
                } else if(world.getMap().getTile(i, j).getTerrain()==TERRAIN.SNOW_WALL_BOTTOM_LEFT_CORNER){
                    type = 49;
                } else if(world.getMap().getTile(i, j).getTerrain()==TERRAIN.SNOW_WALL_BOTTOM_RIGHT_CORNER){
                    type = 50;
                } else if(world.getMap().getTile(i, j).getTerrain()==TERRAIN.SNOW_WALL_TOP_LEFT_CORNER){
                    type = 51;
                } else if(world.getMap().getTile(i, j).getTerrain()==TERRAIN.SNOW_WALL_TOP_RIGHT_CORNER){
                    type = 52;
                } else if(world.getMap().getTile(i, j).getTerrain()==TERRAIN.SNOW_WALL_FILLER){
                    type = 53;
                } else if(world.getMap().getTile(i, j).getTerrain()==TERRAIN.SNOW_SWITCH){
                    type = 54;
                } else if (world.getMap().getTile(i, j).getTerrain() == TERRAIN.DUNGEON_FLOOR) {
                    type = 55;
                }

                tileArr[i][j] = type;

            }
        }
    }

    public void packObjects(){
        TextureAtlas atlas = assetManager.get("res/graphics_packed/tiles/tilepack.atlas", TextureAtlas.class);

        Animation flowerAnimation = new Animation(0.8f, atlas.findRegions("flowers"), Animation.PlayMode.LOOP_PINGPONG);
        Animation doorOpen = new Animation(0.8f/4f, atlas.findRegions("woodenDoor"), Animation.PlayMode.NORMAL);
        Animation doorClose = new Animation(0.5f/4f, atlas.findRegions("woodenDoor"), Animation.PlayMode.REVERSED);
        Animation chestOpen = new Animation(0.8f/4f, atlas.findRegions("chest"), Animation.PlayMode.NORMAL);
        Animation flippedChestOpen = new Animation(0.8f/4f, atlas.findRegions("flippedChest"), Animation.PlayMode.NORMAL);
        Animation crystalChange = new Animation(0.8f/4f, atlas.findRegions("crystalChange"), Animation.PlayMode.NORMAL);
        Animation spikeUp = new Animation(0.8f/4f, atlas.findRegions("spike"), Animation.PlayMode.NORMAL);
        Animation spikeDown = new Animation(0.8f/4f, atlas.findRegions("spike"), Animation.PlayMode.REVERSED);

        for (int i = 0; i < world.getMap().getWidth(); i++) {
            for (int j = 0; j < world.getMap().getHeight(); j++) {

                int type = 0;
                if(objArr[i][j] != -1){
                    type = objArr[i][j];
                }
                if(world.getMap().getTile(i, j).getObject().getSprite() == atlas.findRegion("large_tree")) {
                    type = 1;
                    objArr[i+1][j] = 0;
                    objArr[i][j+1] = 0;
                    objArr[i+1][j+1] = 0;
                }


                objArr[i][j] = type;

            }
        }
    }







}
