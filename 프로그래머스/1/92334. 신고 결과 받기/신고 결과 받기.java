import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> stop_list = new HashMap<>();
        
        for(int i=0; i<id_list.length; i++) {
            // 유저가 신고한 ID 리스트를 저장하기 위한 위한 빈 set 저장
            map.put(id_list[i], new HashSet<>());
        }
        
        // 유저가 신고한 ID 리스트 중복되지 않게 저장
        for(String st: report) {
            String[] names = st.split(" ");
            map.get(names[0]).add(names[1]);
        }
        
        for(String key: map.keySet()) {
            for(String s : map.get(key)) {
                stop_list.put(s, stop_list.getOrDefault(s, 0) + 1);
            }
        }
        
        for(int i=0; i<id_list.length; i++) {
            Set<String> names = map.get(id_list[i]);
            
            for(String name : names) {
                if(stop_list.get(name) >= k) {
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
}