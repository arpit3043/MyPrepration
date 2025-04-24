package TicketManagementSystem.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import TicketManagementSystem.model.StoryTicket;
import TicketManagementSystem.model.Ticket;

public class SprintService {
    private final Map<String, Ticket> sprintStories = new ConcurrentHashMap<>();

    public void addStoryToSprint(Ticket ticket) {
        if (ticket instanceof StoryTicket) {
            sprintStories.put(ticket.getId(), ticket);
        } else {
            throw new IllegalArgumentException("Ticket is not a StoryTicket");
        }
    }

    public void removeStoryFromSprint(String storyId) {
        sprintStories.remove(storyId);
    }
}