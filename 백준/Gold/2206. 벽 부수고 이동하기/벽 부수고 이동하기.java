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
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		Main sol2206 = new Main();
		int solution = sol2206.solution(N, M, map);
		System.out.println(solution);
	}

	public int solution(int n, int m, int[][] map) {
		int[] dx = {0, 1, -1, 0};
		int[] dy = {1, 0, 0, -1};

		Queue<int[]> q = new LinkedList<>();
		boolean[][][] visited = new boolean[n][m][2]; // 0, 1
		q.add(new int[] {0, 0, 1, 0}); //x, y, dis, jump

		while (!q.isEmpty()) {
			int[] poll = q.poll();
			if (poll[0] == n - 1 && poll[1] == m - 1)
				return poll[2];
			int x = poll[0], y = poll[1];
			int dis = poll[2];
			int jump = poll[3];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < n && ny < m
					&& !visited[nx][ny][jump] && map[nx][ny] == 0) {
					visited[nx][ny][jump] = true;
					q.add(new int[] {nx, ny, dis + 1, jump});
				} else if (nx >= 0 && ny >= 0 && nx < n && ny < m
					&& map[nx][ny] == 1 && jump == 0 && !visited[nx][ny][1]) {
					visited[nx][ny][1] = true;
					q.add(new int[] {nx, ny, dis + 1, 1});
				}
			}

		}

		return -1;
	}
}
