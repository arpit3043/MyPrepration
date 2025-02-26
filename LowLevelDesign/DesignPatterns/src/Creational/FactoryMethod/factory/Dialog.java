package Creational.FactoryMethod.factory;
import Creational.FactoryMethod.buttons.Button;

public abstract class Dialog {

    public void renderWindow() {
        setupWindow();
        Button okButton = createButton();
        okButton.render();
        cleanupWindow();
    }

    public abstract Button createButton();

    protected void setupWindow() {
        System.out.println("Setting up the dialog window...");
    }

    protected void cleanupWindow() {
        System.out.println("Cleaning up after rendering the window...");
    }

    public void displayMessage(String message) {
        System.out.println("Dialog message: " + message);
    }

    public void handleButtonClick() {
        System.out.println("Handling button click in the dialog...");
    }
}
