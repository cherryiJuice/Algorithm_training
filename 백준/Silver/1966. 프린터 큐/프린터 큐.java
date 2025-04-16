import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private int solution(int n, int m, int[] arr) {
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			q.offer(new int[] {i, arr[i]});
			pq.offer(arr[i]);
		}

		while(!q.isEmpty()) {
			int[] current = q.poll();

			// 우선순위 값과 비교
			if(current[1] < pq.peek()) {  // 우선순위 값보다 작으면
				q.offer(current); // 다시 넣기
			} else { // 크다면 우선순위 큐 값 빼고 순서 늘리기
				pq.poll();
				answer++;
				if(current[0] == m) { // target과 같을 때 return
					return answer;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		Main sol1966 = new Main();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int testCnt = Integer.parseInt(br.readLine());

		for (int i = 0; i < testCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			int result = sol1966.solution(n, m, arr);
			sb.append(result).append("\n");
		}

		System.out.print(sb);
	}
}
