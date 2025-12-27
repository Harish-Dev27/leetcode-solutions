package binarytrees;

public class TestTrees {
    public static void main(String[] args) {
        /**
         *      1
         *     / \
         *    2   5
         *       / \
         *      7   10
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(10);

        preOrderTraversal(root);
        System.out.println();
        inOrderTraversal(root);
        System.out.println();
        postOrderTraversal(root);
    }

    //root left right
    private static void preOrderTraversal(Node root){
        if(root == null) return;

        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    //left root right
    private static void inOrderTraversal(Node root){
        if(root == null) return;

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    //left right root
    private static void postOrderTraversal(Node root){
        if(root == null) return;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }
}
