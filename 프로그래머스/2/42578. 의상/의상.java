import java.util.*;
import static java.util.stream.Collectors.*;

class Solution {
    public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
                // 의상 종류별로 그룹화하고, 각 그룹의 개수를 셉니다.
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                // 각 그룹의 개수에 1을 더한 후 모두 곱합니다.
                .collect(reducing(1L, (x, y) -> x * (y + 1)))
                // int로 변환하고, 모든 의상을 입지 않는 경우를 제외합니다.
                .intValue() - 1;
    }
}