import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int L = 0;
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[200001];
		q.add(N);
		visited[N] = true;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int k = 0; k < size; k++) {
				int poll = q.poll();
				if (poll == K) {
					System.out.println(L);
					return;
				}

				int next = poll + 1;
				if (next < visited.length && !visited[next]) {
					q.add(next);
					visited[next] = true;
				}

				next = poll - 1;
				if (next >= 0 && !visited[next]) {
					q.add(next);
					visited[next] = true;
				}

				next = poll * 2;
				if (next < visited.length && next >= 0 && !visited[next]) {
					q.add(next);
					visited[next] = true;
				}
			}
			L++;
		}
	}

}
