import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int len = Integer.MAX_VALUE;
        int lt = 0;
        int sum = 0;
        
        for(int rt=0; rt< sequence.length; rt++) {
            sum += sequence[rt];
            if(sum >= k) {
                while(sum > k) {
                    sum -= sequence[lt];
                    lt++;
                }
                if(sum == k) {
                    if(len > rt - lt) {
                        answer[0] = lt; answer[1] = rt;
                        len = rt - lt;
                    }
                }
            }
        }
        
        return answer;
    }
}
