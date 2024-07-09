import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        // 키는 장르, 값은 해당 장르의 총 재생 횟수
        HashMap<String, Integer> num = new HashMap<>();
        // 키는 장르, 값은 또 다른 해시맵(노래의 고유 번호를 키, 재생 횟수를 값으로 갖는 해시맵
        HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>();
        
        for(int i=0; i<plays.length; i++) {
            // genres[i](현재 인덱스의 장르)가 키로 존재하지 않는다면, 즉 새로운 장르라면
            if(!num.containsKey(genres[i])) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                music.put(genres[i], map);
                num.put(genres[i], plays[i]);
            // 새로운 장르가 아니라면
            } else {
                // 	music 해시맵에서 genres[i] 키로 저장된 해시맵을 가져와서,
                // 해시맵에 현재 인덱스 i(노래의 고유 번호)를 키로, plays[i](노래의 재생 횟수)를 값으로 저장
                music.get(genres[i]).put(i, plays[i]);
                // 총 재생 횟수를 갱신
                num.put(genres[i], num.get(genres[i]) + plays[i]);
            }
        }
 
        List<String> keySet = new ArrayList(num.keySet());
        Collections.sort(keySet, (s1, s2) -> num.get(s2) - (num.get(s1)));
 
        for(String key : keySet) {
            // music 해시맵에서 key(현재 장르)를 키로 저장된 해시맵을 가져와서 map 변수에 저장
            // 이 해시맵은 현재 장르에 속하는 노래의 고유 번호와 재생 횟수를 저장
            HashMap<Integer, Integer> map = music.get(key);
            List<Integer> genre_key = new ArrayList(map.keySet());
 
            Collections.sort(genre_key, (s1, s2) -> map.get(s2) - (map.get(s1)));
 
            answer.add(genre_key.get(0));
            // 두 번째 노래가 존재한다면 두 번째 요소 (재생 횟수가 두 번째로 많은 노래의 고유 번호)를 a                nswer 리스트에 추가
            if(genre_key.size() > 1)
                answer.add(genre_key.get(1));
        }
 
        return answer.stream().mapToInt(i -> i).toArray();
    }
}