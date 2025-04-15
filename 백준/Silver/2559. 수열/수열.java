import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private int solution(int n, int m, int[] arr) {
		int answer = Integer.MIN_VALUE;
		int lt = 0;

		while (lt + m <= n) {
			int sum = 0;
			for (int i = lt; i < lt + m; i++) {
				sum += arr[i];
			}
			if (answer < sum)
				answer = sum;
			lt++;
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		Main sol2559 = new Main();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int answer = sol2559.solution(n, m, arr);
		System.out.print(answer);
	}
}
