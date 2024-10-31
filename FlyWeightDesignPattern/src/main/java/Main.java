import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Main {
    public static void main(String[] args) {

        DocumentCharacter documentCharacter_t1 = LetterFactory.createCharacter('t');
        documentCharacter_t1.display(0,0);

        DocumentCharacter documentCharacter_t2 = LetterFactory.createCharacter('t');
        documentCharacter_t2.display(2,2);

//        List<Integer> list = new ArrayList<>();
//        list.add(10);
//        list.add(20);
//        list.add(60);
//        list.add(70);
//        list.add(60);
//        list.add(70);
//        list.add(60);
//        list.add(70);
//        list.add(50);
//
//        Map<Integer, Long> map = list.stream().collect(groupingBy(Function.identity(), Collectors.counting()));
//
//        int uniqueSum = list.stream().filter((item) -> map.get(item) == 1).mapToInt(n -> n).sum();
//        System.out.println(uniqueSum);
    }
}
