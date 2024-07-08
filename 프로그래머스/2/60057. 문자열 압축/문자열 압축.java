class Solution {
	public int solution(String s) {
        if(s.length() == 1) return 1;
		StringBuilder sb = new StringBuilder();
		int[] answer = new int[s.length() - 1];
		answer[0] = s.length();

		for (int i = 1; i < s.length() - 1; i++) {
			int len = s.length() % i == 0? s.length()/i: s.length() / i + 1;
			String[] token = new String[len];
			for (int j = 0, k = 0; j < s.length(); j += i, k++) {
				if (j + i >= s.length()) {
					token[k] = s.substring(j);
				}
				else {
					token[k] = s.substring(j, j + i);
				}
			}
			int count = 1;
			for (int j = 0; j < token.length; j++) {
				if (j < token.length - 1 && token[j].equals(token[j + 1])) {
					count++;
				} else {
					if (count > 1) {
						sb.append(count).append(token[j]);
					} else {
						sb.append(token[j]);
					}
					count = 1;
				}
			}
			answer[i] = sb.length();
			sb.delete(0, sb.length());
		}

		int min = s.length();
		for (int i = 0; i < answer.length; i++) {
			if (min > answer[i]) {
				min = answer[i];
			}
		}
		return min;
	}
}