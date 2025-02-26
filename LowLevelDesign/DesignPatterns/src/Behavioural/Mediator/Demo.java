package Behavioural.Mediator;
import Behavioural.Mediator.components.TextBox;
import Behavioural.Mediator.mediator.Mediator;
import Behavioural.Mediator.components.AddButton;
import Behavioural.Mediator.mediator.Editor;
import Behavioural.Mediator.components.DeleteButton;
import Behavioural.Mediator.components.Filter;
import Behavioural.Mediator.components.List;
import Behavioural.Mediator.components.SaveButton;
import Behavioural.Mediator.components.Title;
import javax.swing.*;

public class Demo {
    public static void main(String[] args) {
        Mediator mediator = new Editor();

        mediator.registerComponent(new Title());
        mediator.registerComponent(new TextBox());
        mediator.registerComponent(new AddButton());
        mediator.registerComponent(new DeleteButton());
        mediator.registerComponent(new SaveButton());
        mediator.registerComponent(new List(new DefaultListModel()));
        mediator.registerComponent(new Filter());
        mediator.createGUI();
    }
}
