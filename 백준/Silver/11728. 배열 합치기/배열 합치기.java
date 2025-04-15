import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private int[] solution(int n, int m, int[] a, int[] b) {
		int[] answer = new int[n + m];
		int i1 = 0, i2 = 0;
		int k = 0;
		while (i1 < n && i2 < m) {
			if (a[i1] < b[i2]) {
				answer[k++] = a[i1++];
			} else {
				answer[k++] = b[i2++];
			}
		}

		if (i1 < n) {
			for (int i = k; i < m + n; i++) {
				answer[i] = a[i1++];
			}
		}
		if(i2 < m) {
			for (int i = k; i < m + n; i++) {
				answer[i] = b[i2++];
			}
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		Main sol11728 = new Main();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int [] a = new int[n];
		int [] b = new int[m];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}

		int[] solution = sol11728.solution(n, m, a, b);
		for (int i = 0; i < solution.length; i++) {
			sb.append(solution[i]).append(" ");
		}
		System.out.print(sb);
	}


}
