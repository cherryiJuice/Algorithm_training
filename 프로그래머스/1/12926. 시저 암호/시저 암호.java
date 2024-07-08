class Solution {
    public String solution(String s, int n) {
        char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if(chars[i] >= 'A' && chars[i] <= 'Z') {
				chars[i] = (char)(((chars[i]-'A' + n) % 26)+'A');
			} else if(chars[i] >= 'a' && chars[i] <='z') {
                chars[i] = (char)(((chars[i]-'a' + n) % 26)+'a');
			}
		}
		return new String(chars);
    }
}