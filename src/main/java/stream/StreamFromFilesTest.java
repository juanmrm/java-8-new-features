package stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamFromFilesTest {

    public static void main(String[] args) {

        Path dir = Paths.get("src");
        System.out.printf("%nThe file tree for %s%n", dir.toAbsolutePath());
        try (Stream<Path> fileTree = Files.walk(dir)) {
            fileTree.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path path = Paths.get("src", "main", "java", "stream", "StreamFromFilesTest.java");
        try(BufferedReader br = Files.newBufferedReader(path)){
            br.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path newPath = Paths.get("src", "main", "java", "stream", "NewStreamTest.txt");
        try (BufferedReader br = Files.newBufferedReader(path); BufferedWriter bw = Files.newBufferedWriter(newPath)) {
            br.lines().forEach(l -> {
                try {
                    bw.write(l);
                    bw.newLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
