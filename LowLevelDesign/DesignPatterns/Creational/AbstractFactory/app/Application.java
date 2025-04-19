package DesignPatterns.Creational.AbstractFactory.app;

import DesignPatterns.Creational.AbstractFactory.Checkboxes.Checkbox;
import DesignPatterns.Creational.AbstractFactory.buttons.Button;
import DesignPatterns.Creational.AbstractFactory.factories.GUIFactory;

public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}
