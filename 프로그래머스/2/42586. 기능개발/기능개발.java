import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        
        int days = 0;
        for(int i=0; i<progresses.length; i++) {
            int temp = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            System.out.println(temp);
            
            if(days >= temp) {
                list.set(list.size()-1, list.get(list.size()-1) + 1);
            } else {
                list.add(1);
                days = temp;
            }
        }
        return  list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}