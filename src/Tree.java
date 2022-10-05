public class Tree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int index = -1;
        static int value = 0;

        public static Node buildTree(int nodes[]) {
            index++;
            value = nodes[index];
            if (nodes[index] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        preOrder(root);
        System.out.println(" ");
        inOrder(root);
        System.out.println(" ");
        postOrder(root);
    }

    public static void preOrder(Node node){
        if(node!=null)
        {
            System.out.print(node.data+" , ");
            preOrder(node.left);
            preOrder(node.right);
        }
        else
            System.out.print(-1+" , ");
    }

    public static void inOrder(Node node){
        if(node==null)
            return;
        inOrder(node.left);
        System.out.print(node.data+" , ");
        inOrder(node.right);
    }

    public static void postOrder(Node node){
        if(node==null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data+" , ");
    }
}
