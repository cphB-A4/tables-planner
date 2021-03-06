package dtos;

import entities.Event;
import entities.Tables;
import entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EventDTO {

    private String id;
    private String description;
    private String title;
    private String time;
    User user;
    private List<Tables> tablesList;
    public EventDTO(User user, String description, String title, String time) {
        this.user = user;
        this.description = description;
        this.title = title;
        this.time = time;
    }

    public EventDTO(Event event){
        this.id = event.getId();
        //this.user = event.getUser(); // No need for this --> StackOverflowError
        this.description = event.getDescription();
        this.title = event.getTitle();
        this.time = event.getTime();
    }

    public static List<EventDTO> getDtos(List<Event> events) {
        List<EventDTO> eventDTOS = new ArrayList();
        events.forEach(event -> eventDTOS.add(new EventDTO(event)));
        return eventDTOS;
    }

    public User getUser() {
        return user;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Tables> getTablesList() {
        return tablesList;
    }

    public void setTablesList(List<Tables> tablesList) {
        this.tablesList = tablesList;
    }
}
