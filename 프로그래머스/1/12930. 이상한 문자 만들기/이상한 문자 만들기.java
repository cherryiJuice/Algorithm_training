class Solution {
    public String solution(String s) {
        String[] strings = s.split("");
		String answer = "";
		int k = 0;
		for (String st : strings) {
			if(st.equals(" ")){
				k = 0;
                answer += " ";
				continue;
			}
			if(k % 2 == 0) {
				answer += st.toUpperCase();
				k++;
			} else {
				answer += st.toLowerCase();
				k++;
			}
		}
		return answer;
    }
}