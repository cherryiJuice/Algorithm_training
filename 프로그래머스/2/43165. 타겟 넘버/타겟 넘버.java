class Solution {
    int answer = 0;
    boolean[] visited;
    public int solution(int[] numbers, int target) {
        int sum = 0;
        for(int i=0; i<numbers.length; i++) {
            sum += numbers[i];
        }
        
        dfs(numbers, target, sum, 0);
        return answer;
    }
    
    private void dfs(int[] numbers, int target, int sum, int L) {
        if(sum == target) {
            answer++;
        }
        for(int i=L; i<numbers.length; i++) {
            dfs(numbers, target, sum - 2*numbers[i], i+1);
        }
    }
}