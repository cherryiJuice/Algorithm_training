import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public String solution(int[] numbers) {
        return Arrays.stream(numbers).mapToObj(String::valueOf)
                .sorted((v1, v2) -> {
            String s1 = String.valueOf(v1) + String.valueOf(v2);
            String s2 = String.valueOf(v2) + String.valueOf(v1);
            return s2.compareTo(s1);
        }).collect(Collectors.joining())
            .replaceAll("^0+", "0");
    }
}