class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return helper(n - 1, nums, target);
    }

    int helper(int i, int[] nums, int target) {
        if (i == -1) {
            return (target == 0) ? 1 : 0;
        }
        
        int plus = helper(i-1, nums, target+nums[i]);
        int minus = helper(i-1, nums, target-nums[i]);
        return plus+minus;
    }
}
