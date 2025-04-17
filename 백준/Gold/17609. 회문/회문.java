import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private int isPalindrome(String s, int lt, int rt, boolean isSkipped) {
		while (lt < rt) {
			if (s.charAt(lt) == s.charAt(rt)) {
				lt++;
				rt--;
			} else {
				if (isSkipped)
					return 2;
				// lt 옮겨보기
				int l = isPalindrome(s, lt + 1, rt, true);
				// rt 옮겨보기
				int r = isPalindrome(s, lt, rt - 1, true);
				return Math.min(l, r); // 회문인것 만 선택
			}
		}
		return isSkipped ? 1 : 0;
	}

	public static void main(String[] args) throws IOException {
		Main sol17609 = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			int solution = sol17609.isPalindrome(s, 0, s.length() - 1, false);
			sb.append(solution).append("\n");
		}
		System.out.println(sb);
	}
}
