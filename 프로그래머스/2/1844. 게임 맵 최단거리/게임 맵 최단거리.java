import java.util.*;
class Solution {
    int[] dx = {0, 1, -1, 0};
    int[] dy = {1, 0, 0, -1};
    
    public int solution(int[][] maps) {
        
        int answer = Integer.MAX_VALUE;
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        q.add(new int[]{0, 0, 1});
        
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            int distance = poll[2];
            
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nextD = distance + 1;
                
                if(nx == n-1 && ny == m-1) {
                    answer = Math.min(answer, nextD);
                }
                
                if(nx<0 || ny<0 || nx>=n || ny>=m || maps[nx][ny] == 0) continue;
                
                
                if(!visited[nx][ny]) {
                    q.add(new int[] {nx, ny, nextD});
                    visited[nx][ny] = true;
                }
            }
        }
        
        if(answer == Integer.MAX_VALUE) return -1;
        
        return answer;
    }
}