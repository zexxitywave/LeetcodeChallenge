import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();

        for (String x : tokens) {
            if (x.equals("+")) {
                if (s.size() < 2) return 0; 
                int a = s.pop();
                int b = s.pop();
                s.push(b + a);
            } else if (x.equals("-")) {
                if (s.size() < 2) return 0; 
                int a = s.pop();
                int b = s.pop();
                s.push(b - a);
            } else if (x.equals("*")) {
                if (s.size() < 2) return 0;
                int a = s.pop();
                int b = s.pop();
                s.push(b * a);
            } else if (x.equals("/")) {
                if (s.size() < 2) return 0; 
                int a = s.pop();
                int b = s.pop();
                if (a == 0) throw new ArithmeticException("Division by zero");
                s.push(b / a);
            } else {
                try {
                    s.push(Integer.parseInt(x));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid number format: " + x);
                }
            }
        }
    
        return s.isEmpty() ? 0 : s.pop();
    }
}
