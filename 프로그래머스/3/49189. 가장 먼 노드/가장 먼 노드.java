import java.util.*;

class Solution {
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n + 1];
        
        Queue<int[]> q = new LinkedList<>(); // 거리까지 같이 저장!!!
        
        q.offer(new int[] {1, 0});
        visited[1] = true;
        
        int max = 0;
        
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int cur = poll[0];
            int distance = poll[1];
            
            for (int next : graph.get(cur)) {
                int nextDistance = distance + 1;
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, nextDistance});
                    
                    if(nextDistance > max) {
                        max = nextDistance;
                        answer = 1;
                    } else if(nextDistance == max) {
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
}