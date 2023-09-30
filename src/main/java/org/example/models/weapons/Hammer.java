package org.example.models.weapons;

import org.example.models.Entity;
import org.example.models.statuses.StunnedStatus;

import java.util.Random;

public class Hammer extends Weapon{
    public Hammer(int damageMin, int damageMax) {
        super(damageMin, damageMax);
    }

    @Override
    public void attack(Entity enemy) {
        super.attack(enemy);
        if(enemy.isActive()){
            Random random=new Random();
            boolean flag=random.nextBoolean();
            System.out.println(flag);
            if(flag){
                enemy.addStatus(new StunnedStatus(1));
            }
        }
    }
}
