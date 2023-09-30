package org.example.models.weapons;

import org.example.models.Entity;

import java.util.Random;

public class Weapon implements WeaponInterface {
    private int damageMin;
    private int damageMax;

    public void attack(Entity enemy) {
        int health=enemy.getHealth();
        Random random=new Random();
        int num=random.nextInt(getDamageMax() - getDamageMin()) +getDamageMin();
        System.out.println("Attack damage: "+num);
        enemy.setHealth(health-num);

    }
    public Weapon(int damageMin, int damageMax) {
        this.damageMin = damageMin;
        this.damageMax = damageMax;
    }

    public int getDamageMin() {
        return damageMin;
    }

    public void setDamageMin(int damageMin) {
        this.damageMin = damageMin;
    }

    public int getDamageMax() {
        return damageMax;
    }

    public void setDamageMax(int damageMax) {
        this.damageMax = damageMax;
    }
}
