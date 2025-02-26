package Creational.AbstractFactory.app;

import Creational.AbstractFactory.buttons.Button;
import Creational.AbstractFactory.checkboxes.Checkbox;
import Creational.AbstractFactory.factories.GUIFactory;

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
