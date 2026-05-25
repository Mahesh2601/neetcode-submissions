class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;
            int start = i+1, end = n-1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    res.add(new ArrayList<>(List.of(nums[i], nums[start], nums[end])));
                    start++;
                    while (start < n && nums[start] == nums[start-1]) {
                        start++;
                    }
                } else if (sum < 0) start++;
                else end--;
            }
        }
        return res;
    }
}
