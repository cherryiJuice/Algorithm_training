class Solution {
    public int[] solution(long n) {
		StringBuilder sb = new StringBuilder(String.valueOf(n)).reverse();
		int[] answer = new int[sb.length()];
		for (int i = 0; i < sb.length(); i++) {
			answer[i] = sb.charAt(i)-'0';
		}
		return answer;
	}
}