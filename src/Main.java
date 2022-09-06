import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    // count words
    static void findCountOfEntrance() {
        //Set;

        String str = "ONE, TWO, THRE, SIX, FIVE, SIX, ONEEE";
        String words = "ONE, SIX, ONE";

        // streams
        String[] arrStr = str.split(",");
        String[] arrWords = words.split(",");

        // count words
//        Map<String,Long> collect = wordsList.stream()
//                .collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ));

        Map<String, Long> map = Arrays.stream(arrStr)
                //.sorted(Comparator.reverseOrder())
                .collect(Collectors.groupingBy( //Function.identity()
                        el -> {
                            if (Arrays.stream(arrWords).filter(e -> e.equals(el)).findAny().isPresent())
                                return el;
                            return "";
                        }
                        , Collectors.counting()
                ));

        Map<String, Long> map2 = map.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder())) //(c1, c2) -> c1.getValue().compareTo(c2.getValue())
                //.sorted(Map.Entry.comparingByValue().reversed()) //(c1, c2) -> c1.getValue().compareTo(c2.getValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue
                        , (e1, e2) -> {
                            throw new IllegalStateException();
                            //e1// + e2
                        }
                        , LinkedHashMap::new
                ));

        int a = 1;

        //ONE - 1
        //SIX - 2
    }


    public static void main(String[] args) {
        findCountOfEntrance();
    }
}
