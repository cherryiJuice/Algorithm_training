import java.util.*;

class Solution {
    Set<Integer> candidates = new HashSet<>();
    boolean[] visited;
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        dfs(numbers.toCharArray(), "");
        return (int) candidates.stream().filter(this::isPrime).count();
    }
    
    private void dfs(char[] nums, String cur) {
        if(!cur.isEmpty()) {
            int num = Integer.parseInt(cur);
            candidates.add(num);
        }
        
        for(int i=0; i<nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(nums, cur + nums[i]);
                visited[i] = false;
            }
        }
        
    }
    
    private boolean isPrime(int n) {
        if(n <= 1) return false;
        for(int i=2; i<=Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}