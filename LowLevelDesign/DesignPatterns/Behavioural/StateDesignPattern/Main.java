package DesignPatterns.Behavioural.StateDesignPattern;

import DesignPatterns.Behavioural.StateDesignPattern.ui.Player;
import DesignPatterns.Behavioural.StateDesignPattern.ui.UI;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }
}
