class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
		int countP = 0, countY = 0;

		countP = s.length() - s.replaceAll("p", "").length();
		countY = s.length() - s.replaceAll("y", "").length();
		if (countP == countY) return true;
		else return false;
    }
}