import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer;
        // 1단계
        answer = new_id.toLowerCase();
        // 2단계
        answer = answer.replaceAll("[^a-z0-9-_.]", "");
        // 3단계
        answer = answer.replaceAll("\\.{2,}", ".");
        // 4단계
        if(answer.indexOf(".") == 0) {
            answer = answer.substring(1);
        }
        if(answer.lastIndexOf(".") == answer.length()-1 && answer.length() > 1) {
            answer = answer.substring(0, answer.length()-1);
        }
        
        // 5단계
        if(answer == "" || answer.isEmpty()) {
            answer = "a";
        }
        // 6단계
        if(answer.length() >= 16) {
            answer = answer.substring(0, 15);
            if(answer.lastIndexOf(".") == answer.length()-1) {
                answer = answer.substring(0, 14);
            }
        }
        // 7단계
        if(answer.length() <= 2) {
            String last = answer.substring(answer.length()-1);
            int count = 3 - answer.length();
            answer += last.repeat(count);
        }
        System.out.println(answer);
        return answer;
    }
}