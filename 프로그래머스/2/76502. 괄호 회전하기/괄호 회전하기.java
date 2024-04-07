import java.util.*;
class Solution {
    public int solution(String s) {
        int cnt = 0;
        String tmp = s;
        char[] charArray = s.toCharArray();
        int p = 0, q = 0, r = 0;
        Stack<String> stack = new Stack<>();

        for (char c : charArray) {
            if (c == '(' || c == ')') p++;
            if (c == '{' || c == '}') q++;
            if (c == '[' || c == ']') r++;
        }
        if (p % 2 != 0 || q % 2 != 0 || r % 2 != 0) return 0;
        System.out.println("tmp = " + tmp);
        for (int i = 0; i < s.length(); i++) {
            tmp = tmp.substring(1, s.length()) + tmp.substring(0, 1);
            if (extracted(tmp, stack)) {
                if (stack.isEmpty()) cnt++;
            }
            stack.clear();
        }
        return cnt;
    }

    private boolean extracted(String tmp, Stack<String> stack) {
        for (int j = 0; j < tmp.length(); j++) {
            String str = String.valueOf(tmp.charAt(j));
            if(str.equals("(") || str.equals("{") || str.equals("["))
                stack.push(str);
            else if(!stack.isEmpty()) {
                if (stack.peek().equals("(") && str.equals(")")) {
                    stack.pop();
                } else if (stack.peek().equals("{") && str.equals("}")) {
                    stack.pop();
                } else if (stack.peek().equals("[") && str.equals("]")) {
                    stack.pop();
                } else return false;
            }
            else return false;

        }
        return true;
    }
}