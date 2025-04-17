import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	private int[] solution(String W, int K) {
		Map<Character, List<Integer>> map = new HashMap<>();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < W.length(); i++) {
			List<Integer> list = map.getOrDefault(W.charAt(i), new ArrayList<>());
			list.add(i);
			map.put(W.charAt(i), list);
		}

		for (char c : map.keySet()) {
			List<Integer> list = map.get(c);
			if (list.size() >= K) {
				for (int i = 0; i <= list.size() - K; i++) {
					int length = list.get(i + K - 1) - list.get(i) + 1;
					min = Math.min(min, length);
					max = Math.max(max, length);
				}
			}
		}
		if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE)
			return null;

		return new int[] {min, max};
	}

	public static void main(String[] args) throws IOException {
		Main sol20437 = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String W = br.readLine();
			int K = Integer.parseInt(br.readLine());
			int[] solution = sol20437.solution(W, K);
			if (solution == null)
				sb.append(-1).append('\n');
			else
				sb.append(solution[0]).append(" ").append(solution[1]).append("\n");
		}

		System.out.println(sb);
	}
}
