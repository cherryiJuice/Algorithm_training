import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int[][] connected = new int[n][n];
        Queue<int[]> q = new LinkedList<>();
        int dif = Integer.MAX_VALUE;
        
        for(int i=0; i < wires.length; i++) {
            int x = wires[i][0];
            int y = wires[i][1];
            connected[x-1][y-1] = 1;
            connected[y-1][x-1] = 1;
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(connected[i][j] == 1) {
                    connected[i][j] = 0;
                    dif = Math.min(dif, Math.abs(n -  2*bfs(i, connected)));
                    connected[i][j] = 1;
                }
            }
        }
        
        return dif;
    }
    
    private int bfs(int root, int[][] connected) {
        int n = connected.length;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int cnt = 1;
        
        q.add(root);
        visited[root] = true;
        
        while(!q.isEmpty()) {
            int cur = q.remove();
            
            for(int i=0; i<connected.length; i++) {
                if(connected[cur][i] == 1 && !visited[i]) {
                    q.add(i);
                    cnt++;
                    visited[i] = true;
                }
            }
        }
        return cnt;
    }
}