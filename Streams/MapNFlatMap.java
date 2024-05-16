package Streams;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MapNFlatMap {
    public static void main(String[] args) {
        List<String> list = List.of("abcdef",
                "ab",
                "fbi",
                "govt",
                "scaler",
                "java");
        List<Integer> res = list.stream().map(String::length).collect(Collectors.toList());
        System.out.println(res);

        List<List<Integer>> flatmap = List.of(List.of(4,6,8),List.of(3,5,7),List.of(2,3,5));
        List<Integer> distinct = flatmap.stream().flatMap(num->num.stream()).distinct().collect(Collectors.toList());
        System.out.println(distinct);

    }
}
