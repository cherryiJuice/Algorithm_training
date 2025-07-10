import java.io.*;
import java.util.*;

public class Main {
	static List<List<Integer>> graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		// 간선 정보 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph.get(u).add(v);
			graph.get(v).add(u);  // 무방향 그래프
		}

		visited = new boolean[n + 1];
		int count = 0;

		// 연결 요소 개수 세기
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				dfs(i);
				count++;
			}
		}

		System.out.println(count);
	}

	static void dfs(int node) {
		visited[node] = true;
		for (int next : graph.get(node)) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}
}

