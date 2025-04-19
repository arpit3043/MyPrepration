package DesignPatterns.Behavioural.Memento.commands;

import java.awt.Color;

import DesignPatterns.Behavioural.Memento.editor.Editor;
import DesignPatterns.Behavioural.Memento.shapes.Shape;

public class ColorCommand implements Command {
    private Editor editor;
    private Color color;

    public ColorCommand(Editor editor, Color color) {
        this.editor = editor;
        this.color = color;
    }

    @Override
    public String getName() {
        return "Colorize: " + color.toString();
    }

    @Override
    public void execute() {
        for (Shape child : editor.getShapes().getSelected()) {
            child.setColor(color);
        }
    }
}
