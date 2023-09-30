package org.example.models;

import org.example.models.defence.DefenceInterface;
import org.example.models.weapons.WeaponInterface;

public class Monster extends Entity {

	public Monster(WeaponInterface weapon, DefenceInterface defence, int attack, int maxHealth) {
		super(weapon, defence, attack, maxHealth);
		// TODO Auto-generated constructor stub
	}

}
