class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int n: nums) {
            heap.add(n);
        }
        for (int i = 0; i < k-1; i++) {
            heap.remove();
        }
        return heap.peek();
    }
}
