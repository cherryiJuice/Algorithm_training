import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	private String[] solution(int n, int[] arr) {
		String[] answer = new String[n * 2];
		Stack<Integer> stack = new Stack<>();
		int k = 1, index = 0;

		for (int i = 0; i < n; i++) {
			if (arr[i] >= k) {
				for (int j = k; j <= arr[i]; j++) {
					stack.push(j);
					answer[index++] = "+";
					k++;
				}
			}
			// if(stack.isEmpty())
			// 	return null;
			int pop = stack.pop();
			if(pop != arr[i]) return null;
			answer[index++] = "-";
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Main sol1874 = new Main();
		String[] solution = sol1874.solution(n, arr);
		if(solution == null) {
			System.out.println("NO");
		}
		else {
			for (String s : solution) {
				System.out.println(s);
			}
		}

	}
}
