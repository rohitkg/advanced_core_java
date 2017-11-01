package concordance;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Concordance {
  static final Pattern WORD_BREAKS = Pattern.compile("\\W+");
  
  public static void main(String[] args) throws Throwable {
    try (Stream<String> lines = Files.lines(Paths.get("PrideAndPrejudice.txt"))) {
      lines
          .flatMap(WORD_BREAKS::splitAsStream)
          .filter(s -> s.length() > 0)
          .map(String::toLowerCase)
          .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
          .entrySet().stream()
//          .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
          .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
          .limit(200)
          .map(e -> String.format("%20s : %5d", e.getKey(), e.getValue()))
          .forEach(System.out::println);
    }
  }
}
