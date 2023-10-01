package org.example.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class EventRegistry {

		  private static final EventRegistry instance = new EventRegistry();

		  public static EventRegistry getInstance() {
		    return instance;
		  }

		  private final List<String> events;

		  private EventRegistry() {
			  events = new ArrayList<>();
		  }

		  public void addEvent(String event) {
			  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
		        LocalDateTime now = LocalDateTime.now();
		   events.add(dtf.format(now)+" "+ event);
		  }
		  public void clearRegistry() {
			  events.clear();
		  }
		  public List<String> getEvents(){
			  return events;
		  }
}
