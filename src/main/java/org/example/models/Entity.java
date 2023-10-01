package org.example.models;

import org.example.models.defence.Defence;
import org.example.models.defence.DefenceInterface;
import org.example.models.statuses.Status;
import org.example.models.weapons.Weapon;
import org.example.models.weapons.WeaponInterface;

import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Entity {
	private int level=1;
    private Weapon weapon;
    private Defence defence;
    //for attack modifier
    private int attack;
    private int health;
    private int maxHealth;
    private boolean active=true;
    private EventRegistry registry=EventRegistry.getInstance();

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

    public Entity(Weapon weapon, Defence defence, int attack, int maxHealth) {
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
    	String temp[]=this.getClass().toString().split(" ")[1].split("\\.");
        String name = temp[temp.length-1];
    	if(!active) {
    		registry.addEvent(name+" is stunned");
    		return;
    	}
        int modifier=attack-enemy.getDefence()+1;
        if(modifier<0){
            modifier=1;
        }
        Random random=new Random();
        boolean hit=false;
        while(modifier>0){
            if(random.ints(1, 6)
                    .findFirst()
                    .getAsInt()>4){
            	registry.addEvent(name +" attacks");
                weapon.attack(enemy);
                hit=true;
                break;
            };
            modifier--;
        }
        if(!hit) {
        	registry.addEvent(name +" missed");
        }

    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence.getDefence();
    }
    public void setDefence(Defence d) {
    	defence=d;
    }
    public void setWeapon(Weapon w) {
    	weapon=w;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}

}
