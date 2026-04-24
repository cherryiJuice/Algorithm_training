class Solution {
    boolean[] visited;
    
    private void dfs (int i, int[][] computers) {
        visited[i] = true;
        for(int j=0; j<computers.length; j++) {
            if(computers[i][j] == 1 && !visited[j]) 
                dfs(j, computers);
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                answer++;
                dfs(i, computers);
            }
        }
        return answer;
    }
}