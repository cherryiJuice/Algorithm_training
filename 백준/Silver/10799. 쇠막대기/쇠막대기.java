import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	private int solution(String st) {
		Stack<Character> stack = new Stack<>();
		int cnt = 0;

		for (int i = 0; i < st.length(); i++) {
			if (st.charAt(i) == '(') {
				stack.push('(');
			} else {
				stack.pop();
				if(st.charAt(i-1) == '(') { // 레이저일 경우
					cnt += stack.size(); // 막대 만큼 더하기
				} else cnt++; // 나무일 경우 안 잘려도 한개임
			}

		}

		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String st = br.readLine();
		Main sol10799 = new Main();

		int solution = sol10799.solution(st);
		System.out.println(solution);

	}
}
