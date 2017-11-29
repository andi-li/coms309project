package com.andi.DungeonExplorer.model.world.SpecialTiles;


import com.andi.DungeonExplorer.model.TERRAIN;
import com.andi.DungeonExplorer.model.Tile;
import com.andi.DungeonExplorer.model.actor.Actor;
import com.andi.DungeonExplorer.model.actor.PlayerActor;

import com.andi.DungeonExplorer.model.world.InteractTiles.Boulder;
import com.andi.DungeonExplorer.model.world.World;

import com.andi.DungeonExplorer.model.world.Items.WorldObject;




public class SwitchTile extends Tile {



    private int switchId;
    private WorldObject obj;

    public SwitchTile(TERRAIN terrain, int id) {
        super(terrain);
        this.switchId = id;


    }
    public SwitchTile(TERRAIN terrain,WorldObject obj){
        super(terrain);
        this.obj = obj;
    }


    @Override
    public void actorStep(Actor a) {
        if (a instanceof PlayerActor) {
            if(obj == null){
                World targetWorld = a.getWorld();
                for(int i = 0;i<targetWorld.getMap().getWidth();i++){
                    for(int j = 0;j<targetWorld.getMap().getHeight();j++){
                        WorldObject obj = targetWorld.getMap().getTile(i,j).getObject();
                        if(obj!= null && obj.isActivatable()
                                &&obj.getActivateId() == this.switchId){
                            obj.activate();
                        }

                    }
                }
            }
            else{
                World targetWorld = a.getWorld();
                targetWorld.addObject(obj);
            }



        }
        if(a instanceof Boulder){
            World targetWorld = a.getWorld();
            for(int i = 0;i<targetWorld.getMap().getWidth();i++){
                for(int j = 0;j<targetWorld.getMap().getHeight();j++){
                    WorldObject obj = targetWorld.getMap().getTile(i,j).getObject();
                    if(obj!= null && obj.isActivatable()
                            &&obj.getActivateId() == this.switchId){
                        obj.boulderActivate();
                    }
                }
            }
        }

    }

    @Override
    public void boulderDeactivate(Boulder a){
        World targetWorld = a.getWorld();
        for(int i = 0;i<targetWorld.getMap().getWidth();i++){
            for(int j = 0;j<targetWorld.getMap().getHeight();j++){
                WorldObject obj = targetWorld.getMap().getTile(i,j).getObject();
                if(obj!= null && obj.isActivatable()
                        &&obj.getActivateId() == this.switchId){
                    obj.boulderDeactivate();
                }
            }
        }
    }


}