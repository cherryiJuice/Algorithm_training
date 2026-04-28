class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playSec = toTotalSecond(play_time);
        int advSec = toTotalSecond(adv_time);
        long[] dp = new long[playSec + 1];
        
        // 1. 변화량 기록
        for (String log : logs) {
            String[] split = log.split("-");
            int start = toTotalSecond(split[0]);
            int end = toTotalSecond(split[1]);
    
            dp[start]++;
            dp[end]--;
        }

        // 2. 실제 시청자 수
        for (int i = 1; i <= playSec; i++) {
            dp[i] = dp[i] + dp[i - 1]; 
        }
        
        // 3. 0초부터 i초까지의 누적 합
        for (int i = 1; i <= playSec; i++) {
            dp[i] += dp[i - 1];
        }
        
        // 4. 슬라이딩 윈도우로 가장 많이 본 구간 찾기
        long maxTotalTime = dp[advSec - 1];
        int bestStart = 0;

        for (int i = advSec; i <= playSec; i++) {
            // i초에 끝나는 광고의 누적 시간 = (0~i까지 합) - (0~i-advSec까지 합)
            long currentTotalTime = dp[i] - dp[i - advSec];
            if (currentTotalTime > maxTotalTime) {
                maxTotalTime = currentTotalTime;
                bestStart = i - advSec + 1;
            }
        }

        return formatTime(bestStart);
    }
    
    private int toTotalSecond(String time) {
        String[] hms = time.split(":");
        return Integer.parseInt(hms[0]) * 3600 + 
               Integer.parseInt(hms[1]) * 60 + 
               Integer.parseInt(hms[2]);
    }

    private String formatTime(int totalSecond) {
        int h = totalSecond / 3600;
        int m = (totalSecond % 3600) / 60;
        int s = totalSecond % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}