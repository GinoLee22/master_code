package Tree;

/**
 * Created by GinoLee on 2017/2/19.
 */
public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return sortedArrayToBSTHelp(nums, 0, nums.length - 1);
    }

    // interface: int[] nums must have values
    private TreeNode sortedArrayToBSTHelp(int[] nums, int left, int right) {
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        if (right < left) {
            return null;
        }
        root.left = sortedArrayToBSTHelp(nums, left, mid - 1);
        root.right = sortedArrayToBSTHelp(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        System.out.println("\n ---------- Self-Testing");
        Solution108 s = new Solution108();

        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        TreeNode source1 = s.sortedArrayToBST(nums1);
        System.out.println(TreeNode.dfsTree(source1));

        int[] nums2 = {0};
        TreeNode source2 = s.sortedArrayToBST(nums2);
        System.out.println(TreeNode.dfsTree(source2));

    }
}
