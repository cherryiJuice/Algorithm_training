import java.util.*;

class Solution {
    List<Set<Integer>> candidateKeys = new ArrayList<>();

    public int solution(String[][] relation) {
        int colLen = relation[0].length;
        
        // 컬럼의 조합을 1개부터 colLen개까지 탐색
        for (int i = 1; i <= colLen; i++) {
            dfs(relation, new LinkedHashSet<>(), 0, i);
        }
        
        return candidateKeys.size();
    }

    void dfs(String[][] relation, Set<Integer> temp, int start, int size) {
        // 목표로 하는 조합의 길이에 도달했을 때
        if (temp.size() == size) {
            if (isUnique(temp, relation) && isMinimal(temp)) {
                candidateKeys.add(new HashSet<>(temp));
            }
            return;
        }

        for (int i = start; i < relation[0].length; i++) {
            temp.add(i);
            dfs(relation, temp, i + 1, size);
            temp.remove(i);
        }
    }

    // 유일성 검사: 모든 행을 구분할 수 있는가?
    boolean isUnique(Set<Integer> temp, String[][] relation) {
        Set<String> set = new HashSet<>();
        for (String[] row : relation) {
            StringBuilder sb = new StringBuilder();
            for (int col : temp) {
                sb.append(row[col]).append("/");
            }
            set.add(sb.toString());
        }
        return set.size() == relation.length;
    }

    // 최소성 검사: 현재 조합이 기존 후보키를 포함하고 있는가?
    boolean isMinimal(Set<Integer> temp) {
        for (Set<Integer> key : candidateKeys) {
            if (temp.containsAll(key)) return false;
        }
        return true;
    }
}