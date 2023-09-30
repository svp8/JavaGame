package org.example.models;

import org.example.models.defence.DefenceInterface;
import org.example.models.statuses.Status;
import org.example.models.weapons.WeaponInterface;

import java.util.ArrayList;
import java.util.Random;

public class Entity {
    private WeaponInterface weapon;
    private DefenceInterface defence;
    //for attack modifier
    private int attack;
    private int health;
    private int maxHealth;
    private boolean active=true;

    private ArrayList<Status> statuses=new ArrayList();

    public ArrayList<Status> getStatuses() {
        return statuses;
    }
    public ArrayList<Status> addStatus(Status status) {
        statuses.add(status);
        return statuses;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Entity(WeaponInterface weapon, DefenceInterface defence, int attack, int maxHealth) {
        this.weapon = weapon;
        this.defence = defence;
        this.attack = attack;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public int getAttack() {
        return attack;
    }

    public void applyStatuses(){
        statuses.removeIf(x->!x.applyStatusEffects(this));
        System.out.println(statuses);
    }
    public void fight(Entity enemy){
        int modifier=attack-enemy.getDefence()+1;
        if(modifier<0){
            modifier=1;
        }
        Random random=new Random();
        while(modifier>0){
            if(random.ints(1, 6)
                    .findFirst()
                    .getAsInt()>4){
                System.out.println(this.getClass().toString() +" attacks");
                weapon.attack(enemy);
                break;
            };
            modifier--;
        }

    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence.getDefence();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

}
