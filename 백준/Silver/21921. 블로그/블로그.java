import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private int[] solution(int n, int m, int[] arr) {
		int cnt = 1;
		int sum = 0;
		for (int i = 0; i < m; i++) {
			sum += arr[i];
		}
		int max = sum;

		for (int lt = 0, rt = m; rt < n; lt++, rt++) {
			sum -= arr[lt];
			sum += arr[rt];
			if (sum == max) {
				cnt++;
			} else if (sum > max) {
				cnt = 1;
				max = sum;
			}
		}

		return new int[] {max, cnt};
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Main sol21921 = new Main();
		int[] solution = sol21921.solution(n, m, arr);
		if (solution[0] == 0)
			System.out.println("SAD");
		else {
			System.out.println(solution[0]);
			System.out.println(solution[1]);
		}

	}
}
