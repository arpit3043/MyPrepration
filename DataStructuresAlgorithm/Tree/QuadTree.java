package Tree;

public class QuadTree {
    static class QuadNode {
        String color;
        QuadNode topLeft;
        QuadNode topRight;
        QuadNode bottomLeft;
        QuadNode bottomRight;

        public QuadNode(String color) {
            this.color = color;
        }

        public QuadNode(QuadNode topLeft, QuadNode topRight, QuadNode bottomLeft, QuadNode bottomRight) {
            this.color = null;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }

        public boolean isLeaf() {
            return color != null;
        }
    }

    public static int countBlackPixels(QuadNode node, int width, int height) {
        if (node.isLeaf()) {
            if(node.color.equals("black")) {
                return width * height;
            }
            return 0;
        }

        int halfWidth = width / 2;
        int halfHeight = height / 2;

        return countBlackPixels(node.topLeft, halfWidth, halfHeight) +
            countBlackPixels(node.topRight, halfWidth, halfHeight) +
            countBlackPixels(node.bottomLeft, halfWidth, halfHeight) +
            countBlackPixels(node.bottomRight, halfWidth, halfHeight);
    }

    public static double percentageBlack(QuadNode root, int width, int height) {
        int totalPixels = width * height;
        int blackPixels = countBlackPixels(root, width, height);
        return (blackPixels * 100.0) / totalPixels;
    }

    public static void main(String[] args) {
        QuadNode white = new QuadNode("white");
        QuadNode black = new QuadNode("black");

        // Internal node with 3 white and 1 black quadrant (bottomRight)
        QuadNode root = new QuadNode(white, white, white, black);

        double percent = percentageBlack(root, 4, 4);
        System.out.println("Black Percentage: " + percent + "%");
    }
}
