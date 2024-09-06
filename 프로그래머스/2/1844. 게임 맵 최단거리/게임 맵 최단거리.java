import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        // BFS를 위한 큐 선언
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 1}); // 시작점 (0, 0), 거리 1
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            
            // 상대 진영 도착 시 거리 반환
            if (x == n - 1 && y == m - 1) {
                return distance;
            }
            
            // 4방향으로 이동 가능한지 확인
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 맵 범위 안에 있고, 벽이 아닌 경우
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1) {
                    queue.add(new int[] {nx, ny, distance + 1});
                    maps[nx][ny] = 0; // 이미 방문한 곳은 다시 방문하지 않도록 처리
                }
            }
        }
        
        // 상대 진영에 도착할 수 없을 경우
        return -1;
    }
}
