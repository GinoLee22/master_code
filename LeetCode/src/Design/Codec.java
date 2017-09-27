package Design;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ginolee on 7/28/17.
 * LeetCode Solution297
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        /**
         * algorithm based on BFS
         */
        StringBuilder sb = new StringBuilder();
        // corner case
        if (root == null) {
            return sb.toString();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        sb.append(root.val).append(" ");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                // left & right treeNode
                if (curNode.left != null) {
                    sb.append(curNode.left.val).append(" ");
                    queue.add(curNode.left);
                } else {
                    sb.append("# ");
                }
                if (curNode.right != null) {
                    sb.append(curNode.right.val).append(" ");
                    queue.add(curNode.right);
                } else {
                    sb.append("# ");
                }
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    // String data can't be null according to the previous serialization method
    public TreeNode deserialize(String data) {
        List<TreeNode> res = new LinkedList<>();
        // corner case
        if (data.equals("")) {
            return null;
        }
        int curIdx = 0;
        String[] dataArray = data.split(" ");
        res.add(new TreeNode(Integer.parseInt(dataArray[0])));
        boolean isLeft = true;
        for (int i = 1; i < dataArray.length; i++) {
            if (!dataArray[i].equals("#")) {
                TreeNode curNode = new TreeNode(Integer.parseInt(dataArray[i]));
                if (isLeft) {
                    res.get(curIdx).left = curNode;
                } else {
                    res.get(curIdx).right = curNode;
                }
                res.add(curNode);
            }
            if (!isLeft) {
                curIdx++;
            }
            isLeft = !isLeft;
        }
        return res.get(0);
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        // self construct a binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(codec.deserialize(codec.serialize(root)).val);

    }
}
