package DesignPatterns.Creational.AbstractFactory.factories;

import DesignPatterns.Creational.AbstractFactory.Checkboxes.Checkbox;
import DesignPatterns.Creational.AbstractFactory.Checkboxes.MacOSCheckbox;
import DesignPatterns.Creational.AbstractFactory.buttons.Button;
import DesignPatterns.Creational.AbstractFactory.buttons.MacOSButton;

public class MacOSFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
