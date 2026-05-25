class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> q = new ArrayDeque<>();
        int[] res = new int[n-k+1];
        for (int i = 0; i < k; i++) {
            while (q.size() != 0 && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            q.offerLast(i);
        }
        res[0] = nums[q.peekFirst()];
        for (int i = k; i < n; i++) {
            while (q.size() != 0 && q.peekFirst() <= i-k) {
                q.pollFirst();
            }
            while (q.size() != 0 && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            q.offerLast(i);
            res[i-k+1] = nums[q.peekFirst()];
        }
        return res;
    }
}
