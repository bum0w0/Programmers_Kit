import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        // HashSet을 사용하여 폰켓몬 종류의 중복을 제거
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // 선택할 수 있는 폰켓몬의 수는 N/2
        int maxSelection = nums.length / 2;
        
        // 폰켓몬 종류의 수
        int numOfTypes = set.size();
        
        // 선택할 수 있는 폰켓몬 종류의 최대 개수는 maxSelection 또는 numOfTypes 중 작은 값
        return Math.min(maxSelection, numOfTypes);
    }
}