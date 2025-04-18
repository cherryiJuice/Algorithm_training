import java.util.*;

class Solution {
    boolean solution(String s) {
        Map<Character, Character> pair = Map.of(
            ')', '(', 
            ']', '[', 
            '}', '{'
        );

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (pair.containsValue(c)) {
                stack.push(c);
            } else if (pair.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != pair.get(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}