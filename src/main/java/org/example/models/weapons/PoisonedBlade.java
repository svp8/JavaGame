package org.example.models.weapons;

import java.util.Random;

import org.example.models.Entity;
import org.example.models.statuses.PoisonedStatus;


public class PoisonedBlade extends Weapon {

	public PoisonedBlade(int damageMin, int damageMax) {
		super(damageMin, damageMax);
		// TODO Auto-generated constructor stub
	}
	@Override
    public void attack(Entity enemy) {
		
        super.attack(enemy);
        if(!enemy.hasStatus(PoisonedStatus.class)){
            Random random=new Random();
            boolean flag=random.nextBoolean();
            System.out.println(flag);
            if(flag){
                enemy.addStatus(new PoisonedStatus(2));
            }
        }
    }

}
