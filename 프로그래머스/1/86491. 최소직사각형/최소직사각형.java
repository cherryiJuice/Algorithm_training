import java.util.*;

class Solution {
    boolean[] visited;
    public int solution(int[][] sizes) {
        int max_w = 0; 
        int max_h = 0; 

        for (int[] card : sizes) {
            int longer = Math.max(card[0], card[1]);
            int shorter = Math.min(card[0], card[1]);

            // 긴 쪽들 중에서 가장 큰 값
            // 짧은 쪽들 중에서 가장 큰 값
            max_w = Math.max(max_w, longer);
            max_h = Math.max(max_h, shorter);
        }

        return max_w * max_h;
    }
}