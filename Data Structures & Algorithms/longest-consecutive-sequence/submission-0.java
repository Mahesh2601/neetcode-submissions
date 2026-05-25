class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n: nums) {
            set.add(n);
        }

        int res = 0;
        for (int n: set) {
            if (!set.contains(n-1)) {
                int x = n;
                while (set.contains(x)) {
                    x++;
                }
                res = Math.max(res, x-n);
            }
        }
        return res;
    }
}
