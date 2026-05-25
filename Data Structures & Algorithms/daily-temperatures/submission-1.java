class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = temperatures.length;
        int res[] = new int[n];
        for (int i = n-1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peekLast()] <= temperatures[i]) {
                stack.pollLast();
            }
            res[i] = stack.isEmpty() ? 0 : (stack.peekLast()-i);
            stack.offerLast(i);
        }
        return res;
    }
}