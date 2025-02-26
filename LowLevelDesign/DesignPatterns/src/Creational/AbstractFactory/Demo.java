// https://refactoring.guru/design-patterns/abstract-factory
package Creational.AbstractFactory;

import Creational.AbstractFactory.app.Application;
import Creational.AbstractFactory.factories.GUIFactory;
import Creational.AbstractFactory.factories.MacOSFactory;
import Creational.AbstractFactory.factories.WindowsFactory;

public class Demo {

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

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }
}
