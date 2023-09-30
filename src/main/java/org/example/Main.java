package org.example;

import org.example.models.Entity;
import org.example.models.Player;
import org.example.models.defence.Shield;
import org.example.models.weapons.Hammer;
import org.example.models.weapons.Hands;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Entity player=new Player(new Hands(1,5),new Shield(4),20,10);
        Entity monster=new Entity(new Hammer(3,9),new Shield(2),20,10);
        player.applyStatuses();
        if(player.isActive()){
            player.fight(monster);
        }
        if(monster.isActive()){
            monster.fight(player);
        }
        player.applyStatuses();
        if(player.isActive()){
            player.fight(monster);
        }
        player.applyStatuses();
        if(player.isActive()){
            player.fight(monster);
        }
        player.applyStatuses();
        if(player.isActive()){
            player.fight(monster);
        }
        System.out.println(player.getStatuses());


    }
}