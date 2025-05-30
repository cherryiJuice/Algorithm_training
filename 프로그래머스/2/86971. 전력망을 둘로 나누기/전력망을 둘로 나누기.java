import java.util.*;

class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] wire: wires) {
            int a = wire[0];
            int b = wire[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        for(int[] wire: wires) {
            int a = wire[0];
            int b = wire[1];
            visited = new boolean[n+1];
            
            int sub = dfs(a, b);
            int other = n - sub;
            answer = Math.min(answer, Math.abs(other - sub));
        }
        return answer;
    }
    
    private int dfs(int cur, int cut) {
        int count = 1;
        visited[cur] = true;
        for(int next : graph.get(cur)) {
            if(!visited[next] && next != cut) {
                count += dfs(next, cut);
            }
        }
        return count;
    }
}