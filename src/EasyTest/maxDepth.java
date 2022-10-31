package EasyTest;

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class maxDepth {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public class BinaryTree {

        public TreeNode root = null;

        public BinaryTree(int[] array, int index) {
            root = createBinaryTree(array, index);
        }
        // 创建二叉树

        private TreeNode createBinaryTree(int[] array, int index) {

            TreeNode treeNode = null;
            if (index < array.length) {
                treeNode = new TreeNode(array[index]);
                // 对于顺序存储的完全二叉树，如果某个节点的索引为index，其对应的左子树的索引为2*index+1，右子树为2*index+1
                treeNode.left = createBinaryTree(array, 2 * index + 1);
                treeNode.right = createBinaryTree(array, 2 * index + 2);
            }
            return treeNode;

        }

        private void showData(TreeNode node) {
            System.out.print(node);
        }

        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;

        }

        public void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            BinaryTree bt = new BinaryTree(arr, 0);

        }
    }
}
