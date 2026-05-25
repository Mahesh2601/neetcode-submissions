class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int n: nums) {
            heap.offer(n);
        }
        for (int i = 0; i < k-1; i++) {
            heap.poll();
        }
        return heap.peek();
    }
}
