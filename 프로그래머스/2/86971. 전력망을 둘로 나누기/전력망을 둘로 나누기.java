import java.util.*;

class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    boolean[] visited;

    public int solution(int n, int[][] wires) {
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int min = Integer.MAX_VALUE;

        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            visited = new boolean[n + 1];
            int subtreeSize = dfs(a, b); // b를 끊은 것처럼 처리
            int other = n - subtreeSize;

            min = Math.min(min, Math.abs(subtreeSize - other));
        }

        return min;
    }

    private int dfs(int current, int cut) {
        visited[current] = true;
        int count = 1;

        for (int next : graph.get(current)) {
            if (!visited[next] && next != cut) {
                count += dfs(next, cut);
            }
        }

        return count;
    }
}
