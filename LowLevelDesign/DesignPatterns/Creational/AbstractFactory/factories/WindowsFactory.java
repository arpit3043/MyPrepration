package DesignPatterns.Creational.AbstractFactory.factories;

import DesignPatterns.Creational.AbstractFactory.Checkboxes.Checkbox;
import DesignPatterns.Creational.AbstractFactory.Checkboxes.WindowsCheckbox;
import DesignPatterns.Creational.AbstractFactory.buttons.Button;
import DesignPatterns.Creational.AbstractFactory.buttons.WindowsButton;

public class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
