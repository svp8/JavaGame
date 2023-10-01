package org.example.models;

import org.example.models.defence.Body;
import org.example.models.defence.Defence;
import org.example.models.defence.Shield;
import org.example.models.weapons.Hammer;
import org.example.models.weapons.Hands;
import org.example.models.weapons.Weapon;

public class MonsterFactory {
	 public Monster getMonster(int level){
		 
		 switch(level) {
		 case 1:
			 return new Monster(new Hands(1,2), new Body(1), level*3, level*3+10);
		 case 2:
			 return new Monster(new Hands(1,2), new Body(2), level*3, level*3+10);
		 case 3:
			 return new Monster(new Hammer(1,2), new Shield(4), level*3, level*3+10);
		 case 4:
			 return new Monster(new Hammer(5,10), new Shield(10), level*3, level*3+10);
		 case 5:
			 return new Monster(new Hammer(5,20),new Shield(10), level*3, level*3+10);
		default:
			return null;
		 }
		 
	      
	   }
}
