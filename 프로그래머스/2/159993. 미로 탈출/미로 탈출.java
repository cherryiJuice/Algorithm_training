import java.util.*;

class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int solution(String[] maps) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        int[] L = new int[2];
        int[] E = new int[2];
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[i].length(); j++) {
                if(maps[i].charAt(j) == 'S') {
                    visited[i][j] = true;
                    q.add(new int[]{i, j});
                }
                if(maps[i].charAt(j) == 'E') {
                    E[0] = i;
                    E[1] = j;
                }
                if(maps[i].charAt(j) == 'L') {
                    L[0] = i;
                    L[1] = j;
                }
            }
        }
        
        boolean isPass = false;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int s=0; s<size; s++) {
                int[] poll = q.poll();
                 
                if(poll[0] == L[0] && poll[1] == L[1]){
                    isPass = true;
                    break;
                }
                
                for(int i=0; i<4; i++) {
                    int nx = poll[0] + dx[i];
                    int ny = poll[1] + dy[i];
                    if(nx >= 0 && ny >= 0 && nx<maps.length && ny < maps[0].length() && (maps[nx].charAt(ny) == 'O' || maps[nx].charAt(ny) == 'E' || maps[nx].charAt(ny) == 'L') && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
            if(isPass) break;
            answer++;
        }
        
        
        if(!isPass) return -1;
        
        visited = new boolean[maps.length][maps[0].length()];
        q = new LinkedList<>();
        q.add(new int[]{L[0], L[1]});
        visited[L[0]][L[1]] = true;
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int s=0; s<size; s++) {
                int[] poll = q.poll();
                
                if(poll[0] == E[0] && poll[1] == E[1]) {
                    return answer;
                }
                
                for(int i=0; i<4; i++) {
                    int nx = poll[0] + dx[i];
                    int ny = poll[1] + dy[i];
                    if(nx >= 0 && ny >= 0 && nx<maps.length && ny < maps[0].length() && (maps[nx].charAt(ny) == 'O' || maps[nx].charAt(ny) == 'S' || maps[nx].charAt(ny) == 'E') && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
            answer++;
        }
        
        return -1;
    }
}