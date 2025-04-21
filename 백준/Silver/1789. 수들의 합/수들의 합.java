import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private long solution(long s) {
		long sum = 0;

		for (long i = 1; i <= s; i++) {
			sum += i;
			if (sum > s) {
				return i - 1;
			} else if (sum == s)
				return i;
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine());

		Main sol1789 = new Main();
		long solution = sol1789.solution(S);
		System.out.println(solution);
	}
}
