package binarytrees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        System.out.println();
        levelOrderTraversal(root);
    }

    //root left right
    private static void preOrderTraversal(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    //left root right
    private static void inOrderTraversal(Node root) {
        if (root == null) return;

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    //left right root
    private static void postOrderTraversal(Node root) {
        if (root == null) return;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    private static void levelOrderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> list = new LinkedList<>();

        if (root == null) return;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().data);
            }
            list.add(subList);
        }

        System.out.println(list);
    }
}
