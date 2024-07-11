import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        
        // 각 작업이 완료되는 날짜를 Queue에 추가
        for (int i = 0; i < progresses.length; i++) {
            int remainingWork = 100 - progresses[i];
            int days = (int) Math.ceil((double) remainingWork / speeds[i]);
            queue.add(days);
        }
        
        List<Integer> answerList = new ArrayList<>();
        
        // Queue를 사용하여 배포 작업을 계산
        while (!queue.isEmpty()) {
            int currentDay = queue.poll();
            int count = 1;
            
            // 같은 날 배포될 작업의 수를 계산
            while (!queue.isEmpty() && queue.peek() <= currentDay) {
                queue.poll();
                count++;
            }
            
            answerList.add(count);
        }
        
        // 결과를 배열로 변환하여 반환
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}