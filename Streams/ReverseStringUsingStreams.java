package Streams;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseStringUsingStreams {
    public static void main(String[] args) {
        String str = "SaiCharan";
        String res = new StringBuilder(str).reverse().toString();

        IntStream.range(0,str.length()-1)
                .mapToObj(i-> str.charAt(str.length()-1-i))
                .map(Object::toString)
                .collect(Collectors.joining());

        str.chars()
                .mapToObj(ch->(char) ch)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list ->{
                            Collections.reverse(list);
                            return list.stream();
                        }
                )).map(String::valueOf).collect(Collectors.joining());

    }
}
