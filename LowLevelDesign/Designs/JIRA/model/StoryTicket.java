package TicketManagementSystem.model;

import java.util.Arrays;

public class StoryTicket extends Ticket {
    public StoryTicket(String title) {
        super(title);
    }

    @Override
    protected void defineStatusFlow() {
        this.statusFlow = Arrays.asList(
                TicketStatus.OPEN,
                TicketStatus.IN_PROGRESS,
                TicketStatus.TESTING,
                TicketStatus.IN_REVIEW,
                TicketStatus.DEPLOYED
        );
    }
}