package DesignPatterns.Structural.FlyWeight.Forest;

import javax.swing.*;
import java.awt.*;
import DesignPatterns.Structural.FlyWeight.Trees.Tree;
import DesignPatterns.Structural.FlyWeight.Trees.TreeFactory;
import DesignPatterns.Structural.FlyWeight.Trees.TreeType;
import java.util.ArrayList;
import java.util.List;

public class Forest extends JFrame {
    private List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, Color color, String otherTreeData) {
        TreeType type = TreeFactory.getTreeType(name, color, otherTreeData);
        Tree tree = new Tree(x, y, type);
        trees.add(tree);
    }

    @Override
    public void paint(Graphics graphics) {
        for (Tree tree : trees) {
            tree.draw(graphics);
        }
    }
}
