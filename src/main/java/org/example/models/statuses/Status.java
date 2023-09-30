package org.example.models.statuses;

import org.example.models.Entity;

public class Status {
    private int duration;

    public Status(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean applyStatusEffects(Entity entity){
        return false;
    }
}
