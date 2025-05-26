import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};
        
        int n = maps.length, m = maps[0].length;
        Queue<int[]> q = new LinkedList<>(); // x, y, dist
        
        if(maps[0][0] == 0) return -1;
        
        q.add(new int[]{0, 0, 1});
        
        while(!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            int dist = poll[2];
            
            if (x == n - 1 && y == m - 1) {
                return dist;
            }
            
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1) {
                    q.offer(new int[] {nx, ny, dist + 1});
                    maps[nx][ny] = 0; 
                }
            }
        }
        
        return -1;
    }
}