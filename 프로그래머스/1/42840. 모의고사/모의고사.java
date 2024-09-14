import java.util.stream.*;
import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] first_supoja = {1,2,3,4,5};
        int[] second_supoja = {2,1,2,3,2,4,2,5};
        int[] third_supoja = {3,3,1,1,2,2,4,4,5,5};
        int count1=0, count2=0, count3=0;
        
        for(int i=0; i<answers.length; i++){
            if(first_supoja[i%5] == answers[i]) count1++;
            if(second_supoja[i%8] == answers[i]) count2++;
            if(third_supoja[i%10] == answers[i]) count3++;
        }
            
        List<Integer> list = new LinkedList<>();
        
        int max = count1;
        if(max == count2 && max == count3) 
            return new int[] {1,2,3};
        list.add(1);
        if(max<count2){
            max=count2;
            list.add(2);
            list.remove(0);
        }
        else if(max== count2) list.add(2);
        if(max<count3) {
            max=count3;
            list.add(3);
            list.remove(0);
        }
        else if(max==count3) list.add(3);
        
        return list.stream().mapToInt(Integer::intValue)
            .toArray();
        
    }
}