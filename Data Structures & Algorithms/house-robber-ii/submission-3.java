class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] helper = new int[n];
        Arrays.fill(helper, -1);
        int first = dp(n-2, nums, 0, helper);
        int[] helper2 = new int[n];
        Arrays.fill(helper2, -1);
        return Math.max(first, dp(n-1, nums, 1, helper2));
    }

    public int dp(int i, int[] nums, int start, int[] helper) {
        if (i < start) {
            return 0;
        }
        if (helper[i] != -1) return helper[i];
        helper[i] = Math.max(
            dp(i-1, nums, start, helper),
            dp(i-2, nums, start, helper) + nums[i]
        );
        return helper[i];
    }
}
