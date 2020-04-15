package solutions;

import java.util.*;

public class _196_SumTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    private static Map<Integer, Integer> map = new HashMap<>();

    private static TreeNode constructSumTree(TreeNode root) {
        if(null == root)
            return root;


        TreeNode temp = root;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(temp);
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                temp = q.poll();
                if(map.containsKey(temp.val)) {
                    map.put(temp.val, 1 + map.get(temp.val));
                }
                else {
                    map.put(temp.val, 1);
                }
                if(null != temp.left) {
                    temp.val += temp.left.val;
                    q.add(temp.left);
                }

                if(null != temp.right) {
                    temp.val += temp.right.val;
                    q.add(temp.right);
                }

                size--;
            }
        }
        return root;
    }

    private static void inorder(TreeNode root) {
        if(null == root) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-5);
        root = constructSumTree(root);
        inorder(root);

        List<Integer> l = new ArrayList<>(map.values());
        Collections.sort(l, Collections.reverseOrder());
        System.out.println("");
        System.out.println(l);
    }

}
