package DesignPatterns.Creational.AbstractFactory;

import DesignPatterns.Creational.AbstractFactory.app.Application;
import DesignPatterns.Creational.AbstractFactory.factories.GUIFactory;
import DesignPatterns.Creational.AbstractFactory.factories.MacOSFactory;
import DesignPatterns.Creational.AbstractFactory.factories.WindowsFactory;

public class Main {
    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }
    
    private static Application configureApplication() {
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOSFactory();
        } else {
            factory = new WindowsFactory();
        }
        app = new Application(factory);
        return app;
    }
}
