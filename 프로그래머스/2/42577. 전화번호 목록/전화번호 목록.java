import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean solution(String[] phoneBook) {
        
        Set<String> set = new HashSet<>();

        // 모든 전화번호를 HashSet에 넣기
        for (String phone : phoneBook) {
            set.add(phone);
        }

        // 전화번호의 substring이 HashSet에 존재하는지 확인 (접두어인 경우 확인)
        for (String phone : phoneBook) {
            for (int j = 1; j < phone.length(); j++) {
                if (set.contains(phone.substring(0, j))) {
                    return false;
                }
            }
        }

        return true;
    }
}