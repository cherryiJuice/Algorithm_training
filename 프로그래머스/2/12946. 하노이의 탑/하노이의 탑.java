import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] solution(int n) {

        List<int[]> list = new ArrayList<>();
        hanoi(n, 1, 3, 2, list);

        
        return list.toArray(new int[0][]);
    }

    private void hanoi(int n, int from, int to, int temp, List<int[]> process) {
        if(n == 1) {
            process.add(new int[] {from, to});
            return;
        }
        hanoi(n - 1, from, temp, to, process);
        hanoi(1, from, to, temp, process);
        hanoi(n - 1, temp, to, from, process);

    }
}
