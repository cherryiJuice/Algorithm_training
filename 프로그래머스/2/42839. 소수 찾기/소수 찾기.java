import java.util.*;

class Solution {
    boolean[] visited;
    int answer = 0;
    Map<Integer, Integer> map = new HashMap<>();
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        dfs(numbers.toCharArray(), "0");
        return answer;
    }
    
    private void dfs(char[] nums, String n) {
        if(!map.containsKey(Integer.parseInt(n)) && isPrime(Integer.parseInt(n))) {
            map.put(Integer.parseInt(n), 1);
            answer++;
        }
        
        for(int i=0; i<nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(nums, n+nums[i]);
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