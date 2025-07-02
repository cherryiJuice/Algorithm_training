import java.util.*;

class Solution {
    Set<Set<Integer>> keys = new HashSet<>();

    public int solution(String[][] relation) {
        int colCount = relation[0].length;

        for (int i = 1; i <= colCount; i++) {
            dfs(0, i, colCount, new LinkedHashSet<>(), relation);
        }

        return keys.size();
    }

    // start: 시작 인덱스, targetSize: 조합 크기
    private void dfs(int start, int targetSize, int colCount, Set<Integer> candidate, String[][] relation) {
        if (candidate.size() == targetSize) {
            // 유일성 검사
            Set<String> set = new HashSet<>();
            for (String[] row : relation) {
                StringBuilder sb = new StringBuilder();
                for (int col : candidate) {
                    sb.append(row[col]).append("|");
                }
                set.add(sb.toString());
            }

            if (set.size() == relation.length) {
                // 최소성 검사
                for (Set<Integer> key : keys) {
                    if (candidate.containsAll(key)) return;
                }
                keys.add(new HashSet<>(candidate));
            }

            return;
        }

        for (int i = start; i < colCount; i++) {
            candidate.add(i);
            dfs(i + 1, targetSize, colCount, candidate, relation);
            candidate.remove(i);
        }
    }
}
