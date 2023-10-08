package org.example.models;

import org.example.models.defence.Defence;
import org.example.models.weapons.Weapon;

public class Monster extends Entity {
	private String image;

	public Monster(Weapon weapon, Defence  defence, int attack, int maxHealth, String img) {
		super(weapon, defence, attack, maxHealth);
		this.setImage(img);
		// TODO Auto-generated constructor stub
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	

}
