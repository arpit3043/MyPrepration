package TicketManagementSystem;

import TicketManagementSystem.model.Ticket;
import TicketManagementSystem.model.TicketFactory;
import TicketManagementSystem.model.TicketStatus;
import TicketManagementSystem.model.TicketType;
import TicketManagementSystem.model.SubTask;
import TicketManagementSystem.service.SprintService;
import TicketManagementSystem.service.TicketService;

public class Driver {
    public static void main(String[] args){
        System.out.println("Initializing services...");
        TicketService ticketService = new TicketService();
        SprintService sprintService = new SprintService();

        System.out.println("\nCreating tickets...");
        Ticket storyTicket = TicketFactory.createTicket(TicketType.STORY, "Implement Login Feature");
        System.out.println("Created a Story Ticket: " + storyTicket.getTitle());

        Ticket epicTicket = TicketFactory.createTicket(TicketType.EPIC, "User Authentication");
        System.out.println("Created an Epic Ticket: " + epicTicket.getTitle());

        Ticket OnCallTicket = TicketFactory.createTicket(TicketType.ON_CALL, "Fix Production Bug");
        System.out.println("Created an OnCall Ticket: " + OnCallTicket.getTitle());

        System.out.println("\nAdding tickets to ticket service...");
        ticketService.addTicket(storyTicket);
        ticketService.addTicket(epicTicket);
        ticketService.addTicket(OnCallTicket);
        System.out.println("All tickets added successfully");

        System.out.println("\nUpdating story ticket status to IN_PROGRESS...");
        boolean statusUpdated = ticketService.updateStatus(storyTicket.getId(), TicketStatus.IN_PROGRESS);
        System.out.println("Status update successful: " + statusUpdated);

        System.out.println("\nAdding story ticket to sprint...");
        sprintService.addStoryToSprint(storyTicket);
        System.out.println("Story added to sprint");

        System.out.println("\nRemoving story from sprint...");
        sprintService.removeStoryFromSprint(storyTicket.getId());
        System.out.println("Story removed from sprint");

        System.out.println("\nManaging subtasks...");
        SubTask subTask = new SubTask("1", "Design Login UI", TicketStatus.OPEN, TicketType.STORY);
        System.out.println("Created subtask: " + subTask.getTitle());

        ticketService.addSubTask(storyTicket.getId(), subTask);
        System.out.println("Added subtask to story ticket");

        ticketService.updateSubTaskStatus(storyTicket.getId(), subTask.getId(), TicketStatus.IN_PROGRESS);
        System.out.println("Updated subtask status to IN_PROGRESS");

        ticketService.updateSubTaskStatus(storyTicket.getId(), subTask.getId(), TicketStatus.RESOLVED);
        System.out.println("Updated subtask status to RESOLVED");

        ticketService.removeSubTask(storyTicket.getId(), subTask.getId());
        System.out.println("Removed subtask from story ticket");
    }
}
