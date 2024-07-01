import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String player : participant) {
            // Key에 해당하는 Value가 있으면 가져오고, 아닐 경우 0을 Default로 지정
            // 이름이 같은사람이 둘이면 key값은 그대로, count는 2가 됨
            map.put(player, map.getOrDefault(player, 0) + 1);
        }
        
        for (String player : completion) {
            // HashMap에서 완주자들을 제외
            map.put(player, map.get(player) - 1);
        }
        
        for (String key : map.keySet()) {
            //  HashMap을 한번 돌면서 Value가 0이 아닌 사람 (완주자)를 찾는다.

            if (map.get(key) > 0) {
                return key;
            }
        }
        
        return null;
    }
}