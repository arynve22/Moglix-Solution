import java.util.ArrayDeque;
import java.util.Deque;

public class Approach1 {

    
    public static int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(-1); 
        
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    
                    int currentLength = i - stack.peek();
                    maxLength = Math.max(maxLength, currentLength);
                }
            }
        }

        return maxLength;
    }

    
    public static void main(String[] args) {
        
        String s1 = "(()";
        System.out.println("Input: " + s1 + " | Output: " + longestValidParentheses(s1)); 

        
        String s2 = ")()())";
        System.out.println("Input: " + s2 + " | Output: " + longestValidParentheses(s2)); 

       
        String s3 = "";
        System.out.println("Input: " + s3 + " | Output: " + longestValidParentheses(s3));
    
        String s4 = "()(())";
        System.out.println("Input: " + s4 + " | Output: " + longestValidParentheses(s4)); 
    }
}