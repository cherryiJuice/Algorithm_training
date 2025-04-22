import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	private int[] solution(int[] arr) {
		int[] answer = new int[arr.length];
		Deque<Integer> stack = new ArrayDeque<>();

		for (int i = 0; i < arr.length; i++) {
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				int pop = stack.pop();
				answer[pop] = arr[i];
			}
			stack.push(i);
		}
		for (int i = 0; i < answer.length; i++) {
			if(answer[i] == 0) {
				answer[i] = -1;
			}
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();

		Main sol17298 = new Main();
		int[] solution = sol17298.solution(arr);
		for (int i = 0; i < n; i++) {
			sb.append(solution[i]).append(" ");
		}

		System.out.println(sb);
	}
}
