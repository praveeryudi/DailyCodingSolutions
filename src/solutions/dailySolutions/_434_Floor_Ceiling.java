package src.solutions.dailySolutions;

public class _434_Floor_Ceiling {

    private static class Node {
        int key;
        Node left;
        Node right;
        Node(int key) {
            this.key = key;
        }
        @Override
        public String toString() {
            return String.valueOf(key);
        }
    }

    /**
     * Gets the inorder successor
     * @param root
     * @param target
     * @return
     */
    private static Node getCeiling(Node root, int target) {
        if(null == root)
            return null;

        Node targetNode = getTargetNode(root, target);

        if(null == targetNode)
            return null;

        // If there is a right child
        if(null != targetNode.right) {
            Node n = targetNode.right;
            while(null != n.left) {
                n = n.left;
            }
            return n;
        }

        Node succ = null;
        while(null != root) {
            if(target < root.key) {
                succ = root;
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
        return succ;
    }

    /**
     * Gets the inorder predecessor
     * @param root
     * @param target
     * @return
     */
    private static Node getFloor(Node root, int target) {
        if(null == root)
            return null;

        Node targetNode = getTargetNode(root, target);

        if(null == targetNode)
            return null;

        // If left child exists
        if(null != targetNode.left) {
            Node n = targetNode.left;
            while(null != n.right) {
                n = n.right;
            }
            return n;
        }

        Node pred = null;
        while(null != root) {
            if(target > root.key) {
                pred = root;
                root = root.right;
            }
            else {
                root = root.left;
            }
        }
        return pred;
    }

    private static Node getTargetNode(Node root, int target) {
        if(null == root)
            return null;

        Node targetNode = null;
        Node curr = root;
        while(null != curr) {
            if(curr.key == target) {
                targetNode = curr;
                break;
            }

            if(curr.key < target)
                curr = curr.right;
            else
                curr = curr.left;
        }
        return targetNode;
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.right = new Node(7);
        root.right.left = new Node(12);
        root.right.left.right = new Node(14);

        Node res1 = getFloor(root, 12);
        Node res2 = getCeiling(root, 12);
        System.out.println(res1 + " :: " + res2);
    }
}