package TicketManagementSystem.model;

import java.util.Arrays;

public class EpicTicket extends Ticket {
    public EpicTicket(String title) {
        super(title);
    }

    @Override
    protected void defineStatusFlow() {
        this.statusFlow = Arrays.asList(
                TicketStatus.OPEN,
                TicketStatus.IN_PROGRESS,
                TicketStatus.RESOLVED
        );
    }
}