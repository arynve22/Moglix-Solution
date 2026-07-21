public class Approach2 {

    
    public static int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n]; 
        int maxLength = 0;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                
                
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } 
                
                else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    int prevValid = (i - dp[i - 1] >= 2) ? dp[i - dp[i - 1] - 2] : 0;
                    dp[i] = dp[i - 1] + 2 + prevValid;
                }

                maxLength = Math.max(maxLength, dp[i]);
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