package TicketManagementSystem.model;

public class TicketFactory {
    public static Ticket createTicket(TicketType ticketType, String title) {
        return switch (ticketType) {
            case STORY -> new StoryTicket(title);
            case EPIC -> new EpicTicket(title);
            case ON_CALL -> new OnCallTicket(title);
        };
    }
}