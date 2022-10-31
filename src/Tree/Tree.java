package Tree;

public class Tree {
    Node root; // 根节点
    int size; // 树长度
    char[] data; // 数的数据

    public Tree(char[] data) {
        this.data = data;
        size = data.length;
        root = createTree(0);
    }

    public Node createTree(int index) { // 采用递归生成二叉树
        if (index >= size)
            return null;
        if (data[index] == '0')
            return null;
        Node node = new Node(data[index]);
        node.setLeft(createTree(2 * index + 1));
        node.setRight(createTree(2 * index + 2));
        return node;
    }

    public void preShow(Node node) { // 先序遍历
        if (node != null) {
            System.out.print(node.getData() + " ");
            preShow(node.getLeft());
            preShow(node.getRight());
        }
    }

    public void middleShow(Node node) { // 中序遍历
        if (node != null) {
            middleShow(node.getLeft());
            System.out.print(node.getData() + " ");
            middleShow(node.getRight());
        }
    }

    public void backShow(Node node) { // 后序遍历
        if (node != null) {
            backShow(node.getLeft());
            backShow(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }

    public Node getRoot() { // 得到根节点
        return root;
    }
}
