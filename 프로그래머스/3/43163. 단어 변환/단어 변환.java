import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int L = 0;
        int len = words.length;
        Queue<String> q = new LinkedList<>();
        boolean[] visited = new boolean[len];
        q.add(begin);
        String cur = "";
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                String poll = q.poll();
                if(poll.equals(target)) return L;
                
                for(int j=0; j<len; j++) {
                    if(visited[j]) continue;
                    
                    int trueCnt = 0;
                    String word = words[j];
                    
                    for(int k=0; k< word.length(); k++) {
                        if(poll.charAt(k) == word.charAt(k)) {
                            trueCnt++;
                        }
                    }
                    
                    if(trueCnt == target.length() - 1) {
                        q.add(word);
                        visited[j] = true;
                        cur = word;
                    }
                }
            }
            L++;
        }
        
        if(!cur.equals(target)) return 0;
        
        return 0;
    }
}