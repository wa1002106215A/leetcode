package Tree;

public class Node {
    Node left;
    Node right;
    char data;

    public Node(char data) {
        left = null;
        right = null;
        this.data = data;
    }

    public char getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setData(char data) {
        this.data = data;
    }
}
