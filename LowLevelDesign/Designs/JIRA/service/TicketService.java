package TicketManagementSystem.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import TicketManagementSystem.model.SubTask;
import TicketManagementSystem.model.Ticket;
import TicketManagementSystem.model.TicketStatus;

public class TicketService {
    public final Map<String, Ticket> tickets = new ConcurrentHashMap<>();

    public void addTicket(Ticket ticket) {
        tickets.put(ticket.getId(), ticket);
    }

    public boolean updateStatus(String ticketId, TicketStatus newStatus) {
        Ticket ticket = tickets.get(ticketId);
        if (ticket != null && (ticket.getStatus() != newStatus)) {
            if (ticket.updateStatus(newStatus)) {
                return true;
            }
        }
        return false;
    }

    public void addSubTask(String ticketId, SubTask subTask) {
        Ticket ticket = tickets.get(ticketId);
        if (ticket != null) {
            ticket.addSubTask(subTask);
        }
    }

    public void removeSubTask(String ticketId, String subTaskId) {
        Ticket ticket = tickets.get(ticketId);
        if (ticket != null) {
            ticket.removeSubTask(subTaskId);
        }
    }

    public boolean updateSubTaskStatus(String ticketId, String subTaskId, TicketStatus newStatus) {
        Ticket ticket = tickets.get(ticketId);
        if (ticket != null) {
            return ticket.updateSubTaskStatus(subTaskId, newStatus);
        }
        return false;
    }

    public Ticket getTicket(String ticketId) {
        return tickets.get(ticketId);
    }
}