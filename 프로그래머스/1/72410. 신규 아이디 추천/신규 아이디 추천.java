class Solution {
    public String solution(String new_id) {
        while (true) {
					new_id = new_id.toLowerCase();
					new_id = new_id.replaceAll("[^a-z0-9._-]", "");
					new_id = new_id.replaceAll("\\.{2,}", ".");
					new_id = new_id.replaceAll("(^\\.)|(\\.$)", "");
					if(new_id.isEmpty()){
						new_id = "a";
						// continue;
					}
					if (new_id.length() > 15) {
						new_id = new_id.substring(0, 15);
						continue;
					}
					if (new_id.length() < 3) {
						new_id += new_id.substring(new_id.length() - 1);
						continue;
					}
					break;
				}

				return new_id;
    }
}