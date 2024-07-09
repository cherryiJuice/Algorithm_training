class Solution {
    public int solution(int n) {
        String string = Integer.toString(n, 3);
		StringBuilder stringBuilder = new StringBuilder(string);
		String s = stringBuilder.reverse().toString();
		return Integer.parseInt(s, 3);
    }
}