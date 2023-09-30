package org.example.models.statuses;

import org.example.models.Entity;

public class RegenerationStatus extends Status {
    public RegenerationStatus(int duration) {
        super(duration);
    }

    @Override
    public boolean applyStatusEffects(Entity entity) {
        if(getDuration()!=0){
            int health=(int) (entity.getMaxHealth()*0.05+ entity.getHealth());
            if(health>entity.getMaxHealth()){
                health=entity.getMaxHealth();
            }
            entity.setHealth(health);
            return true;
        }
        return false;

    }
}
