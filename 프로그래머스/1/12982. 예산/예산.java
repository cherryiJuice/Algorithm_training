import java.util.Arrays;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int sum=0;
        Arrays.sort(d);
        for(int i=0; i<d.length; i++){
            if(sum+d[i]<=budget){
                sum+=d[i];
                answer=i+1;
            }
            else break;  
        }
        return answer;
    }
}