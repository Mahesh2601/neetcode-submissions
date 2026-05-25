class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            List<String> operators = List.of("+", "-", "*", "/");
            if (operators.contains(tokens[i])) {
                Integer op1 = Integer.parseInt(stack.pollLast());
                Integer op2 = Integer.parseInt(stack.pollLast());
                int res = 0;
                if (tokens[i].equals(operators.get(0))) {
                    res = op1 + op2;
                } else if (tokens[i].equals(operators.get(1))) {
                    res = op2 - op1;
                } else if (tokens[i].equals(operators.get(2))) {
                    res = op1 * op2;
                } else if (tokens[i].equals(operators.get(3))) {
                    res = op2 / op1;
                }
                stack.offerLast(String.valueOf(res));
            } else {
                stack.offerLast(tokens[i]);
            }
        }

        return Integer.valueOf(stack.peekLast());
    }
}
