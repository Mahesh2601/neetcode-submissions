class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] freq = new int[2010];
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]+1000]++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        for (int i = 0; i < k; i++) {
            pq.add(new int[]{freq[i], (i-1000)});
        }
        for (int i = k; i < 2010; i++) {
            if (pq.peek()[0] < freq[i]) {
                pq.poll();
                pq.add(new int[]{freq[i], (i-1000)});
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[1];
        }
        return res;
    }
}
