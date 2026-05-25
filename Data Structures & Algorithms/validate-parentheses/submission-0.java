class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.offerLast(c);
            } else {
                if (stack.isEmpty()) return false;
                char p = stack.peekLast();
                if ((p == '(' && c == ')') ||
                    (p == '{' && c == '}') ||
                    (p == '[' && c == ']')) {
                        stack.pollLast();
                    }
                else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
