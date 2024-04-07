import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));
            if (str.equals(")")) {
                if (stack.isEmpty()) 
                    return false;
                else 
                    stack.pop();
            }
            else stack.push(str);
        }
        if(!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}