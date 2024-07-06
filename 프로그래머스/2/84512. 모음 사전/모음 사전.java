import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final char[] CHARS = {'A', 'E', 'I', 'O', 'U'};

    public int solution(String word) {
        List<String> list = new ArrayList<>();
        generate("", list);
        return list.indexOf(word);
    }

    private void generate(String word, List<String> words) {
        words.add(word);

        if(word.length() == 5) return;
        for (char c : CHARS) {
            generate(word + c, words);
        }
    }
}