import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<String> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        q.offer(begin);
        String cur="";
        int L = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int j=0; j<size; j++) {
                String poll = q.poll();
                if(target.equals(poll)) {
                    return L;
                }
                for(int k=0; k<words.length; k++) {
                    int trueCnt = 0;
                    String word = words[k];
                
                    if(visited[k]) continue;
                    for(int i=0; i< word.length(); i++) {
                        if(poll.charAt(i) == word.charAt(i)) {
                            trueCnt++;
                        }
                    }
                
                    if(trueCnt == word.length() - 1) {
                        q.offer(word);
                        visited[k] = true;
                        cur = word;
                    }
                }
            }
            L++;
        }
        if(!cur.equals(target)) return 0;
        
        return L;
    }
}