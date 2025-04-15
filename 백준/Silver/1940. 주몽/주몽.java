import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

	private int solution(int n, int m, int[] arr) {
		Arrays.sort(arr);
		int lt = 0, rt = n - 1;
		int answer = 0;
		while (lt < rt) {
			if (arr[lt] + arr[rt] == m) {
				answer++;
				lt++;
			}
			else if(arr[lt] + arr[rt] < m) {
				lt++;
			} else {
				rt--;
			}
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		Main sol1940 = new Main();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int answer = sol1940.solution(n, m, arr);
		System.out.print(answer);
	}
}
