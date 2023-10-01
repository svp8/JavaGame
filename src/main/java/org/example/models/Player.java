package org.example.models;

import org.example.models.defence.Defence;

import org.example.models.weapons.Weapon;


public class Player extends Entity{
    private int healingPoints=4;
    private EventRegistry registry=EventRegistry.getInstance();

    public Player(Weapon weapon, Defence armour, int attack, int health) {
        super(weapon, armour, attack, health);
    }
    public void heal(){
    	if(!isActive()) {
    		registry.addEvent("Player is stunned");
    		return;
    	}
        if(healingPoints!=0){
            healingPoints--;
            int health=getMaxHealth()*30/100+getHealth();
            setHealth(Math.min(health, getMaxHealth()));
            registry.addEvent("Player healed");
        }else{
            registry.addEvent("No healing points left");
        }
    }
}
