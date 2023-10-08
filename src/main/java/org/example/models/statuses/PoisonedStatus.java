package org.example.models.statuses;

import org.example.models.Entity;

public class PoisonedStatus extends Status {

	public PoisonedStatus(int duration) {
		super(duration);
	}
	@Override
    public boolean applyStatusEffects(Entity entity) {
        if(getDuration()!=0){
            entity.setHealth(entity.getHealth()-2);
            setDuration(getDuration()-1);
            return true;
        }
        return false;

    }

}
