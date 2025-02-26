package Behavioural.Memento.commands;
import java.lang.String;

public interface Command {
    String getName();
    void execute();
}
