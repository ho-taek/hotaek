package 자료구조;

public class Tree {

    public Tree() {
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);

    }

    public void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {

        Tree tree = new Tree();

        Node node1 = tree.createNode(1);
        Node node2 = tree.createNode(2);
        Node node3 = tree.createNode(3);
        Node node4 = tree.createNode(4);
        Node node5 = tree.createNode(5);
        Node node6 = tree.createNode(6);

        node1.addLeft(node2);
        node1.addRight(node3);
        node2.addLeft(node4);
        node2.addRight(node5);
        node3.addLeft(node6);

        tree.preOrder(node1);
        System.out.println();
        tree.inOrder(node1);
        System.out.println();
        tree.postOrder(node1);
    }

    public Node createNode(Object data) {
        Node n = new Node(data);
        return n;
    }

    public class Node {

        Object data;
        Node left;
        Node right;

        public Node(Object data) {
            this.data = data;
            left = null;
            right = null;
        }

        public void addLeft(Node node) {
            left = node;
        }

        public void addRight(Node node) {
            right = node;
        }
    }

}
