package org.example.models;

import org.example.models.defence.DefenceInterface;
import org.example.models.weapons.WeaponInterface;

public class Player extends Entity{
    private int healingPoints=4;


    public Player(WeaponInterface weapon, DefenceInterface armour, int attack, int health) {
        super(weapon, armour, attack, health);
    }
    public void heal(){
        if(healingPoints!=0){
            healingPoints--;
            int health=getMaxHealth()*30/100+getHealth();
            setHealth(Math.min(health, getMaxHealth()));
        }else{
            System.out.println("No healing points left");
        }
    }
}
