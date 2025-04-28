import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n + 1];
        Queue<int[]> queue = new LinkedList<>();
        int maxDistance = Integer.MIN_VALUE;
        int cnt = 0;

        queue.offer(new int[] {1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int current = poll[0];
            int distance = poll[1];
            
            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    int nextDistance = distance + 1;
                    queue.offer(new int[] {next, nextDistance});
                    
                    if(nextDistance == maxDistance) {
                        cnt++;
                    } else if(nextDistance > maxDistance) {
                        maxDistance = nextDistance;
                        cnt = 1;
                    }
                }
            }
        }

        return cnt;
    }
}