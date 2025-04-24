package TicketManagementSystem.model;

import java.util.UUID;

public class SubTask {
    private final String id;
    private final String title;
    private TicketStatus ticketStatus;
    private final TicketType ticketType;

    public SubTask(String id, String title, TicketStatus ticketStatus, TicketType ticketType) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.ticketStatus = TicketStatus.OPEN;
        this.ticketType = ticketType;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}