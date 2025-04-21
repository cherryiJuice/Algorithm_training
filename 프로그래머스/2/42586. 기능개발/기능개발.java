import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<progresses.length; i++) {
            int remaining = 100 - progresses[i];
            int days = (int)Math.ceil((double)remaining / speeds[i]);
            q.add(days);
        }
        
        int current = q.poll();
        int count = 1;
        
        while(!q.isEmpty()) {
            int next = q.peek();
            if(current >= next) {
                count++;
                q.poll();
            } else {
                list.add(count);
                count = 1;
                current = q.poll();
            }
        }
        list.add(count);
        
        return list.stream().mapToInt(a->a).toArray();
    }
}