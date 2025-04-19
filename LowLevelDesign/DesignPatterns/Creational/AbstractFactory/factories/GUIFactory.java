package DesignPatterns.Creational.AbstractFactory.factories;

import DesignPatterns.Creational.AbstractFactory.Checkboxes.Checkbox;
import DesignPatterns.Creational.AbstractFactory.buttons.Button;

public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
