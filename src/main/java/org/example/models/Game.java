package org.example.models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Game {
	private int level;
	private PropertyChangeSupport support;
	public Game() {
        support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }
}
