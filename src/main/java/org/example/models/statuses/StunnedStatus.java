package org.example.models.statuses;

import org.example.models.Entity;

public class StunnedStatus extends Status{

    public StunnedStatus(int duration) {
        super(duration);
    }

    @Override
    public boolean applyStatusEffects(Entity entity) {
        if(getDuration()==0){
            entity.setActive(true);
            return false;
        }
        else {
            entity.setActive(false);
            setDuration(getDuration()-1);
            return true;
        }

    }
}
