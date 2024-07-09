class Solution {
    public int[] solution(String s) {
        int countZero=0, i=0;
		String temp = "";


		while (!temp.equals("1")) {
			i++;
			temp = s.replace("0", "");
			countZero += s.length()-temp.length();
			s= Integer.toString(temp.length(), 2);
		}

		return new int[] {i,countZero};
    }
}