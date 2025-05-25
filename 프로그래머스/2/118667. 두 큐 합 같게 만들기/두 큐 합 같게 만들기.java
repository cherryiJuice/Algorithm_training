class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int n = queue1.length;
        int[] arr = new int[n*2];
        
        
        long sum1=0, sum2=0;
        for(int i=0; i<n; i++) {
            arr[i] = queue1[i];
            sum1 += queue1[i];
        }
        
        for(int i=0; i<n; i++) {
            arr[i+n] = queue2[i];
            sum2 += queue2[i];
        }
        
        long total = sum1 + sum2;
        if (total % 2 != 0) return -1;
        
        int lt = 0, rt = n;
        
        int max = n * 3;
        while(answer <= max) {
            int len = n*2;
            if(sum1 == sum2) {
                return answer;
            } else if(sum1 > sum2) {
                sum1 -= arr[lt % len];
                sum2 += arr[lt % len];
                lt++;
            } else {
                sum1 += arr[rt % len];
                sum2 -= arr[rt % len];
                rt++;
            }
            answer++;
        }
        return -1;
    }
}