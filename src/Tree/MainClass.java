package Tree;

public class MainClass {

    public static void main(String[] args) {
        char[] chars = new char[] {'1', '2', '3', '4', '0', '5', '6', '7', '8', '0', '0', '9', 'A'};
        Tree tree = new Tree(chars);

        System.out.println("先序遍历");
        tree.preShow(tree.getRoot());
        System.out.println();

        System.out.println("中序遍历");
        tree.middleShow(tree.getRoot());
        System.out.println();

        System.out.println("后序遍历");
        tree.backShow(tree.getRoot());
        System.out.println();
    }
}
