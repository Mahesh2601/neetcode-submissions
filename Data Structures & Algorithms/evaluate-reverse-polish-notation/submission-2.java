class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            List<String> operators = List.of("+", "-", "*", "/");
            if (operators.contains(tokens[i])) {
                Integer op1 = stack.pollLast();
                Integer op2 = stack.pollLast();
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
                stack.offerLast(res);
            } else {
                stack.offerLast(Integer.valueOf(tokens[i]));
            }
        }

        return stack.peekLast();
    }
}
