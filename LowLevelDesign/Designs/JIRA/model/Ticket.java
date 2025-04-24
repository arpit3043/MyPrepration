package TicketManagementSystem.model;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Ticket {
    private final String id;
    private final String title;
    protected TicketStatus ticketStatus;
    protected List<TicketStatus> statusFlow;
    protected Map<String, SubTask> subTasks;

    public Ticket(String title) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.ticketStatus = TicketStatus.OPEN;
        this.subTasks = new ConcurrentHashMap<>();
        defineStatusFlow();
    }

    protected abstract void defineStatusFlow();

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public TicketStatus getStatus() {
        return ticketStatus;
    }

    public List<TicketStatus> getStatusFlow() {
        return statusFlow;
    }

    public boolean updateStatus(TicketStatus newStatus) {
        int currentIndex = this.statusFlow.indexOf(this.ticketStatus);
        int newIndex = this.statusFlow.indexOf(newStatus);
        if (newIndex == currentIndex + 1) {
            this.ticketStatus = newStatus;
            return true;
        }
        return false;
    }

    public void addSubTask(SubTask subTask) {
        this.subTasks.put(subTask.getId(), subTask);
    }

    public void removeSubTask(String subTask) {
        subTasks.remove(subTask);
    }

    public boolean updateSubTaskStatus(String subTaskId, TicketStatus newStatus) {
        SubTask subTask = subTasks.get(subTaskId);
        if (subTask != null) {
            subTask.setTicketStatus(newStatus);
            return true;
        }
        return false;
    }

    public Collection<SubTask> getSubTasks() {
        return subTasks.values();
    }

    public boolean areAllSubTasksCompleted() {
        return subTasks.values().stream()
                .allMatch(task -> task.getTicketStatus() == TicketStatus.DEPLOYED
                        || task.getTicketStatus() == TicketStatus.RESOLVED);
    }
}