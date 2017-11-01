package hello;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class BookReader {
	public static void main(String[] args) throws Exception{
		Map<String, Long> wordCount = Files.lines(FileSystems.getDefault().getPath("", "pg42671.txt"))
					.flatMap(s -> Arrays.asList(s.split(" ")).stream())
					.filter(s -> s.length() > 0)
					.collect(Collectors.groupingBy(s -> s, Collectors.counting()))
					;
					
					//.forEach(e -> System.out.println(e));
		wordCount.entrySet().stream()
			.sorted((e1, e2) -> 0 - Long.compare(e1.getValue(), e2.getValue()))
			.limit(200)
			.forEach(e -> System.out.println(e.getKey() + ", " + e.getValue()));
	}
}
