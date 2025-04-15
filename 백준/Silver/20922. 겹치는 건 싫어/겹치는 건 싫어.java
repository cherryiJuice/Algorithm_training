import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	private int solution(int n, int k, int[] arr) {
		int answer = 0;
		int lt = 0;
		Map<Integer, Integer> map = new HashMap<>();

		for (int rt = 0; rt < n; rt++) {
			map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);

			while (map.get(arr[rt]) > k) {
				map.put(arr[lt], map.get(arr[lt]) - 1);
				lt++;
			}

			answer = Math.max(answer, rt - lt + 1);
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Main sol20922 = new Main();
		int solution = sol20922.solution(n, k, arr);
		System.out.println(solution);
	}
}
