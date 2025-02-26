package Creational.FactoryMethod.factory;
import Creational.FactoryMethod.buttons.Button;
import Creational.FactoryMethod.buttons.HtmlButton;

public class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}