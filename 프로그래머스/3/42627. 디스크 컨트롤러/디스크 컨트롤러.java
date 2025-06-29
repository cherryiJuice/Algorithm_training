import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0])); // 요청 시각 기준 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // 처리 시간 기준

        int time = jobs[0][0];
        int total = 0;
        int index = 0;
        int count = 0;

        while (count < jobs.length) {
            // 현재 시점까지 들어온 작업 모두 추가
            while (index < jobs.length && jobs[index][0] <= time) {
                pq.offer(jobs[index]);
                index++;
            }

            if (!pq.isEmpty()) {
                int[] job = pq.poll();
                time += job[1]; // 처리 시간만큼 시간 증가
                total += (time - job[0]); // (완료 시점 - 요청 시각)
                count++;
            } else {
                // 아직 도착한 작업이 없다면 시간 1 증가
                time = jobs[index][0];
            }
        }

        return total / jobs.length;
    }
}
