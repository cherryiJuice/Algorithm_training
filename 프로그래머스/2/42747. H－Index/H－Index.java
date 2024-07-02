import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        int i;
        Arrays.sort(citations);
        for (i = citations[citations.length-1]; i >= 0 ; i--) {
            int finalI = i;
            long count = Arrays.stream(citations).filter(value -> value >= finalI).count();
            if(count >= i ) {
                break;
            }

        }
        return i;
    }
}