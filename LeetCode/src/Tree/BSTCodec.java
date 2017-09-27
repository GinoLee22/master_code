package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ginolee on 9/5/17.
 */
public class BSTCodec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        preorder(root, list);
        for (int num : list) {
            sb.append(num + " ");
        }
        return sb.toString();
    }

    private void preorder(TreeNode root, List<Integer> list) {
        // base case
        if (root == null) {
            return;
        }
        // recursion by traverse
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // corner case
        if (data.length() == 0) {
            return null;
        }
        String[] dataArray = data.split(" ");
        System.out.println(dataArray.length);
        return convert(dataArray, 0, dataArray.length - 1);
    }

    private TreeNode convert(String[] nums, int startIdx, int endIdx) {
        // base case
        if (startIdx > endIdx) {
            return null;
        }
        // recursion by Divide&Conquer
        int curRoot = Integer.parseInt(nums[startIdx]);
        // find the first element > nums[startIdx]
        int idx = startIdx + 1;
        while (idx <= endIdx && Integer.parseInt(nums[idx]) <= curRoot) {
            idx++;
        }
        TreeNode root = new TreeNode(curRoot);
        root.left = convert(nums, startIdx + 1, idx - 1);
        root.right = convert(nums, idx, endIdx);
        return root;
    }


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

    public static void main(String[] args) {
        System.out.println("self-testing");
        BSTCodec bstCodec = new BSTCodec();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        String serial = bstCodec.serialize(root);
        System.out.println(serial);
        TreeNode newRoot = bstCodec.deserialize(serial);
        System.out.println(bstCodec.serialize(newRoot));

        TreeNode nullRoot = null;
        serial = bstCodec.serialize(nullRoot);
        System.out.println(serial.length());
        System.out.println(serial.split(" ").length);

        String s1 = "foo";
        String s2 = "foo";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}
