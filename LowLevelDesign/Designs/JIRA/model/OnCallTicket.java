package TicketManagementSystem.model;

import java.util.Arrays;

public class OnCallTicket extends Ticket {
    public OnCallTicket(String title) {
        super(title);
    }

    // Defines the allowed status transitions for OnCallTicket: OPEN -> IN_PROGRESS -> RESOLVED
    @Override
    protected void defineStatusFlow() {
        this.statusFlow = Arrays.asList(
                TicketStatus.OPEN,
                TicketStatus.IN_PROGRESS,
                TicketStatus.RESOLVED
        );
    }
}