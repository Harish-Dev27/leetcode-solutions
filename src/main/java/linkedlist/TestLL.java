package linkedlist;

public class TestLL {
    public static void main(String[] args) {

        int[] arr = {0, 1, 2, 3, 4, 5};

        Node node = new Node(arr[3]);
        System.out.println(node.data);
        System.out.println(node.next);

        Node n = convertArrayToLL(arr);
        System.out.println("Checking if present:: " + checkIfPresent(n, 15));
        System.out.println("Nodes count:: " + countOfNodes(n));
    }

    public static Node convertArrayToLL(int[] arr) {
        //[0, 1, 2, 3, 4, 5]
        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }

        //traverse across all node
        System.out.println("Traversal across all nodes::");
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        return head;
    }

    private static boolean checkIfPresent(Node head, int val) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == val) return true;
            temp = temp.next;
        }
        return false;
    }

    private static int countOfNodes(Node head) {
        Node temp = head;
        int count = 0;

        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }
}
